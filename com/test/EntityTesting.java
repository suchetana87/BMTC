package com.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.data.orm.entity.BusStop;
import com.data.orm.entity.GeneralServiceFares;
import com.data.orm.entity.Routes;
import com.data.orm.entity.Schedules;


public class EntityTesting {

	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    throw new RuntimeException(ex);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected void createBusStop() {
        // code to save a busstop
    	BusStop busStop = new BusStop();
    	busStop.setBusStopId(3);
    	busStop.setBusStopName("HSR Layout");
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(busStop);
    	
    	session.getTransaction().commit();
        session.close();
    }
    
    protected void createRoute() {
        // code to save a busstop
    	Routes routes = new Routes();
    	routes.setRoute_no("2");
    	routes.setDistance(20.1f);
    	routes.setTotal_bus_stops(10);
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(routes);
    	
    	session.getTransaction().commit();
        session.close();
    }
    
    protected void createSchedule() {
        // code to save a schedules
    	Schedules schedules1 = new Schedules();
    	Schedules schedules2 = new Schedules();
    	
    	//BusStop busStop1 = fetchBusStop(1);
    	BusStop busStop1 = new BusStop();
    	busStop1.setBusStopId(1);
    	busStop1.setBusStopName("BTM Layout");
    	
    	//BusStop busStop2 = fetchBusStop(2);
    	BusStop busStop2 = new BusStop();
    	busStop2.setBusStopId(2);
    	busStop2.setBusStopName("Silkboard");
    	
    	BusStop busStop3 = new BusStop();
    	busStop3.setBusStopId(3);
    	busStop3.setBusStopName("Banashankari");
    	
    	//Routes routes = fetchRoute("3");
    	Routes routes1 = new Routes();
    	routes1.setRoute_no("1");
    	routes1.setTotal_bus_stops(8);
    	routes1.setDistance(12.4f);
    	routes1.setOrigin_bus_stop_id(busStop1);
    	routes1.setDestination_bus_stop_id(busStop2);
    	
    	Routes routes2 = new Routes();
    	routes2.setRoute_no("2");
    	routes2.setTotal_bus_stops(10);
    	routes2.setDistance(20.4f);
    	routes2.setOrigin_bus_stop_id(busStop1);
    	routes2.setDestination_bus_stop_id(busStop3);
    	
    	schedules1.setSchedules_id(1);
    	
    	schedules1.setRoute_no(routes1);
    	schedules1.setArrival_at_destination("11.00-AM");
    	schedules1.setDeparture_from_origin("9.00-AM");
    	schedules1.setDuration(2);
    	
    	schedules2.setSchedules_id(2);
    	schedules2.setRoute_no(routes2);
    	schedules2.setArrival_at_destination("11.00-AM");
    	schedules2.setDeparture_from_origin("8.00-AM");
    	schedules2.setDuration(3);
    	
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	/*session.persist(busStop1);
    	session.persist(busStop2);
    	session.persist(routes);*/
    	
    	session.save(busStop1);
    	System.out.println("busStop1 Saved..");
    	session.save(busStop2);
    	System.out.println("busStop2 Saved..");
    	session.save(busStop3);
    	System.out.println("busStop3 Saved..");
    	
    	session.persist(routes1);
    	System.out.println("routes1 Saved..");
    	session.persist(routes2);
    	System.out.println("routes2 Saved..");
    	
    	session.persist(schedules1);
    	System.out.println("schedules1 Saved..");
    	session.persist(schedules2);
    	System.out.println("schedules2 Saved..");
    	
    	session.getTransaction().commit();
        session.close();
    }
 
    protected BusStop fetchBusStop(int bustop_id) {
        // code to get a busstop
    	return sessionFactory.openSession().get(BusStop.class, bustop_id);
    }
    
    protected Routes fetchRoute(String route_no) {
        // code to get a route
    	return sessionFactory.openSession().get(Routes.class, route_no);
    }
 
    protected Schedules fetchSchedule(int schedule_id) {
        // code to get a route
    	return sessionFactory.openSession().get(Schedules.class, schedule_id);
    }
    
    protected void updateBusStop() {
        // code to modify a bus stop
    }
 
    protected void deleteBusStop(BusStop busStop) {
        // code to remove a bus stop
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(busStop);
    	session.getTransaction().commit();
    	session.close();
    }
    
    protected void deleteRoutes(Routes routes) {
        // code to remove a route
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(routes);
    	session.getTransaction().commit();
    	session.close();
    }
    
    protected void deleteSchedule(Schedules schedules) {
        // code to remove a schedule
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(schedules);
    	session.getTransaction().commit();
    	session.close();
    }
 
    private void saveBusfare(){
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
        Busfare busfare = new Busfare();
    	
    	List<GeneralServiceFares> generalServicesList = busfare.createBusfare();
    	
    	for (int i = 0; i < generalServicesList.size(); i++) 
		{
    		GeneralServiceFares obj= generalServicesList.get(i);
    		obj.setCreatedOn(new Date());
    		
    		session.save(obj);
		}
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	
    }
    public static void main(String[] args) {
        // code to run the program
    	EntityTesting entityOperator = new EntityTesting();
    	entityOperator.setup();
    	//entityOperator.createBusStop();
    	//entityOperator.createRoute();
    //	entityOperator.createSchedule();
    	entityOperator.saveBusfare();
    	
    	
    	//delete all 
    	/*entityOperator.deleteSchedule(entityOperator.fetchSchedule(1));
    	entityOperator.deleteSchedule(entityOperator.fetchSchedule(2));
    	entityOperator.deleteRoutes(entityOperator.fetchRoute("1"));
    	entityOperator.deleteRoutes(entityOperator.fetchRoute("2"));
    	entityOperator.deleteBusStop(entityOperator.fetchBusStop(1));
    	entityOperator.deleteBusStop(entityOperator.fetchBusStop(2));
    	entityOperator.deleteBusStop(entityOperator.fetchBusStop(3));*/
    	
    	entityOperator.exit();
    }
}
