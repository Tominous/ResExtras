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
		try {
			Entity entity = event.getEntity();
			Player player = ((Player) event.getEntity());
			Location location = player.getLocation();
			ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(entity.getLocation());
			if(event.getEntity() instanceof Player){
				if(res!=null){
					if(res.getPermissions().playerHas(player.getName(), "god", false)){
						event.setCancelled(true);
						player.getWorld().playEffect(location, Effect.MOBSPAWNER_FLAMES, 4);
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.getStackTrace();
		}
	}
}
