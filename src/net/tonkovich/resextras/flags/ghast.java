package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ghast implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void Ghast(CreatureSpawnEvent event)
    {
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (area == null)
    		return;
    	if (Entity instanceof Ghast)
    	{
        	if (area.allowAction(FlagManagerExtras.GHAST_SPAWN))
    			return;
    		event.setCancelled(true);
   	    }
    }
}