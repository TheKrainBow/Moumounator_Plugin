package fr.krain.moumounator.commands;

import fr.krain.moumounator.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandWarp implements CommandExecutor {
    private Plugin main;

    public CommandWarp(Plugin plugin) {
        this.main = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getLabel().equalsIgnoreCase("spawn")) {
                Location warp = getLocationOf("spawn");
                player.sendMessage("Teleporting to " + warp.getX() + " " + warp.getY() + " " + warp.getZ());
                System.out.println("Teleporting [" + player.getName() + "] to " + warp.getX() + " " + warp.getY() + " " + warp.getZ());
                player.teleport(warp);
                return true;
            } else if (cmd.getLabel().equalsIgnoreCase("warp")) {
                if (args.length == 0) {
                    player.sendMessage("Correct use: /warp <warp>. Use /warps to see all available warps");
                    return true;
                }
                else {
                    Location warp = getLocationOf(args[0]);
                    player.sendMessage("Teleporting to " + warp.getX() + " " + warp.getY() + " " + warp.getZ());
                    System.out.println("Teleporting [" + player.getName() + "] to " + warp.getX() + " " + warp.getY() + " " + warp.getZ());
                    player.teleport(warp);
                }
            } else if (cmd.getLabel().equalsIgnoreCase("warps")) {
                printWarps(player);
            }
        }
        return false;
    }

    public void printWarps(Player player)
    {
        player.sendMessage("Available warps:");
        for (String str : main.getConfig().getConfigurationSection("warp").getKeys(false)) {
            player.sendMessage("  - " + str);
        }
    }

    public Location getLocationOf(String warp)
    {
        Location    dest;

        for (String str : main.getConfig().getConfigurationSection("warp").getKeys(false)) {
            if (str.equalsIgnoreCase(warp) && main.getConfig() != null)
            {
                dest = new Location(Bukkit.getWorld(Objects.requireNonNull(main.getConfig().getString("warp." + str + ".world"))),
                        Objects.requireNonNull(main.getConfig().getDouble("warp." + str + ".x")),
                        Objects.requireNonNull(main.getConfig().getDouble("warp." + str + ".y")),
                        Objects.requireNonNull(main.getConfig().getDouble("warp." + str + ".z")),
                        Objects.requireNonNull(main.getConfig().getInt("warp." + str + ".yawn")),
                        Objects.requireNonNull(main.getConfig().getInt("warp." + str + ".pitch")));
                return (dest);
            }
        }
        return (null);
    }
}
