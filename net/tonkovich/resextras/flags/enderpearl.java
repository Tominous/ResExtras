package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class enderpearl implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Enderpearl(PlayerTeleportEvent event){
		if(event.isCancelled())
			return;
		Location loc = event.getTo();
		Player player = event.getPlayer();
		ClaimedResidence res = Residence.getResidenceManager().getByLoc(loc);
		boolean resadmin = Residence.isResAdminOn(player);
		String playername = player.getName();
		if(res!=null){
			if(event.getCause()==TeleportCause.ENDER_PEARL && !res.getPermissions().playerHas(playername, "enderpearl", true)&&!resadmin){
					event.setCancelled(true);
					event.getPlayer().sendMessage(derpa + "You cannot use ender pearls here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}