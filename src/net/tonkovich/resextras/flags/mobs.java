package net.tonkovich.resextras.flags;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;
import net.tonkovich.resextras.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class mobs implements Listener{
    private Main main = Main.getInstance();

    @EventHandler(priority = EventPriority.NORMAL)
    public void Mobs(CreatureSpawnEvent event) {

        String[] flagList = main.getEnabledFlags();

        // Work around residence creeper flag
        for (int i = 0; i < flagList.length; i++ ) {
            if(flagList[i].equalsIgnoreCase("creeperspawn")){
                flagList[i] = "creeper"; // Change for entity type
            }
        }

        FlagPermissions fp = Residence.getInstance().getPermsByLoc(event.getLocation());
        if (fp == null)
            return;
        EntityType entityType = event.getEntityType();

        for (String item: flagList) {
            if (entityType.getName().equalsIgnoreCase(item)) {
                if (!fp.has(item, true)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
