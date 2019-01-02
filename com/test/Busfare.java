package com.test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.data.orm.entity.GeneralServiceFares;
public class Busfare
{

	public List<GeneralServiceFares> createBusfare(){
		
		List<GeneralServiceFares> generalServicesList = new ArrayList<GeneralServiceFares>();
		
		try {

			Document doc = Jsoup
					.connect("http://223.30.102.30:8080/Trip_Planner/FareSearchDetails.jsp?selected=gns&op=Search&"
							+ "form_build_id=form-qFgQcwUvDcY-EvI_vpHvX7xI9J8FZf3UAGjKJ8X0xOQ&form_id=bmtc_public_home_fares_form")
					.userAgent("Chrome/71.0.3578.98").get();

			Elements tableElements = doc.select("table");


			Elements tableRowElements = tableElements.select(":not(thead) tr");

			for (int i = 0; i < tableRowElements.size(); i++) {
				generalServicesList.add(new GeneralServiceFares());
				Element row = tableRowElements.get(i);
				//System.out.println("row");
				Elements rowItems = row.select("td");
				for (int j = 0; j < rowItems.size(); j++) {

					switch (j) {
					case 0:
						generalServicesList.get(i).setmFareStageNumber(Integer.parseInt(rowItems.get(j).text()));
						break;
					case 1:
						generalServicesList.get(i).setmAdult(Float.parseFloat(rowItems.get(j).text()));
						break;
					case 2:
						generalServicesList.get(i).setmChild(Float.parseFloat(rowItems.get(j).text()));
						break;
					case 3:
						generalServicesList.get(i).setmSeniorCitizen(Float.parseFloat(rowItems.get(j).text()));
						break;
					}
				}

			}
			
			
			Elements tableHeaderEles = tableElements.select("thead tr th");
			System.out.println("headers");
			for (int i = 0; i < tableHeaderEles.size(); i++) {
				System.out.print(tableHeaderEles.get(i).text()+" ");
			}
			System.out.println();
			
			for (int i = 0; i < generalServicesList.size(); i++) 
			{
				System.out.print("\t"+generalServicesList.get(i).getmFareStageNumber());
				System.out.print("\t\t"+generalServicesList.get(i).getmAdult());
				System.out.print("\t"+generalServicesList.get(i).getmChild());
				System.out.print("\t"+generalServicesList.get(i).getmSeniorCitizen());
				System.out.println();
			}

			System.out.println(generalServicesList);

		} 
			catch (IOException e) {
				e.printStackTrace();
			}
		
		return generalServicesList;
		
	}
	
	
	public static void main(String[] args)
	{
		Busfare busfare = new Busfare();
		busfare.createBusfare();
	}
		
}



