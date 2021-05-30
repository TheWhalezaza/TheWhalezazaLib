package me.thewhalezaza.thewhalezazalib;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class TWZLibraly extends JavaPlugin {

    private static TWZLibraly instance;

   public List<Plugin> plugins = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        TWZLibralyRegisterManager registerManager = TWZLibralyRegisterManager.getInstance();
        registerManager.registerCommand("tlib", new TWZLibralyCommandManager(), this);
    }

    @Override
    public void onDisable() {
        plugins.clear();
        instance = null;
    }

    public static TWZLibraly getInstance() {
        return instance;
    }

    public void hook(Plugin plugin, boolean sendToConsole){
        if(plugins.contains(plugin)){
            return;
        }
        plugins.add(plugin);
        TWZLibralyMessageManager.getInstance().sendMessage("§f[§aTheWhalezazaLib§f] §7", "§6Hooked plugin", plugin);
        return;
    }

}
