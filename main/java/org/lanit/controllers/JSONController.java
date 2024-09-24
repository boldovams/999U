package org.lanit.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller

public class JSONController {

    @PostMapping("/json")
    public ResponseEntity<JsonNode> handleJsonPostRequest(@RequestParam("action") String action, @RequestBody JsonNode request) {
        JsonNode response = null;
        if ("add".equals(action) && request.has("add")) {
            JsonNode addNode = request.get("add");
            String name = addNode.get("name").asText();
            int timeFrame = addNode.get("timeFrame").asInt();
            int percent = addNode.get("percent").asInt();
            ObjectNode info = (ObjectNode) request.get("info");
            ArrayNode tickers = (ArrayNode) info.get("tickers");
            boolean found = false;
            for (int i = 0; i < tickers.size(); i++) {
                JsonNode tickerNode = tickers.get(i);
                String tickerName = tickerNode.get("ticker").asText();
                if (name.equalsIgnoreCase(tickerName)) {
                    found = true;
                    ArrayNode alerts = (ArrayNode) tickerNode.get("alerts");
                    ObjectNode newAlert = JsonNodeFactory.instance.objectNode();
                    newAlert.put("timeFrame", timeFrame);
                    newAlert.put("percent", percent);
                    alerts.add(newAlert);
                    break;
                }
            }
            if (!found) {
                ObjectNode newTicker = JsonNodeFactory.instance.objectNode();
                newTicker.put("ticker", name);
                ArrayNode alerts = JsonNodeFactory.instance.arrayNode();
                ObjectNode newAlert = JsonNodeFactory.instance.objectNode();
                newAlert.put("timeFrame", timeFrame);
                newAlert.put("percent", percent);
                alerts.add(newAlert);
                newTicker.set("alerts", alerts);
                tickers.add(newTicker);

            }
            response = request;
            ((ObjectNode) request).remove("add");
            UUID uuid = UUID.randomUUID();
            ((ObjectNode) response).put("uuid", uuid.toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            ((ObjectNode) response).put("lastUpdate", LocalDateTime.now().format(formatter));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);

        }
        else if ("delete".equals(action) && request.has("delete")) {
            JsonNode deleteNode = request.get("delete");
            String name = deleteNode.get("tickerName").asText();
            int alertIndex = deleteNode.get("alertIndex").asInt();
            ObjectNode info = (ObjectNode) request.get("info");
            ArrayNode tickers = (ArrayNode) info.get("tickers");
            boolean found = false;
            for (int i = 0; i < tickers.size(); i++) {
                JsonNode tickerNode = tickers.get(i);
                String tickerName = tickerNode.get("ticker").asText();
                if (name.equalsIgnoreCase(tickerName)) {
                    found = true;
                    ArrayNode alerts = (ArrayNode) tickerNode.get("alerts");
                    if (alertIndex >= 0 && alertIndex < alerts.size()) {
                        alerts.remove(alertIndex);
                    }
                    break;
                }
            }
            if (!found) {
                response = JsonNodeFactory.instance.objectNode();
                ((ObjectNode) response).put("error", "Ticker not found");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            response = request;
            ((ObjectNode) request).remove("delete");
            UUID uuid = UUID.randomUUID();
            ((ObjectNode) response).put("uuid", uuid.toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            ((ObjectNode) response).put("lastUpdate", LocalDateTime.now().format(formatter));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        }
        else {
            response = JsonNodeFactory.instance.objectNode();
            ((ObjectNode) response).put("message","Передан некорректный action - "+ action);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
