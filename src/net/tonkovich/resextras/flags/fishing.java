package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class fishing implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Fishing(PlayerFishEvent event){
		Player player = event.getPlayer();
		ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getPlayer().getLocation());
		boolean resadmin = Residence.getInstance().isResAdminOn(player);
		if(res!=null) {
			if(!res.getPermissions().playerHas(player.getName(), "fishing", true) && !resadmin) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot fish here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}
