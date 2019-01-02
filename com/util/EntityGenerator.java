package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.data.orm.entity.BusStop;
import com.data.orm.entity.Routes;
import com.data.orm.entity.Schedules;
import com.parser.input.BasicCSVParser;


public class EntityGenerator {

	public static void generateEntityFromCSV(String filename) throws IOException {
		CSVParser csvParser = BasicCSVParser.readFromCSVFile(filename);
		int bus_stop_id_gen = 0;
		int shcedule_id_gen = 0;

		HibernateUtil.setup();

		// To create an unique bus stop accross the city
		Set<String> busstops = new HashSet<>();
		for (CSVRecord csvRecord : csvParser) {

			
			String origin = csvRecord.get("origin");
			String destination = csvRecord.get("destination");

			// ignoring headers
			if (!(origin.equals(origin) && destination.equals("destination"))) {

				busstops.add(csvRecord.get("origin"));
				busstops.add(csvRecord.get("destination"));
			}
		}

		List<String> busstopList = new ArrayList<>();
		busstopList.addAll(busstops);

		// Saving BusStop

		BusStop busStop = new BusStop();

		while (busstopList.size() > bus_stop_id_gen++) {
			busStop.setBusStopId(bus_stop_id_gen);
			busStop.setBusStopName(busstopList.get(bus_stop_id_gen - 1));

			HibernateUtil.createBusStop(busStop);
		}

		bus_stop_id_gen = 0;

		// Saving Routes
		CSVParser csvParserForRoues = BasicCSVParser.readFromCSVFile(filename);
		for (CSVRecord csvRecordForRoutes : csvParserForRoues) {
			
			String route_no = csvRecordForRoutes.get(0);
			String distance = csvRecordForRoutes.get("distance");
			
			
			if (!(route_no.equals("route_no") && distance.equals("distance"))) {
				
				if (csvRecordForRoutes.get(0) != null && !csvRecordForRoutes.get(0).equals("")){
					
					Routes routes = new Routes();

					distance = csvRecordForRoutes.get("distance");
					distance = distance.replaceAll("KM", "");
					distance = distance.replaceAll("\\s+", "");

					routes.setRoute_no(csvRecordForRoutes.get(0));
					routes.setDistance(Float.parseFloat(distance));
					routes.setOrigin_bus_stop_id(HibernateUtil.fetchBusStop(csvRecordForRoutes.get("origin")));
					routes.setDestination_bus_stop_id(HibernateUtil.fetchBusStop(csvRecordForRoutes.get("destination")));

					// TODO
					routes.setTotal_bus_stops(ThreadLocalRandom.current().nextInt(1, 10));

					HibernateUtil.createRoutes(routes);
				}
			}
		}

		// Saving Schedules
		
		CSVParser csvParserForSchedules = BasicCSVParser.readFromCSVFile(filename);
		for (CSVRecord csvRecordForSchedules : csvParserForSchedules) {

			String departure_from_origin = csvRecordForSchedules.get("departure_from_origin");
			String arrival_at_origin = csvRecordForSchedules.get("arrival_at_origin");
			if (!(departure_from_origin.equals("departure_from_origin") && arrival_at_origin.equals("arrival_at_origin"))) {
				Schedules schedules = new Schedules();
				schedules.setSchedules_id(++shcedule_id_gen);
				schedules.setRoute_no(HibernateUtil.fetchRoutes(csvRecordForSchedules.get(0)));
				schedules.setDeparture_from_origin(csvRecordForSchedules.get("departure_from_origin"));
				schedules.setArrival_at_destination(csvRecordForSchedules.get("arrival_at_origin"));

				// TODO
				schedules.setDuration(ThreadLocalRandom.current().nextInt(1, 10));

				HibernateUtil.createSchedules(schedules);
			}
		}

		shcedule_id_gen = 0;

		HibernateUtil.exit();
	}
}
