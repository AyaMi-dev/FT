package org.hycha.server;

import org.bukkit.Bukkit;
import org.hycha.server.Listner.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.hycha.server.config.MainConfig;
import org.hycha.server.music.AutoMusic;
import org.hycha.server.music.MusicReload;


public class hycha extends JavaPlugin {
    private MainConfig mainConfig;


    @Override
    public void onEnable() {
        getLogger().info("플러그인이 활성화 되었습니다");
        mainConfig = new MainConfig(this); // config.yml 파일 생성 및 로드
        getServer().getPluginManager().registerEvents(new BlockInteraction(), this);
        getServer().getPluginManager().registerEvents(new CreeperListner(), this);
        getServer().getPluginManager().registerEvents(new ExplodeListner(), this);
        getServer().getPluginManager().registerEvents(new EnderdragonListner(), this);
        getServer().getPluginManager().registerEvents(new EntityInteraction(), this);
        getServer().getPluginManager().registerEvents(new WitherListner(), this);
        getServer().getPluginManager().registerEvents(new AutoMusic(), this);
        getCommand("music").setExecutor(new MusicReload());
        getCommand("music").setTabCompleter(new MusicReload());
        loadPlaylist();





        // Plugin startup logic
    }

    private void loadPlaylist() {
    }


    @Override
public void onDisable() {
    getLogger().info("플러그인이 비활성화 되었습니다");
    // Plugin shutdown logic
}
}
