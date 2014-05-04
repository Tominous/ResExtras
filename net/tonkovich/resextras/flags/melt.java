package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class melt implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public void Melt(BlockFadeEvent event) {
	    if(event.isCancelled())
	        return;
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getBlock().getLocation());
	    if(res!=null) {
	        if(!res.getPermissions().has("melt", true)) {
	            event.setCancelled(true);
	        }
	    }
	    else {
	        if (!Residence.getWorldFlags().getPerms(event.getBlock().getWorld().getName()).has("melt", true)) {
	            event.setCancelled(true);
	        }
	    }
	}
}