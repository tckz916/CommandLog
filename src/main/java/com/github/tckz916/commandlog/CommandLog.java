package com.github.tckz916.commandlog;

import com.github.tckz916.commandlog.listener.PlayerListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tckz916 on 2015/09/27.
 */
public class CommandLog extends JavaPlugin {

    private static CommandLog instance;

    private PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;

        pluginManager.registerEvents(new PlayerListener(), this);

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static CommandLog getInstance() {
        return instance;
    }
}
