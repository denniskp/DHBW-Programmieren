package de.dhbwka.java.exercise.threads.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private final String[] urls;
    private final int maxThreads;

    public SearchEngine(String[] urls, int maxThreads) {
        this.urls = urls;
        this.maxThreads = maxThreads;
    }

    public void startSearch() {
        Map<Thread, PageLoader> runningThreads = new HashMap<>();
        int currentIndex = 0;

        while ((currentIndex < urls.length) || (!runningThreads.isEmpty())) {
            while ((currentIndex < urls.length) && (runningThreads.size() < maxThreads)) {
                PageLoader pageLoader = new PageLoader(urls[currentIndex]);
                Thread thread = new Thread(pageLoader);
                runningThreads.put(thread, pageLoader);
                thread.start();
                System.out.println("Gestartet: " + urls[currentIndex]);
                currentIndex++;
            }

            Map<Thread, PageLoader> completedThreads = new HashMap<>();
            for (Map.Entry<Thread, PageLoader> threadEntry : runningThreads.entrySet()) {
                if (!threadEntry.getValue().pageLoaded()) {
                    continue;
                }

                Thread thread = threadEntry.getKey();
                if (thread != null && !thread.isAlive()) {
                    completedThreads.put(threadEntry.getKey(), threadEntry.getValue());
                    String content = threadEntry.getValue().getPageContent();
                    System.out.println("  Inhalt: " + content.substring(0, 40).replace('\n', '#').replace('\r', '#'));
                }
            }

            // Remove completed threads
            for (Map.Entry<Thread, PageLoader> completedThread : completedThreads.entrySet()) {
                runningThreads.remove(completedThread.getKey(), completedThread.getValue());
            }

            // Wait before checking again
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] urls = {
                "https://www.tagesschau.de",
                "https://www.sueddeutsche.de",
                "https://www.spiegel.de",
                "https://www.kit.edu"
        };

        SearchEngine searchEngine = new SearchEngine(urls, 3);
        searchEngine.startSearch();
    }
}
