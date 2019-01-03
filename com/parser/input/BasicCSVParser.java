package com.parser.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;


public class BasicCSVParser {
	
	public static CSVParser readFromCSVFile(String filename) throws IOException{
		BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
        		"route_no", "distance", "origin", "destination", "departure_from_origin", "arrival_at_origin", "departure_from_destination", 
        		"arrival_at_destination").withIgnoreHeaderCase().withTrim());
        
        return csvParser;
	}
}
