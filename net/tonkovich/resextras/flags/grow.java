package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class grow implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void StructureGrow(StructureGrowEvent event){
	    if(event.isCancelled())
	        return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getLocation());
	    if(area!=null) {
	        if(!area.allowAction(FlagManagerExtras.GROW)) {
	            event.setCancelled(true);
	            return;
	        }
	    }
	}
@EventHandler(priority = EventPriority.NORMAL)
public void BlockGrow(BlockGrowEvent event){
    if(event.isCancelled())
        return;
    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getBlock().getLocation());
    if(area!=null) {
        if(!area.allowAction(FlagManagerExtras.GROW)) {
            event.setCancelled(true);
            return;
        }
    }
}
@EventHandler(priority = EventPriority.NORMAL)
public void BlockGrowSpread(BlockSpreadEvent event){
    if(event.isCancelled())
        return;
    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getBlock().getLocation());
    if(area!=null) {
        if(!area.allowAction(FlagManagerExtras.GROW)) {
            event.setCancelled(true);
            return;
        }
    }
}
}
