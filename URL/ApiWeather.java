package URL;

/**
 * this class is used to create the appropriate url for the site which provide the information we are looking for
 * @author mahdis safari
 * @since 22.1.1396
 */
public class ApiWeather {
    /**
     * discriminant is an array that inform us about user decision
     * for example if discriminant[0] is 0 information should be about current weather
     * and if it is 1 about daily foecast and if it is 2 it should be about 5 day 3 hour forecast
     */
    private int[] discriminant;
    /**
     * it is compsed of the name of the city or its id or coordination and other data
     * that are given by user and they are seperated by &
     */
    private String input;
    /**
     * baseURLs an array with the base form of each kind of urls
     */
    private static String[][] baseURLs=new String[3][3];
    public ApiWeather(int[] discriminant,String input){
        this.input=input;
        this.discriminant=discriminant;
    }
    /**
     * the name of method is setBaseURLs
     * it initialize an array with the base form of each kind of urls
     */
    private static void setBaseURLs(){
        baseURLs[0][0]="http://api.openweathermap.org/data/2.5/weather?q=City&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";
        baseURLs[0][1]="http://api.openweathermap.org/data/2.5/weather?id=Id&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";
        baseURLs[0][2]="http://api.openweathermap.org/data/2.5/weather?lat=Lat&lon=Lon&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";
        baseURLs[1][0]="http://api.openweathermap.org/data/2.5/forecast?q=City&APPID=cd921ce44ed643fa3f2fe5dd3265a67a&cnt=Days";
        baseURLs[1][1]="http://api.openweathermap.org/data/2.5/forecast/daily?id=Id&APPID=cd921ce44ed643fa3f2fe5dd3265a67a&cnt=Days";
        baseURLs[1][2]="http://api.openweathermap.org/data/2.5/forecast?lat=Lat&lon=Lon&APPID=cd921ce44ed643fa3f2fe5dd3265a67a&cnt=Days";
        baseURLs[2][0]="http://api.openweathermap.org/data/2.5/forecast?q=City&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";
        baseURLs[2][1]="http://api.openweathermap.org/data/2.5/forecast?id=Id&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";
        baseURLs[2][2]="http://api.openweathermap.org/data/2.5/forecast?lat=Lat&lon=Lon&APPID=cd921ce44ed643fa3f2fe5dd3265a67a";

    }
    /**
     * the name of method is creatURL
     * it creates the appropriate url for the site which provide the information we are looking for
     * @return String the url of the site
     */
    public String creatURL(){
        String output;
        setBaseURLs();
        String[] help=input.split("&");
        if(discriminant[1]==0){
            output=baseURLs[discriminant[0]][0].replace("City",help[0]);
        }
        else if(discriminant[1]==1){
            output=baseURLs[discriminant[0]][1].replace("Id",help[0]);
        }
        else{
            output=baseURLs[discriminant[0]][2].replace("Lat",help[0]);
            output=output.replace("Lon",help[1]);
        }
        if(discriminant[0]==1)
            output=output.replace("Days",help[help.length-1]);
        return output;
    }
}
