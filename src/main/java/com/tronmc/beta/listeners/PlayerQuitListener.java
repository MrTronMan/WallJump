package com.tronmc.beta.listeners;

import com.tronmc.beta.WallJump;
import com.tronmc.beta.player.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final PlayerManager playerManager = WallJump.getInstance().getPlayerManager();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        playerManager.unregisterPlayer(event.getPlayer());
    }

}
