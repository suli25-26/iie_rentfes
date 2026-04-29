package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static ArrayList<Berles> berlesList;

    public static void task01() {
        berlesList = Storage.readContent();   
    }

    public static void task02() {
        int month = 0;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Adjon meg egy hónapot (1-12): ");
            month = Integer.parseInt(sc.nextLine());
        }

        long sum = 0;
        for(Berles berles : berlesList) {
            if(berles.getStartDate().getMonth().getValue() == month ||
                berles.getEndDate().getMonth().getValue() == month) {
                sum += berles.getTotalPrice();
            }
        }
        System.out.printf("\nA(z) %d. havi bevétel: %,d Ft\n", month, sum);
    }

    public static void task03() {
        long sum = 0;
        for(Berles berles : berlesList) {
            sum += berles.getTotalPrice();
        }
        System.out.printf("\nTeljes éves bevétel: %,d Ft\n", sum);
    }

    public static void task04() {
        //Legdrábább bérlés
        Berles maxBerles = berlesList.get(0);
        for(Berles berles : berlesList) {
            if(berles.getTotalPrice() > maxBerles.getTotalPrice()) {
                maxBerles = berles;
            }
        }
        System.out.printf("\nLegdrágább bérlés: %s (%,d Ft)\n", 
            maxBerles.getTitle(), maxBerles.getTotalPrice());
    }

    public static void task05() {
        ArrayList<Integer> egyediPaintingid = new ArrayList<>();
        for(Berles berles : berlesList) {
            if(!egyediPaintingid.contains(berles.getPaintingid())) {
                egyediPaintingid.add(berles.getPaintingid());
            }
        }
        System.out.printf("Különböző festmények száma: %d\n", egyediPaintingid.size());
    }

    public static void task06() {
        Map<String, Integer> stat = new HashMap<>();
        for(Berles berles : berlesList) {
            String title = berles.getTitle();
            stat.put(title, stat.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = -1;

        for(Map.Entry<String, Integer> entry :stat.entrySet()) {
            if(entry.getValue()> maxCount) {
                maxCount = entry.getValue();
                maxTitle = entry.getKey();
            }
        }
        System.out.printf("Legtöbbször bérelt festmény: %s (%d alkalom)\n", 
            maxTitle, maxCount);
    }
    public static void task07() {}
    public static void task08() {}
}
