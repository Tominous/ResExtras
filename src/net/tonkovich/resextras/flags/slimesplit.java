package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SlimeSplitEvent;

public class slimesplit implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void SlimeSplit(SlimeSplitEvent event){
	    if(event.isCancelled())
	        return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getEntity().getLocation());
	    if(area!=null) {
	        if(!area.allowAction(FlagManagerExtras.SLIMESPLIT)) {
	        		event.setCancelled(true);
	        	}
	        }
	    }
}