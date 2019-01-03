package com.test;

import java.io.IOException;

import com.util.EntityGenerator;


public class TestClient {

	//Invoke application from here
	
	public static void main(String[] args) {
		try {
			EntityGenerator.generateEntityFromCSV("C:\\Users\\puchu\\eclipse-workspace\\BMTCServiceDataAnalysis\\bmtc-brief-data-dump.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
