package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.entity.EnderDragon;

public class EnderdragonListner implements Listener {

    @EventHandler
    public void onEnderDragonSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            event.getEntity().remove();
        }
    }
}
