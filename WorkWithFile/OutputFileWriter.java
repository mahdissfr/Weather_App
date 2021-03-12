package WorkWithFile;

import java.io.*;
import java.util.Date;
import java.util.Formatter;


/**
 * this class is used to write the iinformation in a file
 * @author mahdis safari
 * @since 26.1.1396
 */
public class OutputFileWriter {
    /**
     * the information that should be written in the file
     */
    private String toWrite;

    public OutputFileWriter(String toWrite) {
        this.toWrite = toWrite;
    }
    /**
     * the name of method is write
     * it writes the information in the file in related folder
     * @param dir the absolute path of the directory
     */
    public void write(String dir) {
        try {
            File file1 = new File(dir+"\\"+new Date(System.currentTimeMillis()).toString().replace(":","")+".txt");
            Formatter fmt = new Formatter(file1);
            String[] dividedInput = toWrite.split("&");
            for (int i = 0; i < 5 * 32; i++) {
                fmt.format("=");
            }
            fmt.format("\r\n");
            fmt.format("%-32s%-32s%-32s%-32s%-32s\r\n", "City", "Humidity", "Description", "Wind_Info", "Coordination");
            for (int i = 0; i < 5 * 32; i++) {
                fmt.format("=");
            }
            fmt.format("\r\n");
            for (int i = 0; i < dividedInput.length; i += 5) {
                fmt.format("%-32s%-32s%-32s%-32s%-32s\r\n", dividedInput[i], dividedInput[i + 1], dividedInput[i + 2], dividedInput[i + 3], dividedInput[i + 4]);
            }
            for (int i = 0; i < 5 * 32; i++) {
                fmt.format("=");
            }
            fmt.format("\r\n");
            fmt.close();


        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException : " + fnfe);
        } catch (NullPointerException npe) {
            System.out.println("NullPointerException : " + npe);
        }
    }

}

