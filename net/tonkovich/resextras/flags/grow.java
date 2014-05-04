package net.tonkovich.resextras.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.world.StructureGrowEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class grow implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void StructureGrow(StructureGrowEvent event){
	    if(event.isCancelled())
	        return;
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getLocation());
	    if(res!=null) {
	        if(!res.getPermissions().has("grow", true)) {
	            event.setCancelled(true);
	            return;
	        }
	    }
	}
@EventHandler(priority = EventPriority.NORMAL)
public void BlockGrow(BlockGrowEvent event){
    if(event.isCancelled())
        return;
    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getBlock().getLocation());
    if(res!=null) {
        if(!res.getPermissions().has("grow", true)) {
            event.setCancelled(true);
            return;
        }
    }
}
@EventHandler(priority = EventPriority.NORMAL)
public void BlockGrowSpread(BlockSpreadEvent event){
    if(event.isCancelled())
        return;
    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getBlock().getLocation());
    if(res!=null) {
        if(!res.getPermissions().has("grow", true)) {
            event.setCancelled(true);
            return;
        }
    }
}
}
