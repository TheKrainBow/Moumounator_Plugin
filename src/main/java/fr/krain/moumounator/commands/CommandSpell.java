package fr.krain.moumounator.commands;

import fr.krain.moumounator.Plugin;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CommandSpell implements CommandExecutor {
    private Plugin main;

    public CommandSpell(Plugin plugin) {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player)sender;
            spellFireBall(player);
            return true;
        }
        return false;
    }

    public void spellFireBall(Player player)
    {
        Location SpellLocation = player.getLocation();
        SpellLocation.add(0, 2, 0);
        Vector dir = player.getLocation().getDirection();
        player.sendMessage(dir.getX() + " " + dir.getY() + " " + dir.getZ());
        World world = player.getWorld();
        for (int i = 0 ; i < 1000 ; i++) {
            world.spawnParticle(Particle.FLAME, SpellLocation, 1, 0, 0, 0, 0.01);
            SpellLocation.add(dir);
        }
    }
}
