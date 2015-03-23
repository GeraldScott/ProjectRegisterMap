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

	private List<GeoCode> myGeoCodes = null;
	private List<Place> myPlaces = null;
	private List<Address> myAddresses = null;
	
	public MapBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectRegisterMap");
		EntityManager em = emf.createEntityManager();

		model = new DefaultMapModel();

		String[] myLatLong = null;
		myLatLong = centre.split(",");
		double latitude = Double.parseDouble(myLatLong[0]);
		double longitude = Double.parseDouble(myLatLong[1]);
		LatLng mostCentralPoint = new LatLng(latitude, longitude); // These are doubles
		model.addOverlay(new Marker(mostCentralPoint, "Most central point of South Africa"));

		myGeoCodes = new ArrayList<GeoCode>();
		TypedQuery<GeoCode> query = em.createQuery("SELECT c FROM GeoCode c", GeoCode.class);
		myGeoCodes = query.getResultList();

		for (GeoCode myGeoCode:myGeoCodes){
			myPlaces = myGeoCode.getPlaces();
			for (Place myPlace:myPlaces){
				myAddresses = myPlace.getAddresses();
				for (Address myAddress:myAddresses){
					String myData = myAddress.getFirstLine()+" "+myAddress.getSecondLine()+"\n"+
							myAddress.getPlace().getSuburb()+" "+myAddress.getPlace().getName();
					model.addOverlay(new Marker(new LatLng(
							myGeoCode.getLatitude(), myGeoCode.getLongitude()), 
							myAddress.getOrganisation().getName(), // Title of marker, shown on roll-over
							myData)); // Data load for displaying in growl on marker select
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
