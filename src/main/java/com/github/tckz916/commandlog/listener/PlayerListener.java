package com.github.tckz916.commandlog.listener;

import com.github.tckz916.commandlog.CommandLog;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hayatarou_ on 2016/02/15.
 */
public class PlayerListener implements Listener {

    private CommandLog plugin = CommandLog.getInstance();

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        List<ChatColor> colors = new ArrayList<>(Arrays.asList(ChatColor.values()));

        String color = plugin.getConfig().getString("color").toUpperCase();

        ChatColor chatColor;
        try {
            chatColor = ChatColor.valueOf(color);
        } catch (IllegalArgumentException e) {
            color = "GRAY";
        }

        for (Player players : plugin.getServer().getOnlinePlayers()) {
            if (!players.hasPermission("commandlog.see")) {
                return;
            }
            players.sendMessage(ChatColor.valueOf(color) + "[CL] " + player.getName() + ": " + event.getMessage());
        }
    }
}
