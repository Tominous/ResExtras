package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class shear implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void Shear(PlayerShearEntityEvent event){
	    if(event.isCancelled())
	        return;
		Player player = event.getPlayer();
	    ClaimedResidence res = Residence.getResidenceManager().getByLoc(event.getPlayer().getLocation());
	    boolean resadmin = Residence.isResAdminOn(player);
		String playername = player.getName();
		if(res!=null && !res.getPermissions().playerHas(playername, "shear", true)&&!resadmin){
			event.setCancelled(true);
			event.getPlayer().sendMessage(derpa + "You cannot shear here!");
		}
	}
	ChatColor derpa = ChatColor.RED;
}