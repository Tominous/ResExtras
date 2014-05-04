package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class lightning implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Lightning(LightningStrikeEvent event){
	    if(event.isCancelled())
	        return;
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getLightning().getLocation());
	    if(res!=null) {
	        if(!res.getPermissions().has("lightning", true)) {
	            event.setCancelled(true);
	            return;
	        }
	    }
	}
}