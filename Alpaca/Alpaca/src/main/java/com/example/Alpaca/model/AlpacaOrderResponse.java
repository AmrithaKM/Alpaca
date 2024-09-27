package com.example.Alpaca.model;

public class AlpacaOrderResponse {
    private String id;
    private double filledAvgPrice;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getFilledAvgPrice() { return filledAvgPrice; }
    public void setFilledAvgPrice(double filledAvgPrice) { this.filledAvgPrice = filledAvgPrice; }
}