package com.destrat.Vote4Weather.Events;

import org.bukkit.event.EventHandler;
import com.destrat.Vote4Weather.Utils.Timer;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.Listener;

public class WeatherChange implements Listener
{
    @EventHandler
    public void weatherchanged(final WeatherChangeEvent event) {
        Timer.startDelayTimer();
    }
}
