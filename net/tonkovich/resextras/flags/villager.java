package net.tonkovich.resextras.flags;

import org.bukkit.entity.Villager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class villager implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
    public void Villager(CreatureSpawnEvent event)
    {
    	FlagPermissions FlagPermissions = Residence.getPermsByLoc(event.getLocation());
    	LivingEntity Entity = event.getEntity();
    	if (FlagPermissions == null)
    		return;
    	if (Entity instanceof Villager)
    	{
        	if (FlagPermissions.has("villager", true))
    			return;
    			event.setCancelled(true);
   	    }
}
}