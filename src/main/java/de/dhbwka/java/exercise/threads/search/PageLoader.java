package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PageLoader implements Runnable {
    private final String url;
    private String content = "";

    public PageLoader(String url) {
        this.url = url;
    }

    public boolean pageLoaded() {
        return !content.isBlank();
    }

    public String getPageContent() {
        return content;
    }

    @Override
    public void run() {
        StringBuilder buffer = new StringBuilder();

        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), StandardCharsets.UTF_8))) {
            while ((line = br.readLine()) != null) {
                buffer.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        content = buffer.toString();
    }
}
