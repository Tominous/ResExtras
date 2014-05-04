package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PigZapEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class pigzap implements Listener {

@EventHandler(priority = EventPriority.NORMAL)
public void PiggyZap(PigZapEvent event){
    if(event.isCancelled())
        return;
    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getEntity().getLocation());
    if(res!=null) {
        if(!res.getPermissions().has("pigzap", true)) {
        		event.setCancelled(true);
        	}
        }
    }
}