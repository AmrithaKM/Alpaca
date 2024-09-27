package com.example.Alpaca.service;

import com.example.Alpaca.model.AlpacaOrderRequest;
import com.example.Alpaca.model.AlpacaOrderResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlpacaService {

    private final String API_KEY = "your_api_key";
    private final String SECRET_KEY = "your_secret_key";
    private final String BASE_URL = "https://paper-api.alpaca.markets";

    private final RestTemplate restTemplate = new RestTemplate();

    // Place Market Order
    public AlpacaOrderResponse placeMarketOrder(String symbol, String action, int quantity) {
        AlpacaOrderRequest request = new AlpacaOrderRequest(symbol, action, quantity, "market", "gtc");

        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", API_KEY);
        headers.set("APCA-API-SECRET-KEY", SECRET_KEY);

        HttpEntity<AlpacaOrderRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(BASE_URL + "/v2/orders", entity, AlpacaOrderResponse.class);
    }

    // Place Stop Loss Order
    public AlpacaOrderResponse placeStopLossOrder(String symbol, int quantity, double stopPrice) {
        AlpacaOrderRequest request = new AlpacaOrderRequest(symbol, "sell", quantity, "stop", "gtc");
        request.setStopPrice(stopPrice);

        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", API_KEY);
        headers.set("APCA-API-SECRET-KEY", SECRET_KEY);

        HttpEntity<AlpacaOrderRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(BASE_URL + "/v2/orders", entity, AlpacaOrderResponse.class);
    }

    // Place Limit (Target) Order
    public AlpacaOrderResponse placeTargetOrder(String symbol, int quantity, double targetPrice) {
        AlpacaOrderRequest request = new AlpacaOrderRequest(symbol, "sell", quantity, "limit", "gtc");
        request.setLimitPrice(targetPrice);

        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", API_KEY);
        headers.set("APCA-API-SECRET-KEY", SECRET_KEY);

        HttpEntity<AlpacaOrderRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(BASE_URL + "/v2/orders", entity, AlpacaOrderResponse.class);
    }

    // Cancel Order
    public void cancelOrder(String orderId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("APCA-API-KEY-ID", API_KEY);
        headers.set("APCA-API-SECRET-KEY", SECRET_KEY);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        restTemplate.exchange(BASE_URL + "/v2/orders/" + orderId, HttpMethod.DELETE, entity, Void.class);
    }
}
