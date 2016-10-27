package homework6.serveces;

import homework6.ErrorMessages;
import homework6.beans.Checkpoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by Я on 26.10.2016.
 */
public class RouteReader {
    public List<Checkpoint> readRouteFromFile(String filePath) {
        List<Checkpoint> route = new ArrayList<Checkpoint>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
            String[] coordinates;
            while (line != null) {
                coordinates = line.split("\\s+");
                if (coordinates.length == 2) {
                    route.add(new Checkpoint(Double.parseDouble(coordinates[0]),
                                             Double.parseDouble(coordinates[1])));
                } else {
                    System.err.println(ErrorMessages.ERROR_COORDINATE_TYPE);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println(ErrorMessages.FILE_READ_ERROR);
        } catch (IllegalFormatException e){
            System.err.println(ErrorMessages.ERROR_COORDINATE_TYPE);
        }
        return route;
    }
}
