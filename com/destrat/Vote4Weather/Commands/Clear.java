package com.destrat.Vote4Weather.Commands;

import org.bukkit.ChatColor;
import com.destrat.Vote4Weather.Utils.Arrays;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.destrat.Vote4Weather.Main;
import org.bukkit.command.CommandExecutor;

public class Clear implements CommandExecutor
{
    String sName;
    
    public Clear() {
        this.sName = Main.plugin.getConfig().getString("ServerPrefix");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("voteclear")) {
            if (sender.hasPermission("WeatherVote.Clear")) {
                if (Main.votingPeriod) {
                    if (Arrays.voters.contains(sender.getName())) {
                        if (!Arrays.votersKeep.contains(sender.getName())) {
                            if (!Arrays.votersClear.contains(sender.getName())) {
                                Arrays.votersClear.add(sender.getName());
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.GREEN + "Голос против дождя учтен!"));
                            }
                            else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "Ты уже проголосовал!"));
                            }
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "Увы, но о своём решении нужно было думать заранее:("));
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "Ты не учавствуешь в текущем голосовании!"));
                    }
                }
                else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "С погодой всё ок и голосовать не надо!"));
                }
                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.RED + "Нет прав, обратись к админу!"));
        }
        return false;
    }
}
