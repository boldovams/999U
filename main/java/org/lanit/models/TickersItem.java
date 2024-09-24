package org.lanit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TickersItem {

    @JsonProperty("alerts")
    private List<Notification> alerts;

    @JsonProperty("ticker")
    private String ticker;

    public TickersItem() {
        // Конструктор по умолчанию
    }

    public TickersItem(List<Notification> alerts, String ticker) {
        this.alerts = alerts;
        this.ticker = ticker;
    }

    @JsonProperty("alerts")
    public List<Notification> getAlerts() {
        return alerts;
    }

    @JsonProperty("alerts")
    public void setAlerts(List<Notification> alerts) {
        this.alerts = alerts;
    }

    @JsonProperty("ticker")
    public String getTicker() {
        return ticker;
    }

    @JsonProperty("ticker")
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}