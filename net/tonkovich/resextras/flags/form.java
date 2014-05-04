package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class form implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public void Form(BlockFormEvent event) {
	    if(event.isCancelled())
	        return;
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getBlock().getLocation());
	    if(res!=null) {
	        if(!res.getPermissions().has("form", true)) {
	            event.setCancelled(true);
	        }
	    }
	    else {
	        if (!Residence.getWorldFlags().getPerms(event.getBlock().getWorld().getName()).has("form", true)) {
	            event.setCancelled(true);
	        }
	    }
	}
}
