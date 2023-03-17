package com.destrat.Vote4Weather;

import com.destrat.Vote4Weather.Commands.Keep;
import org.bukkit.command.CommandExecutor;
import com.destrat.Vote4Weather.Commands.Clear;
import com.destrat.Vote4Weather.Events.PlayerLeave;
import com.destrat.Vote4Weather.Events.WeatherChange;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    public static Boolean votingPeriod;
    public static Plugin plugin;
    
    static {
        Main.votingPeriod = false;
    }
    
    public void onEnable() {
        Main.plugin = (Plugin)this;
        Bukkit.getPluginManager().registerEvents((Listener)new WeatherChange(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerLeave(), (Plugin)this);
        this.getCommand("voteclear").setExecutor((CommandExecutor)new Clear());
        this.getCommand("votekeep").setExecutor((CommandExecutor)new Keep());
        this.loadConfig();
    }
    
    public void onDisable() {
        this.saveDefaultConfig();
    }
    
    private void loadConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }
}
