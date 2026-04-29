package com.example;

import java.util.ArrayList;
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
}
