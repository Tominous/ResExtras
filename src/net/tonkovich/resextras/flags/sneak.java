package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class sneak implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void Sneak(PlayerMoveEvent event){
		if(event.isCancelled())
			return;
		Player player = event.getPlayer();
		Residence residence = new Residence();
		if(!player.isSprinting() && (!player.isSneaking()))
			return;
		boolean resadmin = residence.isResAdminOn(player);
		if (resadmin) {
			return;
		}
		ClaimedResidence res = residence.getResidenceManager().getByLoc(event.getPlayer().getLocation());
		String playername = player.getName();
		if(res!=null) {
			if(!res.getPermissions().playerHas(playername, "sneak", true) && player.isSneaking()) {
				long currentTime = System.currentTimeMillis();
				if(currentTime%2000>=0 && currentTime%2000<=100){
					event.setCancelled(true);
					player.sendMessage(derpa + "You cannot sneak here!");
					return;
				}
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}