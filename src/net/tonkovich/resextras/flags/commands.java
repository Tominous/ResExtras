package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class commands implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Commands(PlayerCommandPreprocessEvent event){
		Player player = event.getPlayer();
		Location loc = event.getPlayer().getLocation();
		Residence residence = new Residence();
		boolean resadmin = residence.isResAdminOn(player);
		ClaimedResidence res = residence.getResidenceManager().getByLoc(loc);
		String playername = player.getName();
		if(res!=null && !res.getPermissions().playerHas(playername, "commands", true)&&!resadmin){
			event.setCancelled(true);
			event.getPlayer().sendMessage(derpa + "You cannot use commands here!");
		}
	}
	ChatColor derpa = ChatColor.RED;
}
