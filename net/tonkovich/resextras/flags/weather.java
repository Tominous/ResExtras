package net.tonkovich.resextras.flags;

import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.bekvon.bukkit.residence.event.ResidenceEnterEvent;
import com.bekvon.bukkit.residence.event.ResidenceFlagChangeEvent;
import com.bekvon.bukkit.residence.event.ResidenceLeaveEvent;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.FlagPermissions.FlagState;

public class weather implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
    public void onResidenceEvent(ResidenceEnterEvent event) {
   	 	Player player = event.getPlayer();
   	 	ClaimedResidence res = event.getResidence();
	    if(res!=null) {
	    if(res.getPermissions().isSet("weather")){
	        if(res.getPermissions().has("weather", true)) {
	            player.setPlayerWeather(WeatherType.DOWNFALL);
	            return;
	        }
	        if(!res.getPermissions().has("weather", false)) {
	            player.setPlayerWeather(WeatherType.CLEAR);
	            return;
	        }
	    }
	    }
    }
	@EventHandler(priority = EventPriority.NORMAL)
    public void onResidenceEvent(ResidenceLeaveEvent event) {
   	 	ClaimedResidence res = event.getResidence();
	    if(res.getPermissions().isSet("weather")){
   	 	Player player = event.getPlayer();
	    player.resetPlayerWeather();
	    }
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onResidenceFlag(ResidenceFlagChangeEvent event) {
		if (event.getFlag().equalsIgnoreCase("weather")) {
			ClaimedResidence res = event.getResidence();
			if (event.getNewState() == FlagState.TRUE) {
				for (Player player: res.getPlayersInResidence()) {
					player.setPlayerWeather(WeatherType.DOWNFALL);
				}
			}
			if (event.getNewState() == FlagState.FALSE) {
				for (Player player: res.getPlayersInResidence()) {
					player.setPlayerWeather(WeatherType.CLEAR);
				}
			}
			if (event.getNewState() == FlagState.NEITHER) {
				for (Player player: res.getPlayersInResidence()) {
					player.resetPlayerWeather();
				}
		}
	}
}
}
