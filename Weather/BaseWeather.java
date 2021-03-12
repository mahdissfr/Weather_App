package Weather;

/**
 * {@inheritDoc}
 * the name of class is BaseWeather
 * @author mahdis safari
 * @since 24.1.1396
 */
public class BaseWeather {
    /**
     *result is the what we got from the site
     */
    public String result;

    public BaseWeather(String result) {
        this.result = result;
    }
    /**
     * the name of method is printInfo
     * it prints the informations
     * @param toPrint the total data that should become printed
     */
    public void printInfo(String toPrint) {
        String[] dividedString = toPrint.split("&");
        creatLine();
        System.out.format("%-32s%-32s%-32s%-32s%-32s\n", "City", "Humidity", "Description", "Wind_Info", "Coordination");
        creatLine();
        for (int i=0;i<dividedString.length;i+=5) {
            System.out.format("%-32s%-32s%-32s%-32s%-32s\n", dividedString[i], dividedString[i+1], dividedString[i+2], dividedString[i+3], dividedString[i+4]);
        }
        creatLine();
    }
    /**
     * the name of method is creatLine
     * it prints a line with the character of =
     */
    private void creatLine(){
        for (int i = 0; i < 5*32; i++) {
            System.out.printf("=");
        }
        System.out.println();
    }
}
