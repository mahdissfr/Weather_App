package ir.aut.ceit.ap;

import WorkWithFile.Directory;
import WorkWithFile.InputFileReader;
import WorkWithFile.OutputFileWriter;
import URL.ApiWeather;
import Weather.CurrentWeather;
import Weather.ForecastWeather;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean finish = false;
        String output,dirPath;
        int cnt ;
        int[] discriminant = new int[2];
        StringBuilder type = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        Directory directory = new Directory();
        while (!finish) {
            System.out.printf("enter the number :\n1-current\n2-16 day / daily forecast\n3-5 day / 3 hour forecast\n");
            discriminant[0] = scanner.nextInt() - 1;
            if (discriminant[0] == 0){
                dirPath = directory.createAndGetPath("current");
            }
            else if (discriminant[0] == 1) {
                dirPath = directory.createAndGetPath("daily forecast");
            }
            else {
                dirPath = directory.createAndGetPath("3 hour forecast");
            }

            System.out.printf("search by:\n1-name or name,country\n2-id\n3-lat,lon\n");
            discriminant[1] = scanner.nextInt() - 1;
            if (discriminant[1] == 0) {
                System.out.println("enter: {the name of the city} or {the name of the cit,name of it's country}");
                type.append(scanner.next());
            } else if (discriminant[1] == 1) {
                System.out.println("enter the id");
                type.append(scanner.next());
            } else if (discriminant[1] == 2) {
                System.out.println("enter latitiude");
                type.append(scanner.next());
                type.append("&");
                System.out.println("enter longitude");
                type.append(scanner.next());
            }
            if (discriminant[0] == 1) {
                System.out.println("for how many days?");
                type.append("&");
                cnt = scanner.nextInt();
                type.append(cnt);

            }
            ApiWeather apiWeather = new ApiWeather(discriminant, type.toString());
            String url = apiWeather.creatURL();
            InputFileReader inputFileReader = new InputFileReader(url);
            String input = inputFileReader.read();
            if (discriminant[0] == 0) {
                CurrentWeather currentWeather = new CurrentWeather(input);
                output = currentWeather.manage();
                currentWeather.printInfo(output);
            } else {
                ForecastWeather forecastWeather = new ForecastWeather(input);
                output = forecastWeather.manage(discriminant[1], discriminant[0]);
                forecastWeather.printInfo((output));
            }
            OutputFileWriter outputFileWriter = new OutputFileWriter(output);
            outputFileWriter.write(dirPath);
            System.out.printf("Exit?\n1-Yes\n2-No\n");
            if (scanner.nextInt() == 1)
                finish = true;
        }
    }
}
