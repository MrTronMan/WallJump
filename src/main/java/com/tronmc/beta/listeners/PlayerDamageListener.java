package com.tronmc.beta.listeners;

import com.tronmc.beta.WallJump;
import com.tronmc.beta.player.PlayerManager;
import com.tronmc.beta.player.WPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

    private final PlayerManager playerManager = WallJump.getInstance().getPlayerManager();

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if(event.getCause().equals(EntityDamageEvent.DamageCause.FALL) && event.getEntityType().equals(EntityType.PLAYER)) {
            WPlayer wplayer = playerManager.getWPlayer((Player)event.getEntity());
            if(wplayer != null && wplayer.isSliding()) {
                event.setCancelled(true);
                wplayer.onWallJumpEnd(false);
            }
        }
    }

}
