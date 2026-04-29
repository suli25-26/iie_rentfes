package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static ArrayList<Berles> readContent() {
        try {
            return tryReadContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static ArrayList<Berles> tryReadContent() throws FileNotFoundException {
        ArrayList<Berles> berlesList = new ArrayList<>();
        File file = new File("festmeny_berlesek_2024.csv");
        try(Scanner sc = new Scanner(file, "utf-8")) {
            sc.nextLine();
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(",");
                Berles berles = new Berles();
                berles.setUid(Integer.parseInt(lineArray[0]));
                berles.setPaintingid(Integer.parseInt(lineArray[1]));
                berles.setStartDate(LocalDate.parse(lineArray[2]));
                berles.setEndDate(LocalDate.parse(lineArray[3]));
                berles.setDailyPrice(Long.parseLong(lineArray[4]));
                berles.setArtist(lineArray[5]);
                berles.setTitle(lineArray[6]);
                berles.calcAndSetTotalPrice();
                berlesList.add(berles);
            }
        }
        return berlesList;
    }
}
