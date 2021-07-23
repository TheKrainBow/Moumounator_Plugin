package fr.krain.moumounator;

import org.bukkit.Material;
import fr.krain.moumounator.commands.CommandSpell;
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
        CommandSpell cspell = new CommandSpell(main);
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it != null && it.getType() == Material.DIAMOND_HOE) {
            if (action == Action.RIGHT_CLICK_AIR) {
                cspell.spellFireBall(player);
            }
        }
    }
}
