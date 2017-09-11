package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class portal implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Portal(PlayerPortalEvent event){
		if(event.isCancelled())
			return;
		Player player = event.getPlayer();
		Location loc = event.getPlayer().getLocation();
		ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(loc);
		boolean resadmin = Residence.getInstance().isResAdminOn(player);
		if(res!=null){
			if(!res.getPermissions().playerHas(player.getName(), "portal", true)&&!resadmin){
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot use portals here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}