package net.tonkovich.resextras.flags;

import org.bukkit.entity.Wolf;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class wolf implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void Wolf(CreatureSpawnEvent event)
	{
		Residence residence = new Residence();
		FlagPermissions FlagPermissions = residence.getPermsByLoc(event.getLocation());
		LivingEntity Entity = event.getEntity();
		if (FlagPermissions == null)
			return;
		if (Entity instanceof Wolf)
		{
			if (FlagPermissions.has("wolf", true))
				return;
			event.setCancelled(true);
		}
	}
}
