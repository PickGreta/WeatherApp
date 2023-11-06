public class WeatherInfo {
    private String cityName;
    private double temperature;
    private String weatherDescription;

    public WeatherInfo(String cityName, double temperature, String weatherDescription) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}
