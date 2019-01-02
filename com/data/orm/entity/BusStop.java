package com.data.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bus_stop")
public class BusStop {
	
	@Id
	@Column(name = "bus_stop_id")
	private int bus_stop_id;
	
	private String bus_stop_name;
	
	public int getBusStopId() {
		return bus_stop_id;
	}
	public void setBusStopId(int busStopId) {
		this.bus_stop_id = busStopId;
	}
	
	public String getBusStopName() {
		return bus_stop_name;
	}
	public void setBusStopName(String busStopName) {
		this.bus_stop_name = busStopName;
	}
	

}
