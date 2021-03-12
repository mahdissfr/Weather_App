package Weather;

import org.json.JSONArray;
import org.json.JSONObject;

/**it is used to choose the information that we need from the information gotten from the site
 * @author mahdis safari
 * @since 24.1.1396
 */
public class ForecastWeather extends BaseWeather {

    public ForecastWeather(String result) {
        super(result);
    }

    /**
     * the name of method is printInfo
     * it chooses the information that we need from the information gotten from the site
     * @return String that is made up of each day's weather information
     */
    public String manage(int idOrNot,int timeType) {
        double resultSpeed,resultDegree;
        JSONObject jsonObject = new JSONObject(result);
        JSONObject jsonObjectCity = jsonObject.getJSONObject("city");
        String City = jsonObjectCity.getString("name");

        JSONObject jsonObjectCoord = jsonObjectCity.getJSONObject("coord");
        Double resultLon = jsonObjectCoord.getDouble("lon");
        Double resultLat = jsonObjectCoord.getDouble("lat");
        String coordination = "lon:" + resultLon + ",lat:" + resultLat;


        JSONArray jsonArraylist = jsonObject.getJSONArray("list");
        String[] humidity = new String[jsonArraylist.length()];
        String[] resultWind = new String[jsonArraylist.length()];
        String[] description = new String[jsonArraylist.length()];
        if (jsonArraylist.length() > 0) {
            for (int i = 0; i < jsonArraylist.length(); i++) {
                JSONObject jsonObjectlist = jsonArraylist.getJSONObject(i);
                if((idOrNot==1)&&(timeType==1)) {
                    humidity[i] = jsonObjectlist.getInt("humidity")+"";
                    resultSpeed = jsonObjectlist.getDouble("speed");
                    resultDegree = jsonObjectlist.getDouble("speed");
                }
                else {
                    JSONObject jsonObjectMain = jsonObjectlist.getJSONObject("main");
                    humidity[i] = jsonObjectMain.getInt("humidity")+"";
                    JSONObject jsonObjectWind = jsonObjectlist.getJSONObject("wind");
                    resultSpeed = jsonObjectWind.getDouble("speed");
                    resultDegree = jsonObjectWind.getDouble("deg");
                }
                resultWind[i] = "speed:" + resultSpeed + ",deg:" + resultDegree;

                JSONArray jsonArrayWeather = jsonObjectlist.getJSONArray("weather");
                if (jsonArrayWeather.length() > 0) {
                    JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                    description[i] = jsonObjectWeather.getString("description");
                } else {
                    description[i] = "empty!";
                }
            }
        } else {
            for (int i = 0; i < jsonArraylist.length(); i++) {
                humidity[i] = "list empty!";
                resultWind[i] = "list empty!";
            }
        }
        String output = City + "&" + humidity[0] + "&" + description[0] + "&" + resultWind[0] + "&" + coordination ;
        for (int i = 1; i < jsonArraylist.length(); i++) {
            output += "&" + City + "&" + humidity[i] + "&" + description[i] + "&" + resultWind[i] + "&" + coordination ;

        }
        return output;
    }
}
