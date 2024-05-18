package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.entity.Wither;

public class WitherListner implements Listener {

    @EventHandler
    public void onWitherSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Wither) {
            event.getEntity().remove();
        }
    }
}
