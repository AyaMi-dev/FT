package org.hycha.server.Youtube;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.util.List;

public class YouTubeSearch {
    private static final String API_KEY = "AIzaSyCg4IGh2DbXMTvTUZtWM6cm1TR7qzwnEs8";

    public static boolean searchSong(String song) {
        try {
            YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                    .setApplicationName("youtube-search")
                    .build();

            YouTube.Search.List search = youtube.search().list("id,snippet");
            search.setKey(API_KEY);
            search.setQ(song);
            search.setType("video");

            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            return !searchResultList.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
