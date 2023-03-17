package com.destrat.Vote4Weather.Events;

import org.bukkit.event.EventHandler;
import com.destrat.Vote4Weather.Utils.Arrays;
import org.bukkit.event.player.PlayerQuitEvent;
import com.destrat.Vote4Weather.Main;
import org.bukkit.event.Listener;

public class PlayerLeave implements Listener
{
    String sName;
    
    public PlayerLeave() {
        this.sName = Main.plugin.getConfig().getString("ServerPrefix");
    }
    
    @EventHandler
    public void playerleft(final PlayerQuitEvent event) {
        final String quitter = event.getPlayer().getName();
        if (Arrays.voters.contains(quitter)) {
            Arrays.voters.remove(quitter);
        }
    }
}
