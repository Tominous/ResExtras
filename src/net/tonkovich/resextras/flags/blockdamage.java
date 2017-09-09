package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class blockdamage implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void BlockDamage(EntityExplodeEvent event) {
		Residence residence = new Residence();
		if(event.isCancelled())
			return;
		ClaimedResidence res = residence.getResidenceManager().getByLoc(event.getLocation());
		if(res!=null) {
			if(!res.getPermissions().has("blockdamage", true)) {
				event.setCancelled(true);
			}
		}
	}
}
