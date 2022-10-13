package com.SHELBY.crypto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CryptosParser {

    public static final HashMap<String, String> cryptos = new HashMap<>();

    public static String getCrypto(String nameOrSymbol) {
        String price = "";
        parseCrypto();
        if (!cryptos.isEmpty()) {
            for (Map.Entry<String, String> entry : cryptos.entrySet()) {
                if (entry.getKey().contains(nameOrSymbol)) {
                    price = String.valueOf(entry.getValue());
                }
            }
        }
        return price;
    }

    public static void parseCrypto() {
        try {
            URL url = new URL("https://api.coinlore.net/api/tickers/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openConnection().getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            StringBuilder information = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                inputLine = inputLine.replaceAll("\"", "");
                information.append(inputLine);
            }
            String[] infValues = information.toString().split(",");
            String name = "", symbol = "";
            for (String infValue : infValues) {
                int index = infValue.indexOf(":");
                if (infValue.substring(0, index).equalsIgnoreCase("symbol")) {
                    symbol = infValue.substring(index + 1);
                }
                if (infValue.substring(0, index).equalsIgnoreCase("name")) {
                    name = infValue.substring(index + 1);
                }
                if (infValue.substring(0, index).equalsIgnoreCase("price_usd")) {
                    String price = infValue.substring(index + 1);
                    cryptos.put(name + symbol + symbol.toLowerCase(Locale.ROOT), price);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
