package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class hunger implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Hunger(FoodLevelChangeEvent event){
		if(event.isCancelled())
			return;
		Residence residence = new Residence();
		ClaimedResidence res = residence.getResidenceManager().getByLoc(event.getEntity().getLocation());
		if(res!=null) {
			if(!res.getPermissions().has("hunger", true)) {
				event.setCancelled(true);
				return;
			}
		}
	}
}