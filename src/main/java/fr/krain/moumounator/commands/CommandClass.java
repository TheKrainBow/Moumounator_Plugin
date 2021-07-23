package fr.krain.moumounator.commands;

import fr.krain.moumounator.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {

    private Plugin main;

    public CommandClass(Plugin plugin) {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player)sender;
            player.sendMessage("I'm a player :D");
            return true;
        }
        return false;
    }
}
