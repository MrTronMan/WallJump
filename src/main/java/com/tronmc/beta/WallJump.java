package com.tronmc.beta;

import com.tronmc.beta.api.WallJumpAPI;
import com.tronmc.beta.command.WallJumpCommand;
import com.tronmc.beta.config.WallJumpConfiguration;
import com.tronmc.beta.handlers.BStats;
import com.tronmc.beta.listeners.PlayerDamageListener;
import com.tronmc.beta.listeners.PlayerJoinListener;
import com.tronmc.beta.listeners.PlayerQuitListener;
import com.tronmc.beta.listeners.PlayerToggleSneakListener;
import com.tronmc.beta.player.PlayerManager;
import com.tronmc.beta.player.WPlayer;
import com.tronmc.beta.handlers.OtherPluginsHandler;
import com.tronmc.beta.handlers.WorldGuardHandler;
import com.tronmc.beta.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class WallJump extends JavaPlugin {

    private static WallJump plugin;
    private WallJumpAPI api;
    private PlayerManager playerManager;
    private WallJumpConfiguration config;
    private WallJumpConfiguration dataConfig;
    private WorldGuardHandler worldGuard;

    public static WallJump getInstance() {
        return plugin;
    }

    public WallJumpAPI getAPI() {
        return api;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public WallJumpConfiguration getWallJumpConfig() {
        return config;
    }

    public WallJumpConfiguration getDataConfig() {
        return dataConfig;
    }

    public WorldGuardHandler getWorldGuardHandler() {
        return worldGuard;
    }

    @Override
    public void onEnable() {
        playerManager = new PlayerManager();
        getLogger().info("WallJump for 1.19.4 has loaded.");
        registerEvents(
                new PlayerJoinListener(),
                new PlayerQuitListener(),
                new PlayerToggleSneakListener(),
                new PlayerDamageListener(),
                new OtherPluginsHandler()
        );

        this.getCommand("walljump").setExecutor(new WallJumpCommand());

        //in case the plugin has been loaded while the server is running using plugman or any other similar methods, register all the online players
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerManager.registerPlayer(player);
        }




        //new AntiCheatUtils();
        api = new WallJumpAPI();
    }

    @Override
    public void onLoad() {
        plugin = this;
        config = new WallJumpConfiguration("config.yml");
        dataConfig = new WallJumpConfiguration("data.yml");
        getLogger().info("WallJump for 1.19.4 is loading...");
        Plugin worldGuardPlugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if (worldGuardPlugin != null) {
            worldGuard = new WorldGuardHandler(worldGuardPlugin, this);
        }
    }

    @Override
    public void onDisable() {
        if (config.getBoolean("toggleCommand")) {
            for (WPlayer wplayer : playerManager.getWPlayers()) {
                dataConfig.set(wplayer.getPlayer().getUniqueId().toString(), wplayer.enabled);
            }
            dataConfig.save();
        }
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }
}
