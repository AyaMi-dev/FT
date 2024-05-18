package org.hycha.server.music;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

public class AutoMusic implements Listener {
    private Map<String, String> playlist = new HashMap<>();
    private int currentSongIndex = 0;
    private List<String> songQueue = new ArrayList<>();


    public void loadPlaylist() {
        // config.yml에서 플레이리스트 로드
        for (String key : getConfig().getConfigurationSection("Playlist").getKeys(false)) {
            String song = getConfig().getString("Playlist." + key);
            playlist.put(key, song);
            songQueue.add(song);
        }
    }

    private ConfigurationSection getConfig() {
        return null;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // 플레이어가 서버에 접속하면 음악 재생 시작
        playNextSong();
    }

    public void playNextSong() {
        if (songQueue.size() < 2) {
            getLogger().info("재생 가능한 곡이 2개 이상 필요합니다.");
            return;
        }

        String nextSong = songQueue.get(currentSongIndex);

        // YouTube에서 곡 재생 로직 추가 필요

        currentSongIndex = (currentSongIndex + 1) % songQueue.size(); // 다음 곡으로 이동하거나 처음으로 돌아감
    }
}
