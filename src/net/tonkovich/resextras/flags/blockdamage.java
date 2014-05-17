package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class blockdamage implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void BlockDamage(EntityExplodeEvent event) {
	    if(event.isCancelled())
	        return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
	    if(area!=null) {
	        if(!area.allowAction(FlagManagerExtras.BLOCKDAMAGE)) {
	            event.setCancelled(true);
	        }
	    }
}
}
