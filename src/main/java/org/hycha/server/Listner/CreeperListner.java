package org.hycha.server.Listner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.entity.EntityType;


public class CreeperListner implements Listener {

    @EventHandler
    public void onCreeperexplode(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            // TNT 폭발을 막는 로직을 여기에 추가하세요.
            // 예를 들어, event.setCancelled(true);를 사용하여 폭발을 취소할 수 있습니다.
            // 또는 다른 방법으로 TNT 폭발을 제어할 수 있습니다.
        }
    }
}
