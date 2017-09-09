package net.tonkovich.resextras.flags;

import org.bukkit.entity.Snowman;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class snowgolem implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void SnowGolem(CreatureSpawnEvent event)
	{
		FlagPermissions FlagPermissions = Residence.getInstance().getPermsByLoc(event.getLocation());
		LivingEntity Entity = event.getEntity();
		if (FlagPermissions == null)
			return;
		if (Entity instanceof Snowman)
		{
			if (FlagPermissions.has("snowgolem", true))
				return;
			event.setCancelled(true);
		}
	}
}
