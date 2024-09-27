package com.example.Alpaca.model;

public class OrderRequest {
    private String symbolId;
    private String action;
    private int quantity;
    private float slPercentage;
    private float targetPercentage;

    // Getters and Setters
    public String getSymbolId() { return symbolId; }
    public void setSymbolId(String symbolId) { this.symbolId = symbolId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getSlPercentage() { return slPercentage; }
    public void setSlPercentage(float slPercentage) { this.slPercentage = slPercentage; }

    public float getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(float targetPercentage) { this.targetPercentage = targetPercentage; }
}
