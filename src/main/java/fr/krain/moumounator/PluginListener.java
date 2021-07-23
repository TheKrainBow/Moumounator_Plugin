package fr.krain.moumounator;

import org.bukkit.Material;
import fr.krain.moumounator.mmo.spells.SpellMage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PluginListener implements Listener {

    private Plugin main;
    public PluginListener(Plugin plugin) {
        this.main = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        SpellMage spellMage = new SpellMage(main);
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK && it != null) {
            if (it.getType() == Material.GOLDEN_HOE)
                spellMage.spellFireBall(player);
            if (it.getType() == Material.DIAMOND_HOE)
                spellMage.spellIceWall(player);
        }
    }
}
