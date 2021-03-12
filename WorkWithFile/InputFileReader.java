package WorkWithFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 * this class is used to read and return information of a site in a string
 * @author mahdis safari
 * @since 22.1.1396
 */
public class InputFileReader {
    /**
     * inputURL is the url of the site in which shows information about the city we want to know about
     */
    private String inputURL;
    /**
     * result is the string that contains the data we look for
     */
    private StringBuilder result;

    public InputFileReader(String url) {
        inputURL = url;
        result=new StringBuilder("");
    }
    /**
     * the name of method is read
     * it reads the information from the site
     * @return String that contains the data we look for
     */
    public String read() {
        try {
            URL urlWeather = new URL(inputURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlWeather.openConnection();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192);
                String line ;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                bufferedReader.close();
            } else {
                System.out.println("Error in httpURLConnection.getResponseCode()!!!");
            }

        } catch (IOException | JSONException | NullPointerException ex) {
            Logger.getLogger(InputFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.toString();
    }
}