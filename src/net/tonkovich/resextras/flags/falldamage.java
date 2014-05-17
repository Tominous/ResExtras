package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class falldamage implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void FallDamage(EntityDamageEvent event){
		if(event.isCancelled())
			return;
		Entity entity = event.getEntity();
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(entity.getLocation());
	    if(event.getCause() == DamageCause.FALL && event.getEntity() instanceof Player){
		if(area!=null){
			if(!area.allowAction(FlagManagerExtras.FALLDAMAGE)){
				event.setCancelled(true);
			}
	}
		}
	    }
}
