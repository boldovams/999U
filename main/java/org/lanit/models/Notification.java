package org.lanit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notification {

    @JsonProperty("timeframe")
    private int timeframe;

    @JsonProperty("percent")
    private int percent;

    public Notification() {
        // Конструктор по умолчанию
    }

    public Notification(int timeframe, int percent) {
        this.timeframe = timeframe;
        this.percent = percent;
    }

    @JsonProperty("timeframe")
    public int getTimeframe() {
        return timeframe;
    }

    @JsonProperty("timeframe")
    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
    }

    @JsonProperty("percent")
    public int getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(int percent) {
        this.percent = percent;
    }
}