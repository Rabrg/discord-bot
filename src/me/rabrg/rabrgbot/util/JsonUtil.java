package me.rabrg.rabrgbot.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class JsonUtil {

    public static String getJsonResponse(final String spec) {
        final StringBuilder result = new StringBuilder();
        try {
            final URL url = new URL(spec);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0 Java/1.7.0");
            conn.setRequestProperty("Accept", "application/json");

            try (final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = rd.readLine()) != null)
                    result.append(line);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
