package net.tonkovich.resextras.flags;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;


public class fallingblocks implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void fallingblocks(BlockPhysicsEvent event) {
        ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getBlock().getLocation());
        if (res != null) {
            if (!res.getPermissions().has("fallingblocks", true)) {
                event.setCancelled(true);
            }
        }
    }

    /* TODO: Figure out a way to stop them from turning invisible
       Right click or double place to fix
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void EntityChangeBlockEvent (EntityChangeBlockEvent event) {
        ClaimedResidence res = Residence.getInstance().getResidenceManager().getByLoc(event.getBlock().getLocation());
        if (res != null) {
            if (!res.getPermissions().has("fallingblocks", true)) {
                if (event.getEntityType() == EntityType.FALLING_BLOCK) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
