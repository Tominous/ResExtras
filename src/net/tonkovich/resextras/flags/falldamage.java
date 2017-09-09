package net.tonkovich.resextras.flags;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class falldamage implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void FallDamage(EntityDamageEvent event){
		if(event.isCancelled())
			return;
		Entity entity = event.getEntity();
		Residence residence = new Residence();
		ClaimedResidence res = residence.getResidenceManager().getByLoc(entity.getLocation());
		if(event.getCause() == DamageCause.FALL && event.getEntity() instanceof Player){
			if(res!=null){
				if(!res.getPermissions().has("falldamage", true)){
					event.setCancelled(true);
				}
			}
		}
	}
}
