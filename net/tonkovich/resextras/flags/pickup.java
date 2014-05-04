package net.tonkovich.resextras.flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class pickup implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void PickupItem(PlayerPickupItemEvent event){
		if(event.isCancelled())
			return;
		Player player = event.getPlayer();
		boolean resadmin = Residence.isResAdminOn(player); 
		ClaimedResidence res = Residence.getResidenceManager().getByLoc (event.getItem().getLocation());
		String playername = player.getName();
		if(res!=null){
			if(!res.getPermissions().playerHas(playername, "pickup", true)&&!resadmin){
				event.setCancelled(true);
				event.getPlayer().sendMessage(derpa + "You cannot pickup items here!");
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}