package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class squid implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void Squid(CreatureSpawnEvent event)
    {
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (area == null)
    		return;
    	if (Entity instanceof Squid)
    	{
        	if (area.allowAction(FlagManagerExtras.SQUID_SPAWN))
    			return;
    		event.setCancelled(true);
   	    }
    }
}