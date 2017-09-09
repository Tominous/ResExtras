package net.tonkovich.resextras.flags;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class god implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void God(EntityDamageEvent event){
		if(event.isCancelled())
			return;
		try {
			Entity entity = event.getEntity();
			Player player = ((Player) event.getEntity());
			World world = player.getWorld();
			String playername = player.getName();
			Residence residence = new Residence();
			Location location = player.getLocation();
			ClaimedResidence res = residence.getResidenceManager().getByLoc(entity.getLocation());
			if(event.getEntity() instanceof Player){
				if(res!=null){
					if(res.getPermissions().playerHas(playername, "god", false)){
						event.setCancelled(true);
						world.playEffect(location, Effect.MOBSPAWNER_FLAMES, 4);
					}
				}
			}
		}
		catch (Exception ex)
		{

		}
	}
}
