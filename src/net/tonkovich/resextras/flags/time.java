package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.t00thpick1.residence.api.areas.ResidenceArea;
import net.t00thpick1.residence.api.events.PlayerChangedAreaEvent;
import net.t00thpick1.residence.api.events.ResidenceAreaFlagsChangedEvent;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class time implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onResidenceEvent(PlayerChangedAreaEvent event) {
		Player player = event.getPlayer();
		PermissionsArea areaTo = event.getTo();
		if(areaTo!=null) {
			if(areaTo.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_DAY) && areaTo.getAreaFlags().get(FlagManagerExtras.ALWAYS_DAY)) {
				player.setPlayerTime(6000, false);
				return;
			}
			if(areaTo.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_NIGHT) && areaTo.getAreaFlags().get(FlagManagerExtras.ALWAYS_NIGHT)) {
				player.setPlayerTime(14000, false);
				return;
			}
		}

		PermissionsArea areaFrom = event.getFrom();
		if ((areaFrom.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_DAY) && areaFrom.getAreaFlags().get(FlagManagerExtras.ALWAYS_DAY) || 
				(areaFrom.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_NIGHT) && areaFrom.getAreaFlags().get(FlagManagerExtras.ALWAYS_NIGHT))))
		{
			player.resetPlayerTime();
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onResidenceFlag(ResidenceAreaFlagsChangedEvent event) {
		ResidenceArea area = event.getResidenceArea();
		if(area!=null) {
			if(area.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_DAY) && area.getAreaFlags().get(FlagManagerExtras.ALWAYS_DAY)) {
				for (Player player: area.getPlayersInResidence()) {
					player.setPlayerTime(6000, false);
				}
				return;
			}
			if(area.getAreaFlags().containsKey(FlagManagerExtras.ALWAYS_NIGHT) && area.getAreaFlags().get(FlagManagerExtras.ALWAYS_NIGHT)) {
				for (Player player: area.getPlayersInResidence()) {
					player.setPlayerTime(14000, false);
				}
				return;
			}

			for (Player player: area.getPlayersInResidence()) {
				player.resetPlayerTime();
			}
		}

	}
}
