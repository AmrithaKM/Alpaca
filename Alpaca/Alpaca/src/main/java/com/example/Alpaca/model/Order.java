package com.example.Alpaca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbolId;
    private String action;
    private int quantity;
    private float slPercentage;
    private float targetPercentage;
    private String status;  // "open" or "closed"
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
    private String slOrderId;
    private String targetOrderId;
    private Double sellPrice;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(LocalDateTime closedAt) { this.closedAt = closedAt; }

    public String getSlOrderId() { return slOrderId; }
    public void setSlOrderId(String slOrderId) { this.slOrderId = slOrderId; }

    public String getTargetOrderId() { return targetOrderId; }
    public void setTargetOrderId(String targetOrderId) { this.targetOrderId = targetOrderId; }

    public Double getSellPrice() { return sellPrice; }
    public void setSellPrice(Double sellPrice) { this.sellPrice = sellPrice; }
}
