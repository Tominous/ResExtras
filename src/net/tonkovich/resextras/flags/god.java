package net.tonkovich.resextras.flags;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;





import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

public class god implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void God(EntityDamageEvent event){
		if(event.isCancelled())
			return;
		try {
		Player player = ((Player) event.getEntity());
        World world = player.getWorld();
		String playername = player.getName();
        Location location = player.getLocation();
        PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(location);
	    if(event.getEntity() instanceof Player){
		if(area!=null){
			if(!area.allowAction(playername, FlagManagerExtras.GOD)){
				event.setCancelled(true);
	            world.playEffect(location, Effect.MOBSPAWNER_FLAMES, 4);
			}
	}
		}
		} catch (Exception ex) {
			
		}
	    }
	}
