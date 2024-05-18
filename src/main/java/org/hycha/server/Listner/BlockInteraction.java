package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Material;

public class BlockInteraction implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getPlayer().isOp()) {
            // OP가 아닌 플레이어의 상호작용을 막는 로직
            Material blockType = event.getClickedBlock().getType();
            if (blockType == Material.ENDER_CHEST || blockType == Material.CHEST || blockType == Material.CRAFTING_TABLE || blockType == Material.BARREL || blockType == Material.OAK_FENCE_GATE || blockType == Material.SPRUCE_FENCE_GATE || blockType == Material.BIRCH_FENCE_GATE || blockType == Material.JUNGLE_FENCE_GATE || blockType == Material.ACACIA_FENCE_GATE || blockType == Material.DARK_OAK_FENCE_GATE || blockType == Material.MANGROVE_FENCE_GATE || blockType == Material.CHERRY_FENCE_GATE || blockType == Material.BAMBOO_FENCE_GATE || blockType == Material.CRIMSON_FENCE_GATE || blockType == Material.WARPED_FENCE_GATE || blockType == Material.OAK_DOOR || blockType == Material.SPRUCE_DOOR || blockType == Material.BIRCH_DOOR || blockType == Material.JUNGLE_DOOR || blockType == Material.ACACIA_DOOR || blockType == Material.DARK_OAK_DOOR || blockType == Material.MANGROVE_DOOR || blockType == Material.CHERRY_DOOR || blockType == Material.BAMBOO_DOOR || blockType == Material.CRIMSON_DOOR || blockType == Material.WARPED_DOOR || blockType == Material.CHISELED_BOOKSHELF || blockType == Material.BELL || blockType == Material.WARPED_TRAPDOOR || blockType == Material.CRIMSON_TRAPDOOR || blockType == Material.BAMBOO_TRAPDOOR || blockType == Material.CHERRY_TRAPDOOR || blockType == Material.MANGROVE_TRAPDOOR || blockType == Material.DARK_OAK_FENCE || blockType == Material.ACACIA_TRAPDOOR || blockType == Material.JUNGLE_TRAPDOOR || blockType == Material.BIRCH_TRAPDOOR || blockType == Material.OAK_TRAPDOOR || blockType == Material.SPRUCE_TRAPDOOR || blockType == Material.DARK_OAK_TRAPDOOR) {
                event.setCancelled(true);
            }
        }
    }
}


