package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

/**
 * Created by Sacha on 29/11/15.
 */
public class MorphSnowman extends Morph {

	private long coolDown = 0;
    public MorphSnowman(UUID owner) {
        super(owner, MorphType.SNOWNMAN);
        if (owner != null)
            Core.registerListener(this);
    }

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if ((event.getAction() == Action.LEFT_CLICK_AIR
                || event.getAction() == Action.LEFT_CLICK_BLOCK) && event.getPlayer() == getPlayer()) {
            if(coolDown > System.currentTimeMillis() ) return;
        	event.setCancelled(true);
            event.getPlayer().throwSnowball();
            coolDown = System.currentTimeMillis() + 500;
        }
    }
}
