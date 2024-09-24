package org.lanit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {

    @JsonProperty("add")
    private Add add;

    @JsonProperty("lastUpdate")
    private String lastUpdate;

    @JsonProperty("delete")
    private Delete delete;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("info")
    private Info info;

    public PostResponse() {
        // Конструктор по умолчанию
    }

    public PostResponse(Add add, String lastUpdate, Delete delete, String uuid, Info info) {
        this.add = add;
        this.lastUpdate = lastUpdate;
        this.delete = delete;
        this.uuid = uuid;
        this.info = info;
    }

    @JsonProperty("add")
    public Add getAdd() {
        return add;
    }

    @JsonProperty("add")
    public void setAdd(Add add) {
        this.add = add;
    }

    @JsonProperty("lastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("lastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("delete")
    public Delete getDelete() {
        return delete;
    }

    @JsonProperty("delete")
    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }
}
