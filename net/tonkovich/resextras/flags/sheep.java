package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class sheep implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void Sheep(CreatureSpawnEvent event)
    {
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (area == null)
    		return;
    	if (Entity instanceof Sheep)
    	{
        	if (area.allowAction(FlagManagerExtras.SHEEP_SPAWN))
    			return;
    		event.setCancelled(true);
   	    }
    }
}