package com.tronmc.beta.handlers;

import com.tronmc.beta.WallJump;
import com.tronmc.beta.player.PlayerManager;
import com.tronmc.beta.utils.LocationUtils;
//import me.treyruffy.treysdoublejump.api.GroundPoundEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OtherPluginsHandler implements Listener {

    private final PlayerManager playerManager;

    public OtherPluginsHandler() {
        playerManager = WallJump.getInstance().getPlayerManager();
    }

//    @EventHandler
//    public void onTreysDoubleJumpGroundPound(GroundPoundEvent event) {
//        if(playerManager.getWPlayer(event.getPlayer()).isWallJumping() || LocationUtils.isTouchingAWall(event.getPlayer()))
//            event.setCancelled(true);
//    }

}
