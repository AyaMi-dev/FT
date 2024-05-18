package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.EntityType;


public class CreeperListner implements Listener {

    @EventHandler
    public void onCreeperexplode(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            event.setCancelled(true);
        }
    }
}
