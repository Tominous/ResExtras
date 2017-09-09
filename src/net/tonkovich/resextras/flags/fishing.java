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
		if(event.isCancelled())
			return;
		Player player = event.getPlayer();
		Residence residence = new Residence();
		ClaimedResidence res = residence.getResidenceManager().getByLoc(event.getPlayer().getLocation());
		boolean resadmin = residence.isResAdminOn(player);
		String playername = player.getName();
		if(res!=null) {
			if(!res.getPermissions().playerHas(playername, "fishing", true) && !resadmin) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot fish here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}
