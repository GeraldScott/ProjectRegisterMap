package za.co.taung.projectregistermap.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import za.co.taung.projectregistermap.model.Address;
import za.co.taung.projectregistermap.model.GeoCode;
import za.co.taung.projectregistermap.model.Place;

@ManagedBean
@RequestScoped
public class ProjectMap {
	private MapModel simpleModel;
	private String centre = "-30.590260, 25.522092"; // Gariep Dam is the most central point of South Africa

	@PostConstruct
	public void init() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectRegisterMap");
		EntityManager em = emf.createEntityManager();

		simpleModel = new DefaultMapModel();

		String[] myLatLong = null;
		myLatLong = centre.split(",");
		double latitude = Double.parseDouble(myLatLong[0]);
		double longitude = Double.parseDouble(myLatLong[1]);
		LatLng mostCentralPoint = new LatLng(latitude, longitude); // These are doubles
		simpleModel.addOverlay(new Marker(mostCentralPoint, "Most central point of South Africa"));

		List<GeoCode> myGeoCodes = new ArrayList<GeoCode>();
		TypedQuery<GeoCode> query = em.createQuery("SELECT c FROM GeoCode c", GeoCode.class);
		myGeoCodes = query.getResultList();

		System.out.println("GeoCodes: "+myGeoCodes.size());
		
		for (GeoCode myGeoCode:myGeoCodes){
			List<Place> myPlaces = myGeoCode.getPlaces();
			for (Place myPlace:myPlaces){
				List<Address> myAddresses = myPlace.getAddresses();
				for (Address myAddress:myAddresses){
					simpleModel.addOverlay(new Marker(new LatLng(
							myGeoCode.getLatitude(), 
							myGeoCode.getLongitude()), 
							myAddress.getOrganisationBean().getName()));
					
				}
				
			}
			
		}
		

	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public String getCentre() {
		return centre;
	}


}
