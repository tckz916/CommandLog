package com.github.tckz916.commandlog;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tckz916 on 2015/09/27.
 */
public class CommandLog extends JavaPlugin implements Listener {

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        super.onEnable();
        pluginManager.registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        for (Player players : this.getServer().getOnlinePlayers()) {
            if (players.hasPermission("commandlog.see")) {
                players.sendMessage(ChatColor.GRAY + "[CL] " + player.getName() + ": " + event.getMessage());
            }
        }
    }
}
