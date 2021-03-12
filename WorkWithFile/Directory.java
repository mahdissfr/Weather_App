package WorkWithFile;
import java.io.*;

/**
 * this class is used to create a directory (if there is not one with the same name)
 * and give the absolute path of the directory
 * @author mahdis safari
 * @since 27.1.1396
 */
public class Directory {
    /**
     * the name of method is createAndGetPath
     * it creates a directory (if there is not one with the same name)
     * and give the absolute path of the directory
     * @param name the name of the directory
     * @return String the absolute path of the directory
     */
    public String createAndGetPath(String name){
        File directory = new File(name);
        if (!directory.exists()) {
            try {
                boolean success = directory.mkdir();
                if (!success) {
                    System.out.println("Directory: "
                            + name + "didn't create");
                }
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        }
        return directory.getAbsolutePath();
    }
}
