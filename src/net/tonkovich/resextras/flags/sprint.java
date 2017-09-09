package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class sprint implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void Sprint(PlayerMoveEvent event){
		if(event.isCancelled())
			return;
		Player player = event.getPlayer();
		String playername = player.getName();
		Residence residence = new Residence();
		boolean resadmin = residence.isResAdminOn(player);
		if (resadmin) {
			return;
		}
		if(!player.isSprinting() && (!player.isSneaking()))
			return;
		ClaimedResidence res = residence.getResidenceManager().getByLoc(event.getPlayer().getLocation());
		if(res!=null) {
			if(!res.getPermissions().playerHas(playername, "sprint", true) && player.isSprinting()) {
				event.setCancelled(true);
				long currentTime = System.currentTimeMillis();
				if(currentTime%2000>=0 && currentTime%2000<=100){
					event.getPlayer().sendMessage(derpa + "You cannot sprint here!");
					return;
				}
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}