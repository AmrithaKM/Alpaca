package com.example.Alpaca.service;

import com.example.Alpaca.model.Order;
import com.example.Alpaca.model.OrderRequest;
import com.example.Alpaca.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Alpaca.model.AlpacaOrderResponse;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private AlpacaService alpacaService;

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        AlpacaOrderResponse marketOrderResponse = alpacaService.placeMarketOrder(
                orderRequest.getSymbolId(),
                orderRequest.getAction(),
                orderRequest.getQuantity()
        );

        Order order = new Order();
        order.setSymbolId(orderRequest.getSymbolId());
        order.setAction(orderRequest.getAction());
        order.setQuantity(orderRequest.getQuantity());
        order.setSlPercentage(orderRequest.getSlPercentage());
        order.setTargetPercentage(orderRequest.getTargetPercentage());
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("open");

        double entryPrice = marketOrderResponse.getFilledAvgPrice();
        double slPrice = entryPrice * (1 - orderRequest.getSlPercentage() / 100);
        double targetPrice = entryPrice * (1 + orderRequest.getTargetPercentage() / 100);

        AlpacaOrderResponse slOrderResponse = alpacaService.placeStopLossOrder(
                orderRequest.getSymbolId(), orderRequest.getQuantity(), slPrice);
        AlpacaOrderResponse targetOrderResponse = alpacaService.placeTargetOrder(
                orderRequest.getSymbolId(), orderRequest.getQuantity(), targetPrice);

        order.setSlOrderId(slOrderResponse.getId());
        order.setTargetOrderId(targetOrderResponse.getId());

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void trackOrder(Order order) {
        // Logic to track the order and handle SL or target execution
    }
}
