package com.tronmc.beta.api;

import com.tronmc.beta.config.WallJumpConfiguration;
import com.tronmc.beta.player.PlayerManager;
import com.tronmc.beta.player.WPlayer;
import com.tronmc.beta.WallJump;
import org.bukkit.entity.Player;

public class WallJumpAPI {

    private static PlayerManager playerManager;
    private static WallJumpConfiguration config;

    public WallJumpAPI() {
        WallJump wallJump = WallJump.getInstance();
        playerManager = wallJump.getPlayerManager();
        config = wallJump.getWallJumpConfig();
    }

    public static WPlayer getWPlayer(Player player) {
        return playerManager.getWPlayer(player);
    }

    public static int getMaxJumps() {
        return config.getInt("maxJumps");
    }

    public static boolean requiresPermission() {
        return config.getBoolean("needPermission");
    }

    public static float getDefaultHorizontalPower() {
        return (float)config.getDouble("horizontalJumpPower");
    }

    public static float getDefaultVerticalPower() {
        return (float)config.getDouble("verticalJumpPower");
    }

    public static boolean isSlidingEnabled() {
        return config.getBoolean("slide");
    }
}
