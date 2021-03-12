package Weather;

import org.json.JSONArray;
import org.json.JSONObject;

/**it is used to choose the information that we need from the information gotten from the site
 * @author mahdis safari
 * @since 24.1.1396
 */
public class CurrentWeather extends BaseWeather {

    public CurrentWeather(String result){
        super(result);
    }
    /**
     * the name of method is printInfo
     * it chooses the information that we need from the information gotten from the site
     * @return String that is made up of each day's weather information
     */
    public String manage(){
        JSONObject jsonObject = new JSONObject(result);
        String city = jsonObject.getString("name");

        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
        Double resultHumidity = jsonObjectMain.getDouble("humidity");

        String resultDescription;
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        if (jsonArrayWeather.length() > 0) {
            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
            resultDescription = jsonObjectWeather.getString("description");
        } else {
            resultDescription = "weather empty!";
        }

        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
        Double resultSpeed = jsonObjectWind.getDouble("speed");
        Double resultDeg = jsonObjectWind.getDouble("deg");
        String resultWind = "speed:" + resultSpeed + ",deg:" + resultDeg;

        JSONObject jsonObjectCoord = jsonObject.getJSONObject("coord");
        Double resultLon = jsonObjectCoord.getDouble("lon");
        Double resultLat = jsonObjectCoord.getDouble("lat");
        String coordination = "lon:" + resultLon + ",lat:" + resultLat;

        return city + "&" + resultHumidity + "&" + resultDescription + "&" +resultWind+"&"+coordination ;
    }
}
