package org.lanit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Info {

    @JsonProperty("userID")
    private String userID;

    @JsonProperty("tickers")
    private List<TickersItem> tickers;

    public Info() {
        // Конструктор по умолчанию
    }

    public Info(String userID, List<TickersItem> tickers) {
        this.userID = userID;
        this.tickers = tickers;
    }

    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("tickers")
    public List<TickersItem> getTickers() {
        return tickers;
    }

    @JsonProperty("tickers")
    public void setTickers(List<TickersItem> tickers) {
        this.tickers = tickers;
    }
}