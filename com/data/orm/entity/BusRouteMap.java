package com.data.orm.entity;


public class BusRouteMap {
	
	private int bus_route_map_id;
	private String route_no;
	private int bus_stop_id;
	
	public int getBus_route_map_id() {
		return bus_route_map_id;
	}
	public void setBus_route_map_id(int bus_route_map_id) {
		this.bus_route_map_id = bus_route_map_id;
	}
	public String getRoute_no() {
		return route_no;
	}
	public void setRoute_no(String route_no) {
		this.route_no = route_no;
	}
	public int getBus_stop_id() {
		return bus_stop_id;
	}
	public void setBus_stop_id(int bus_stop_id) {
		this.bus_stop_id = bus_stop_id;
	}

}
