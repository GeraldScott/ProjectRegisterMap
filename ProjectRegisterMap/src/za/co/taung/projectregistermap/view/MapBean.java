package za.co.taung.projectregistermap.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import za.co.taung.projectregistermap.model.Address;
import za.co.taung.projectregistermap.model.GeoCode;
import za.co.taung.projectregistermap.model.Organisation;
import za.co.taung.projectregistermap.model.Place;

@ManagedBean
@ViewScoped
public class MapBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private MapModel model;
	private Marker marker;
	private String centre = "-30.590260, 25.522092"; // Gariep Dam is the most central point of South Africa

	private String orgType = "ALL"; // TODO: pass this from the form

	public MapBean() {

		/*
		 * Create JPA entity manager
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectRegisterMap");
		EntityManager em = emf.createEntityManager();

		/*
		 * Create the map model, centred on Gariep Dam
		 */
		model = new DefaultMapModel();
		String[] myLatLong = null;
		myLatLong = centre.split(",");
		double latitude = Double.parseDouble(myLatLong[0]);
		double longitude = Double.parseDouble(myLatLong[1]);
		LatLng mostCentralPoint = new LatLng(latitude, longitude); // These are doubles
		model.addOverlay(new Marker(mostCentralPoint, "Gariep Dam, the most central point of South Africa"));

		/*
		 * Get list of all geocodes
		 */
		List<GeoCode> myGeoCodes = new ArrayList<GeoCode>();
		TypedQuery<GeoCode> query = em.createQuery("SELECT c FROM GeoCode c", GeoCode.class);
		myGeoCodes = query.getResultList();

		/*
		 * Iterate over list, selecting the organisation type
		 */
		//		for (Organisation myorg:organisations){
		//			if (myorg.getOrganisationTypeBean().getType().equals(orgType)||orgType.equals("ALL")){
		//				List<Address> addresses = myorg.getAddresses();
		//				boolean isMarkerPlaced = false; // Need a switch because organisations can have both street and postal addresses, so don't place the marker twice
		//				for (Address address:addresses){
		//						String myGrowl = address.getFirstLine()+" "+address.getSecondLine()+"\n"+address.getPlaceBean().getTown();
		//						model.addOverlay(new Marker(new LatLng(
		//								myGeoCode.getLatitude(), myGeoCode.getLongitude()), 
		//								address.getOrganisationBean().getName(), // Title of marker, shown on roll-over
		//								myGrowl)); // Data load for displaying in growl on marker select
		//						isMarkerPlaced = true;
		//					}
		//				}
		//
		//			}
		//		}
		Map<Integer,Organisation>mappedOrganisations = new HashMap<Integer,Organisation>(); // Keep a list of organisations that have been mapped to avoid mapping more than once
		for (GeoCode myGeoCode:myGeoCodes){
			List<Place> myPlaces = myGeoCode.getPlaces();
			for (Place myPlace:myPlaces){
				List<Address> myAddresses = myPlace.getAddresses();
				for (Address myAddress:myAddresses){
					if (myAddress.getOrganisationBean().getOrganisationTypeBean().getType().equals(orgType)||orgType.equals("ALL")) {
						if (!mappedOrganisations.containsKey(myAddress.getOrganisationBean().getId())){ // Only map if it is not in the list
							String myGrowl = myAddress.getFirstLine()+" "+myAddress.getSecondLine()+"\n"+myAddress.getPlaceBean().getTown();
							model.addOverlay(new Marker(new LatLng(
									myGeoCode.getLatitude(), myGeoCode.getLongitude()), 
									myAddress.getOrganisationBean().getName(), // Title of marker, shown on roll-over
									myGrowl)); // Data load for displaying in growl on marker select
							mappedOrganisations.put(myAddress.getOrganisationBean().getId(), myAddress.getOrganisationBean()); // Note that it has been mapped
						}
					}
				}
			} 
		}
	}

	public String getCentre() {
		return centre;
	}

	public MapModel getModel() {
		return model;
	}

	public Marker getMarker() {
		return marker;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
		String myData = (String) marker.getData();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
				marker.getTitle(), myData));
	}

	public void selectMarker(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
	}
}
