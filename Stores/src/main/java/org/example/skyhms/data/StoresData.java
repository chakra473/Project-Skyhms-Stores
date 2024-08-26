package org.example.skyhms.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoresData {

    public List<String[]> ItemList() {
        String filePath = "C:\\Users\\rasp\\IdeaProjects\\Stores\\tbl_pos_items.csv"; // Change to your file path
        List<String[]> dataList = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> rows = csvReader.readAll();
            dataList.addAll(rows);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        //String[] itemList= new String[]{};
        // Print the data to verify
        for (String[] row : dataList) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        return dataList;
    }
}
