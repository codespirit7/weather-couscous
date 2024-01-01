# WeatherInfo Web Application

## Overview

The WeatherInfo web application is a simple yet powerful tool that allows users to retrieve weather information for a particular city. The application is built using JavaServer Pages (JSP) and Servlet technologies. It leverages the OpenWeather API to fetch real-time weather data, including temperature, time, and wind speed, based on the user's input.

## Features

- **City-specific Weather Information:** Users can enter the name of a city in the input bar, and the application will fetch and display the current weather conditions for that city.

- **User-friendly Interface:** The application provides a clean and intuitive interface with an input bar and search button on the index.html page for easy interaction.

- **API Integration:** The application integrates with the OpenWeather API to gather accurate and up-to-date weather information.

- **JSON Parsing:** The retrieved weather data is converted into JSON format using the GSON library for easy manipulation and rendering on the client side.

## Project Structure

- **index.html:** The main HTML file that contains the user interface with an input bar and a search button.

- **WeatherServlet.java:** The servlet responsible for handling user requests. It communicates with the OpenWeather API, processes the response, and passes the data to the JSP page.

- **index.jsp:** The JSP page that receives the weather information from the servlet and dynamically renders it on the client side.

- **WEB-INF/lib/:** Contains the GSON library JAR file.

## Usage

1. **Clone the Repository:**
   ```bash
   git clone https://git@github.com:codespirit7/weather-couscous.git
   ```

2. **Deploy the Application:**
   Deploy the application on a servlet container (e.g., Apache Tomcat).

3. **Access the Application:**
   Open a web browser and navigate to `http://localhost:8080/WeatherCity`.

4. **Enter City Name:**
   Enter the name of the city for which you want to check the weather in the input bar and click the search button.

5. **View Weather Information:**
   The application will display the current weather information for the entered city, including temperature, time, and wind speed.

## Dependencies

- **GSON Library:** The GSON library is used for converting the API response to JSON format. The library is included in the `WEB-INF/lib/` directory.

## Notes

- Ensure that your servlet container (e.g., Apache Tomcat) is properly configured to run the application.
  
- Make sure you have an active internet connection to fetch real-time weather data from the OpenWeather API.

- The OpenWeather API key used in the application is for demonstration purposes. Replace it with your own API key for production use.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to modify and distribute the code for your own projects.
