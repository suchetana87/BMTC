package com.data.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "schedules")
public class Schedules {

	@Id
	@Column(name = "schedules_id")
	private int schedules_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "route_no", referencedColumnName="route_no")
	private Routes route_no;
	
	private String departure_from_origin;
	private String arrival_at_destination;
	private int duration;
	
	
	public int getSchedules_id() {
		return schedules_id;
	}
	public void setSchedules_id(int schedules_id) {
		this.schedules_id = schedules_id;
	}
	public Routes getRoute_no() {
		return route_no;
	}
	public void setRoute_no(Routes route_no) {
		this.route_no = route_no;
	}
	public String getDeparture_from_origin() {
		return departure_from_origin;
	}
	public void setDeparture_from_origin(String departure_from_origin) {
		this.departure_from_origin = departure_from_origin;
	}
	public String getArrival_at_destination() {
		return arrival_at_destination;
	}
	public void setArrival_at_destination(String arrival_at_destination) {
		this.arrival_at_destination = arrival_at_destination;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
