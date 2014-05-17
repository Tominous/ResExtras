package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class snowgolem implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void SnowGolem(CreatureSpawnEvent event)
    {
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (area == null)
    		return;
    	if (Entity instanceof Snowman)
    	{
        	if (area.allowAction(FlagManagerExtras.SNOWGOLEM_SPAWN))
    			return;
    		event.setCancelled(true);
   	    }
    }
}