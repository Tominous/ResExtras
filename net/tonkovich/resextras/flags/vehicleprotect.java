package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.utils.Utilities;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class vehicleprotect implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleDestroy(VehicleDestroyEvent event){
		if(event.isCancelled())
			return;
		try {
		Location loc = event.getVehicle().getLocation();
		Entity attacker = event.getAttacker();
		Vehicle vehicle = event.getVehicle();
		Player player;
		player = (Player)attacker;
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(loc);
		boolean resadmin = Utilities.isAdminMode(player);
		String playername = player.getName();
		if(area!=null){
			if(!area.allowAction(playername, FlagManagerExtras.VEHICLEPROTECT) && !resadmin && (vehicle instanceof Minecart || vehicle instanceof Boat) && (attacker instanceof Player || attacker instanceof Monster)){
				event.setCancelled(true);
				player.sendMessage(derpa + "You cannot destroy vehicles here!");
				return;
			}
		}
		} catch (Exception ex) {
			
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleDestroyEntity(VehicleDestroyEvent event){
		if(event.isCancelled())
			return;
		Location loc = event.getVehicle().getLocation();
		Entity attacker = event.getAttacker();
		Vehicle vehicle = event.getVehicle();
		PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(loc);
		if(area!=null){
			if(!area.allowAction(FlagManagerExtras.VEHICLEPROTECT) && (vehicle instanceof Minecart || vehicle instanceof Boat) && attacker instanceof Monster){
				event.setCancelled(true);
				return;
			}
		}
	}
	ChatColor derpa = ChatColor.RED;
}