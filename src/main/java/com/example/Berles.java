package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Berles {
    private int uid;
    private int paintingid;
    private LocalDate startDate;
    private LocalDate endDate;
    private long dailyPrice;
    private String artist;
    private String title;
    private long totalPrice;
    public Berles() {}
    public Berles(int uid, int paintingid, LocalDate startDate, LocalDate endDate, long dailyPrice, String artist,
            String title) {
        this.uid = uid;
        this.paintingid = paintingid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyPrice = dailyPrice;
        this.artist = artist;
        this.title = title;
        calcAndSetTotalPrice();
    }

    public void calcAndSetTotalPrice() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        totalPrice = days * dailyPrice;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getPaintingid() {
        return paintingid;
    }
    public void setPaintingid(int paintingid) {
        this.paintingid = paintingid;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public long getDailyPrice() {
        return dailyPrice;
    }
    public void setDailyPrice(long dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public long getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    
}
