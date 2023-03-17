package com.destrat.Vote4Weather.Utils;

import java.util.Iterator;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import com.destrat.Vote4Weather.Main;

public class StartVote
{
    public static void startweathervote() {
        final String sName = Main.plugin.getConfig().getString("ServerPrefix");
        for (final Player players : Bukkit.getOnlinePlayers()) {
            Arrays.voters.add(players.getName());
            Main.votingPeriod = true;
            final TextComponent weatherVoteC = new TextComponent();
            final TextComponent weatherVoteK = new TextComponent();
            weatherVoteC.setText(ChatColor.translateAlternateColorCodes('&', "§eКликни сюда чтобы проголосовать &aЗА &eотключение дождя!"));
            weatherVoteC.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder('&', "§eКликни чтобы выключить дождь!").create()));
            weatherVoteC.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/voteclear"));
            weatherVoteK.setText(ChatColor.translateAlternateColorCodes('&', "&eКликни сюда чтобы проголосовать &cПРОТИВ &eотключения дождя!"));
            weatherVoteK.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder('&', "§eКликни чтобы оставить дождь!").create()));
            weatherVoteK.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/votekeep"));
            players.spigot().sendMessage((BaseComponent)weatherVoteC);
            players.spigot().sendMessage((BaseComponent)weatherVoteK);
        }
        Timer.startTimer();
    }
}
