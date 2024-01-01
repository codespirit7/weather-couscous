package com.weatherServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		
		String apiKey = "";
		
		String apiURL = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey;
		
		//API Integration
		URL url = new URL(apiURL);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		//Read data from network
		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		
		//Storing Data
		StringBuilder responseContent = new StringBuilder();
		
		
		Scanner scanner = new Scanner(reader);
		
		while(scanner.hasNext()) {
			responseContent.append(scanner.nextLine());
		}
		
		scanner.close();
		
		//TypeCasting
		Gson gson = new Gson();
		
		JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
		
		long dateTimeStamp = jsonObject.get("dt").getAsLong()*1000;
		String date = new Date(dateTimeStamp).toString();
		
		double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
		int temperatureCelsius = (int)(temperatureKelvin - 273.15);
		
		int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
		
		double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
		String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
		
		request.setAttribute("date", date);
		request.setAttribute("city", city);
		request.setAttribute("temperature", temperatureCelsius);
		request.setAttribute("weatherCondition", weatherCondition);
		request.setAttribute("humidity", humidity);
		request.setAttribute("windSpeed", windSpeed);
		request.setAttribute("weatherData", responseContent.toString());
		
		connection.disconnect();
		
		//Forward the request to the weather.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
