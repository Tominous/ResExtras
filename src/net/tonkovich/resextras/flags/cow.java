package net.tonkovich.resextras.flags;

import org.bukkit.entity.Cow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class cow implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void Cow(CreatureSpawnEvent event)
	{
		Residence residence = new Residence();
		FlagPermissions FlagPermissions = residence.getPermsByLoc(event.getLocation());
		LivingEntity Entity = event.getEntity();
		if (FlagPermissions == null)
			return;
		if (Entity instanceof Cow)
		{
			if (FlagPermissions.has("cow", true))
				return;
			event.setCancelled(true);
		}
	}
}
