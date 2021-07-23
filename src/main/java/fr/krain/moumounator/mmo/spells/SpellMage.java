package fr.krain.moumounator.mmo.spells;

import fr.krain.moumounator.Plugin;
import fr.krain.moumounator.mmo.MmoParticle;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spellcaster;
import org.bukkit.util.Vector;


public class SpellMage implements CommandExecutor {
    private Plugin main;
    public SpellMage(Plugin plugin) {
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
        Location SpellLocation = player.getEyeLocation();
        Vector dir = player.getEyeLocation().getDirection();
        World world = player.getWorld();
        for (int i = 0 ; i < 1000 ; i++) {
            world.spawnParticle(Particle.FLAME, SpellLocation, 20, 0.2, 0.2, 0.2, 0.05);
            SpellLocation.add(dir);
            if (SpellLocation.distance(player.getEyeLocation()) > 20)
                return ;
            if (!SpellLocation.getBlock().isPassable() || SpellLocation.getBlock().isLiquid())
                return ;
            Entity[] tab = SpellLocation.getChunk().getEntities();
            for (Entity e : tab){
                if (e instanceof LivingEntity && e.getLocation().distance(SpellLocation) <= 2 && e != (Entity)player) {
                    ((org.bukkit.entity.LivingEntity)e).damage(50);
                    return ;
                }
            }
        }
    }

    public void spellIceWall(Player player)
    {
        Location SpellLocation = player.getEyeLocation();
        Vector dir = player.getEyeLocation().getDirection();
        double y = SpellLocation.getY();
        y--;
        Vector wallDir = new Vector(-(dir.getZ() * 3), y, (dir.getX() * 3));
        dir.multiply(4);
        SpellLocation.add(dir);
        SpellLocation.add(wallDir);
        SpellLocation.setY(y);
        SpellLocation.getBlock().setType(Material.LIGHT_BLUE_CONCRETE);
        SpellLocation.subtract(wallDir);
        SpellLocation.subtract(wallDir);
        SpellLocation.setY(y);
        SpellLocation.getBlock().setType(Material.LIGHT_BLUE_CONCRETE);
        World world = player.getWorld();
    }
}
