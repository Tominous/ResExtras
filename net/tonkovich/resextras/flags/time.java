package net.tonkovich.resextras.flags;
 
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
 
import com.bekvon.bukkit.residence.event.ResidenceEnterEvent;
import com.bekvon.bukkit.residence.event.ResidenceFlagChangeEvent;
import com.bekvon.bukkit.residence.event.ResidenceLeaveEvent;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.FlagPermissions.FlagState;
 
public class time implements Listener {
 
        @EventHandler(priority = EventPriority.NORMAL)
    public void onResidenceEvent(ResidenceEnterEvent event) {
                Player player = event.getPlayer();
            ClaimedResidence res = event.getResidence();
            if(res!=null) {
                if(res.getPermissions().has("day", false)) {
                    player.setPlayerTime(6000, false);
                    return;
                }
                if(res.getPermissions().has("night", false)) {
                    player.setPlayerTime(14000, false);
                    return;
                }
            }
    }
        @EventHandler(priority = EventPriority.NORMAL)
    public void onResidenceEvent(ResidenceLeaveEvent event) {
                Player player = event.getPlayer();
                ClaimedResidence res = event.getResidence();
        if(res.getPermissions().has("night", false) || res.getPermissions().has("day", false)) {
            player.resetPlayerTime();
        }
        }
    	@EventHandler(priority = EventPriority.NORMAL)
    	public void onResidenceFlag(ResidenceFlagChangeEvent event) {
			ClaimedResidence res = event.getResidence();
    		if (event.getFlag().equalsIgnoreCase("day")) {
    			if (event.getNewState() == FlagState.TRUE) {
    				for (Player player: res.getPlayersInResidence()) {
    					player.setPlayerTime(6000, false);
    				}
    			}
    			if (event.getNewState() == FlagState.FALSE) {
    				for (Player player: res.getPlayersInResidence()) {
    					player.resetPlayerTime();
    				}
    			}
    			if (event.getNewState() == FlagState.NEITHER) {
    				for (Player player: res.getPlayersInResidence()) {
    					player.resetPlayerTime();
    				}
    		}
    		}
    		if (event.getFlag().equalsIgnoreCase("night")) {
    			if (event.getNewState() == FlagState.TRUE) {
    				for (Player player: res.getPlayersInResidence()) {
    					player.setPlayerTime(14000, false);
    				}
    			}
        		if (event.getNewState() == FlagState.FALSE) {
        			for (Player player: res.getPlayersInResidence()) {
        				player.resetPlayerTime();
        				}
        			}
        		if (event.getNewState() == FlagState.NEITHER) {
        			for (Player player: res.getPlayersInResidence()) {
        				player.resetPlayerTime();
        				}
        		}
    			}
    		}
    	}
