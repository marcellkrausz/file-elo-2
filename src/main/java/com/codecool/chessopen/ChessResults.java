package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<Competitor> competitors = new ArrayList<>();
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                competitors.add(new Competitor(
                        array[0],
                        new int[]{Integer.parseInt(array[1]),
                                Integer.parseInt(array[2]),
                                Integer.parseInt(array[3]),
                                Integer.parseInt(array[4]),
                                Integer.parseInt(array[5])}));
            }
            Collections.sort(competitors);
            List<String> result = new ArrayList<>();

            for (Competitor competitor : competitors) {
                result.add(competitor.getName());
            }

            Collections.reverse(result);
            return result;
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return null;
    }

}
