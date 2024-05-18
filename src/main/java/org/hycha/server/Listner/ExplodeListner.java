package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.EntityType;


public class ExplodeListner implements Listener {

    @EventHandler
    public void onTNTExplode(EntityExplodeEvent event) {
        if (!event.getEntity().isOp()) {
            // OP가 아닌 플레이어의 상호작용을 막는 로직
            EntityType entityType = event.getEntityType();
            if (entityType == EntityType.PRIMED_TNT || entityType == EntityType.MINECART_TNT) {
                event.setCancelled(true);
            }
        }
    }
}
