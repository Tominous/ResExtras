package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class villagerkilling implements Listener {
	public Player cause;
	@EventHandler(priority = EventPriority.NORMAL)
	public void VillagerKilling(EntityDamageByEntityEvent event){
		if(event.isCancelled()) {
			return;
		}
		Entity damager = ((EntityDamageByEntityEvent) event).getDamager();
		if ((!(damager instanceof Arrow)) && (!(damager instanceof Player))) {
			return;
		}
		if ((damager instanceof Arrow) && (!(((Arrow) damager).getShooter() instanceof Player))) {
			return;
		} else if (damager instanceof Player) {
			cause = (Player) damager;
		} else {
			cause = (Player) ((Arrow) damager).getShooter();
		}
		boolean resadmin = Residence.isResAdminOn(cause);
		if (resadmin) {
			return;
		}
		Entity entity = event.getEntity();
		ClaimedResidence res = Residence.getResidenceManager().getByLoc(entity.getLocation());

		if (res!=null && !res.getPermissions().playerHas(cause.getName().toString(), "villagerkilling", true)) {
			if (entity instanceof Villager) {
				cause.sendMessage(ChatColor.RED + "You cannot kill villagers here!");
				event.setCancelled(true);
			}
	}
	}
}
