package fr.krain.moumounator;

import fr.krain.moumounator.commands.CommandClass;
import fr.krain.moumounator.commands.CommandWarp;
import fr.krain.moumounator.commands.CommandSpell;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("Moumounator just started. :)");
        getCommand("spawn").setExecutor(new CommandWarp(this));
        getCommand("warp").setExecutor(new CommandWarp(this));
        getCommand("warps").setExecutor(new CommandWarp(this));
        getCommand("class").setExecutor(new CommandClass(this));
        getCommand("spell").setExecutor(new CommandSpell(this));
        getServer().getPluginManager().registerEvents(new PluginListener(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Moumounator just stopped. :o");

    }
}