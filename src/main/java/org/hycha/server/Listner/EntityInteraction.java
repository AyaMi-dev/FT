package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.ItemFrame;

public class EntityInteraction implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!event.getPlayer().isOp()) {
            // OP가 아닌 플레이어의 상호작용을 막는 로직
            if (event.getRightClicked() instanceof ArmorStand || event.getRightClicked() instanceof ItemFrame) {
                event.setCancelled(true);
            }
        }
    }
}
