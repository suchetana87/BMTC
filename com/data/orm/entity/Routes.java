package com.data.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "routes")
public class Routes {

	@Id
	@Column(name = "route_no")
	private String route_no;
	
	private int total_bus_stops;
	private float distance;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "origin_bus_stop_id", referencedColumnName="bus_stop_id")
	private BusStop origin_bus_stop_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "destination_bus_stop_id", referencedColumnName="bus_stop_id")
	private BusStop destination_bus_stop_id;
	
	public String getRoute_no() {
		return route_no;
	}
	public void setRoute_no(String route_no) {
		this.route_no = route_no;
	}
	public int getTotal_bus_stops() {
		return total_bus_stops;
	}
	public void setTotal_bus_stops(int total_bus_stops) {
		this.total_bus_stops = total_bus_stops;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public BusStop getOrigin_bus_stop_id() {
		return origin_bus_stop_id;
	}
	public void setOrigin_bus_stop_id(BusStop origin_bus_stop_id) {
		this.origin_bus_stop_id = origin_bus_stop_id;
	}
	public BusStop getDestination_bus_stop_id() {
		return destination_bus_stop_id;
	}
	public void setDestination_bus_stop_id(BusStop destination_bus_stop_id) {
		this.destination_bus_stop_id = destination_bus_stop_id;
	}
}
