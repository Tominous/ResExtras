package net.tonkovich.resextras.flags;

import org.bukkit.entity.Zombie;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class zombie implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void Zombie(CreatureSpawnEvent event)
    {
    	FlagPermissions FlagPermissions = Residence.getPermsByLoc(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (FlagPermissions == null)
    		return;
    	if (Entity instanceof Zombie)
    	{
        	if (FlagPermissions.has("zombie", true))
    			return;
    			event.setCancelled(true);
   	    }
}
}
