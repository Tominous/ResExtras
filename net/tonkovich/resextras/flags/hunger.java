package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class hunger implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Hunger(FoodLevelChangeEvent event){
	    if(event.isCancelled())
	        return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getEntity().getLocation());
	    String playername = event.getEntity().getName();
	    if(area!=null) {
	        if(!area.allowAction(playername, FlagManagerExtras.HUNGER)) {
	            event.setCancelled(true);
	            return;
	        }
	    }
	}
}