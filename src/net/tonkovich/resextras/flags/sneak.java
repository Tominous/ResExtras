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
		if(!player.isSprinting() && (!player.isSneaking()))
			return;
		boolean resadmin = Residence.getInstance().isResAdminOn(player);
		if (resadmin) {
			return;
		}
		ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getPlayer().getLocation());
		String playername = player.getName();
		if(res!=null) {
			if(!res.getPermissions().playerHas(playername, "sneak", true) && player.isSneaking()) {
				long currentTime = System.currentTimeMillis();
				event.setCancelled(true);
				if(currentTime%2000>=0 && currentTime%2000<=100){
					player.sendMessage(derpa + "You cannot sneak here!");
				}
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}