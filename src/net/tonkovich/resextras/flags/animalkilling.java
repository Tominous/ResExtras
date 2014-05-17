package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

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

		boolean resadmin = Utilities.isAdminMode(cause);
		if (resadmin) {
		    return;
		}

		Entity entity = event.getEntity();
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(entity.getLocation());

		if (area!=null && !area.allowAction(cause.getName().toString(), FlagManagerExtras.ANIMALKILLING)) {
			if ((entity instanceof Animals) || (entity instanceof IronGolem) || (entity instanceof Snowman)) {
				cause.sendMessage(ChatColor.RED + "You cannot kill animals here!");
				event.setCancelled(true);
			}
		}
	}
}
