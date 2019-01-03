package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.data.orm.entity.BusStop;
import com.data.orm.entity.Routes;
import com.data.orm.entity.Schedules;


public class HibernateUtil {

	protected static SessionFactory sessionFactory;
	 
    protected static void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    throw new RuntimeException(ex);
    	}
    }
 
    protected static void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
    
    protected static void createBusStop(BusStop busStop) {
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(busStop);
    	session.flush();
    	session.clear();
    	session.getTransaction().commit();
        session.close();
    }
    
    protected static BusStop fetchBusStop(String stopName){
    	
    	Session session = sessionFactory.openSession();
    	String hql = "from BusStop b where b.bus_stop_name = :bus_stop_name";
    	BusStop busstop = (BusStop)session.createQuery(hql).setParameter("bus_stop_name", stopName).uniqueResult();
    	session.close();
    	return busstop;
    }
    
    protected static void createRoutes(Routes routes) {
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.persist(routes);
    	session.getTransaction().commit();
        session.close();
    }
    
    protected static Routes fetchRoutes(String route_no){
    	
    	Session session = sessionFactory.openSession();
    	Routes routes = session.get(Routes.class, route_no);
    	session.close();
    	return routes;
    }

    protected static void createSchedules(Schedules schedules) {
    	
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.persist(schedules);
    	session.getTransaction().commit();
        session.close();
    }
}
