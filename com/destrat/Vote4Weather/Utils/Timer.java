package com.destrat.Vote4Weather.Utils;

import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.World;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import com.destrat.Vote4Weather.Main;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Timer extends BukkitRunnable
{
    private static int time;
    private static int delayedTime;
    
    static {
        Timer.time = 30;
        Timer.delayedTime = 6;
    }
    
    public static void startTimer() {
        final String sName = Main.plugin.getConfig().getString("ServerPrefix");
        new BukkitRunnable() {
            public void run() {
                if (Timer.time > 0) {
                    Timer.access$1(Timer.time - 1);
                }
                else {
                    this.cancel();
                    if (Arrays.votersKeep.size() > Arrays.votersClear.size()) {
                        for (final String players : Arrays.voters) {
                            final Player p = Bukkit.getPlayer(players);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + " Погода не изменилась! " + "Голосов за дождь: " + ChatColor.WHITE + Arrays.votersKeep.size() + ChatColor.RED + " Голосов против дождя: " + ChatColor.WHITE + Arrays.votersClear.size()));
                        }
                        Arrays.clearArrays();
                        Main.votingPeriod = false;
                        Timer.access$1(30);
                        return;
                    }
                    if (Arrays.votersClear.size() > Arrays.votersKeep.size()) {
                        for (final String players : Arrays.voters) {
                            final Player p = Bukkit.getPlayer(players);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.GREEN + " Установлена нормальная погода " + "Голосов за дождь: " + ChatColor.WHITE + Arrays.votersKeep.size() + ChatColor.GREEN + " Голосов против дождя: " + ChatColor.WHITE + Arrays.votersClear.size()));
                        }
                        Bukkit.getWorlds().get(0).setStorm(false);
                        Arrays.clearArrays();
                        Main.votingPeriod = false;
                        Timer.access$1(30);
                        return;
                    }
                    if (Arrays.votersKeep.size() == Arrays.votersClear.size()) {
                        for (final String players : Arrays.voters) {
                            final Player p = Bukkit.getPlayer(players);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.YELLOW + " Ничья! " + "Голосов за дождь: " + ChatColor.WHITE + Arrays.votersKeep.size() + ChatColor.YELLOW + " Голосов против дождя: " + ChatColor.WHITE + Arrays.votersClear.size()));
                        }
                        Arrays.clearArrays();
                        Main.votingPeriod = false;
                        Timer.access$1(30);
                    }
                }
            }
        }.runTaskTimer(Main.plugin, 0L, 20L);
    }
    
    public static void startDelayTimer() {
        new BukkitRunnable() {
            public void run() {
                if (Timer.delayedTime > 0) {
                    Timer.access$3(Timer.delayedTime - 1);
                    return;
                }
                this.cancel();
                Timer.access$3(6);
                if (Bukkit.getWorlds().get(0).hasStorm()) {
                    StartVote.startweathervote();
                }
            }
        }.runTaskTimer(Main.plugin, 0L, 20L);
    }
    
    static /* synthetic */ void access$1(final int time) {
        Timer.time = time;
    }
    
    static /* synthetic */ void access$3(final int delayedTime) {
        Timer.delayedTime = delayedTime;
    }
}
