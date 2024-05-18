package org.hycha.server.music;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.hycha.server.Youtube.YouTubeSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicReload extends JavaPlugin implements CommandExecutor, TabCompleter {
    private Map<String, String> playlist = new HashMap<>();

    public void loadPlaylist() {
        // config.yml에서 플레이리스트 로드
        for (String key : getConfig().getConfigurationSection("Playlist").getKeys(false)) {
            String song = getConfig().getString("Playlist." + key);
            playlist.put(key, song);
        }

        // 플레이리스트 검증 및 로그 출력
        for (Map.Entry<String, String> entry : playlist.entrySet()) {
            String location = entry.getKey();
            String song = entry.getValue();

            // YouTube 검색 및 검증
            boolean songExists = YouTubeSearch.searchSong(song);

            if (songExists) {
                getLogger().info(ChatColor.GREEN + song + "곡이 추가되었습니다");
            } else {
                getLogger().info(ChatColor.RED + song + "곡이 존재하지 않습니다");
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            try {
             

        
                reloadConfig();

          
                loadPlaylist();

            

                sender.sendMessage(ChatColor.GREEN + "리로드에 성공했습니다");
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "리로드에 실패했습니다");
            }

            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("reload");
            return completions;
        }

        return null;
    }
}
