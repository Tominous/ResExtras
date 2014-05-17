package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.api.areas.ResidenceArea;
import net.t00thpick1.residence.api.events.PlayerChangedAreaEvent;
import net.t00thpick1.residence.api.events.ResidenceAreaFlagsChangedEvent;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class weather implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
    public void onResidenceEvent(PlayerChangedAreaEvent event) {
   	 	Player player = event.getPlayer();
   	 	PermissionsArea areaTo = event.getTo();
	    if(areaTo!=null) {
	    if(areaTo.getAreaFlags().containsKey(FlagManagerExtras.WEATHER))
	    {
	         if(areaTo.getAreaFlags().get(FlagManagerExtras.WEATHER) == true) {
	            player.setPlayerWeather(WeatherType.DOWNFALL);
	            return;
	        }
	        if(areaTo.getAreaFlags().get(FlagManagerExtras.WEATHER) == false) {
	            player.setPlayerWeather(WeatherType.CLEAR);
	            return;
	        }
	    }
	    }
	    
	    PermissionsArea areaFrom = event.getFrom();
	    if (areaFrom.getAreaFlags().containsKey(FlagManagerExtras.WEATHER))
	    	player.resetPlayerWeather();
    }

	@EventHandler(priority = EventPriority.NORMAL)
	public void onResidenceFlag(ResidenceAreaFlagsChangedEvent event) {
   	 		ResidenceArea area = event.getResidenceArea();
			 	 		
   	 		if (area != null && area.getAreaFlags().containsKey(FlagManagerExtras.WEATHER))
   	 		{
   	 			if (area.getAreaFlags().get(FlagManagerExtras.WEATHER) == true)
   	 			{
   					for (Player player: area.getPlayersInResidence()) {
   						player.setPlayerWeather(WeatherType.DOWNFALL);
   					}
   					return;
   	 			}

   	 			if (area.getAreaFlags().get(FlagManagerExtras.WEATHER) == false)
   	 			{
   					for (Player player: area.getPlayersInResidence()) {
   						player.setPlayerWeather(WeatherType.CLEAR);
   					}
   					return;
   	 			}
   	 			
				for (Player player: area.getPlayersInResidence()) {
					player.resetPlayerWeather();
				}
   	 		}
	}
}
   	 				
