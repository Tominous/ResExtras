package net.tonkovich.resextras.flags;

import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class irongolem implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void IronGolem(CreatureSpawnEvent event)
	{
		FlagPermissions FlagPermissions = Residence.getInstance().getPermsByLoc(event.getLocation());
		LivingEntity Entity = event.getEntity();
		if (FlagPermissions == null)
			return;
		if (Entity instanceof IronGolem)
		{
			if (FlagPermissions.has("irongolem", true))
				return;
			event.setCancelled(true);
		}
	}
}