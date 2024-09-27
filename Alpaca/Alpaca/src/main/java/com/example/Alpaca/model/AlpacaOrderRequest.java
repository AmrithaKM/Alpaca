package com.example.Alpaca.model;

public class AlpacaOrderRequest {
    private String symbol;
    private String side;
    private int qty;
    private String type;
    private String timeInForce;
    private Double limitPrice;  // For Limit orders
    private Double stopPrice;   // For Stop orders

    public AlpacaOrderRequest(String symbol, String side, int qty, String type, String timeInForce) {
        this.symbol = symbol;
        this.side = side;
        this.qty = qty;
        this.type = type;
        this.timeInForce = timeInForce;
    }

    // Getters and Setters
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getSide() { return side; }
    public void setSide(String side) { this.side = side; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTimeInForce() { return timeInForce; }
    public void setTimeInForce(String timeInForce) { this.timeInForce = timeInForce; }

    public Double getLimitPrice() { return limitPrice; }
    public void setLimitPrice(Double limitPrice) { this.limitPrice = limitPrice; }

    public Double getStopPrice() { return stopPrice; }
    public void setStopPrice(Double stopPrice) { this.stopPrice = stopPrice; }
}
