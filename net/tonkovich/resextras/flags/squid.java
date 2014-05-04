package net.tonkovich.resextras.flags;

import org.bukkit.entity.Squid;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class squid implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
    public void Squid(CreatureSpawnEvent event)
    {
    	FlagPermissions FlagPermissions = Residence.getPermsByLoc(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (FlagPermissions == null)
    		return;
    	if (Entity instanceof Squid)
    	{
        	if (FlagPermissions.has("squid", true))
    			return;
    			event.setCancelled(true);
   	    }
}
}