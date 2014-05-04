package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class animalkilling implements Listener {
	public Player cause;
	@EventHandler(priority = EventPriority.NORMAL)
	public void AnimalKilling (EntityDamageByEntityEvent event){
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

		if (res!=null && !res.getPermissions().playerHas(cause.getName().toString(), "animalkilling", true)) {
			if ((entity instanceof Animals) || (entity instanceof IronGolem) || (entity instanceof Snowman)) {
				cause.sendMessage(ChatColor.RED + "You cannot kill animals here!");
				event.setCancelled(true);
			}
	}
	}
}
