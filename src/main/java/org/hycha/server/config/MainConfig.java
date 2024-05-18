package org.hycha.server.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MainConfig {
    private JavaPlugin plugin;
    private FileConfiguration config;

    public MainConfig(JavaPlugin plugin) {
        this.plugin = plugin;
        createConfig();
    }

    private void createConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource("config.yml", false);



        }

        config = new YamlConfiguration();
        try {
            config.load(configFile);

            // 기본 설정 값이 없으면 설정하고 저장
            if (!config.isSet("version")) {
                config.set("version", "r1.0");
            }
            if (!config.isSet("Playlist")) {
                config.createSection("Playlist");
                config.set("Playlist.lobby", "SONG NAME");
                config.set("Playlist.lobby2", "SONG NAME");
                config.set("Playlist.victory", "SONG NAME");
                config.set("Playlist", "SONG NAME");
                config.set("Playlist.1vs1", "SONG NAME");
            }

            config.save(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }



}

