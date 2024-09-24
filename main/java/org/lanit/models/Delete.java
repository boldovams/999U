package org.lanit.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Delete {

    @JsonProperty("tickerName")
    private String tickerName;

    @JsonProperty("alertIndex")
    private int alertIndex;

    public Delete() {
        // Конструктор по умолчанию
    }

    public Delete(String tickerName, int alertIndex) {
        this.tickerName = tickerName;
        this.alertIndex = alertIndex;
    }

    @JsonProperty("tickerName")
    public String getTickerName() {
        return tickerName;
    }

    @JsonProperty("alertIndex")
    public int getAlertIndex() {
        return alertIndex;
    }

    @JsonProperty("tickerName")
    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

    @JsonProperty("alertIndex")
    public void setAlertIndex(int alertIndex) {
        this.alertIndex = alertIndex;
    }
}