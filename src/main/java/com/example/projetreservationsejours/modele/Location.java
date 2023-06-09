package com.example.projetreservationsejours.modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Location {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private String location;
    private String title;
    private int numberOfPeople;
    private String host_user_id;
    private boolean location_loue;
    private String urlPhoto;

    // getters and setters omitted for brevity

    public static Location fromCsv(String csvLine) {
        String[] tokens = csvLine.split(";");
        Location location = new Location();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        location.setId(Integer.parseInt(tokens[0]));
        location.setStartDate(LocalDate.parse(tokens[1], formatter));
        location.setEndDate(LocalDate.parse(tokens[2], formatter));
        location.setPrice(Double.parseDouble(tokens[3]));
        location.setLocation(tokens[4]);
        location.setTitle(tokens[5]);
        location.setNumberOfPeople(Integer.parseInt(tokens[6]));
        location.setHost_user_id(tokens[7]);
        location.setLocation_loue(Integer.parseInt(tokens[8]) == 1);
        location.setUrlPhoto(tokens[9]);
        return location;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getHost_user_id() {
        return host_user_id;
    }

    public void setHost_user_id(String host_user_id) {
        this.host_user_id = host_user_id;
    }

    public boolean isLocation_loue() { return location_loue; }

    public void setLocation_loue(boolean location_loue) { this.location_loue = location_loue; }

    public String getUrlPhoto() { return urlPhoto; }

    public void setUrlPhoto(String urlPhoto) { this.urlPhoto = urlPhoto;}

    @Override
    public String toString() {
        return "Location {" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", location=" + location +
                ", title=" + title +
                ", numberOfPeople=" + numberOfPeople +
                ", host=" + host_user_id +
                ", isLocationLoue=" + location_loue +
                ", urlPhoto='" + urlPhoto +
                '}';
    }
}