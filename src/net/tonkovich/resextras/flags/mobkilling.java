package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class mobkilling implements Listener {
	public Player cause;
	@EventHandler(priority = EventPriority.NORMAL)
	public void Mobkilling(EntityDamageByEntityEvent event){
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

		if (area!=null && !area.allowAction(cause.getName().toString(), FlagManagerExtras.MOBKILLING)) {
			if (entity instanceof Monster) {
				cause.sendMessage(ChatColor.RED + "You cannot kill mobs here!");
				event.setCancelled(true);
			}
	}
	}
}