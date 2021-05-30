package me.thewhalezaza.thewhalezazalib;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class TWZLibralyRegisterManager {
    public static TWZLibralyRegisterManager getInstance() {
        TWZLibralyRegisterManager twzLibralyRegisterManager = new TWZLibralyRegisterManager();
        return twzLibralyRegisterManager;
    }

    public void registerCommand(String name, CommandExecutor executor, Plugin plugin){
        if(TWZLibraly.getInstance().plugins.contains(plugin)) {
            plugin.getServer().getPluginCommand(name).setExecutor(executor);
        }else{
            plugin.getServer().getConsoleSender().sendMessage("Plugin "+ plugin.getName() +" is not hook! Please report this to developer");
            return;
        }
    }

    public void registerListener(Listener listener, Plugin plugin){
        if(TWZLibraly.getInstance().plugins.contains(plugin)) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }else{
            plugin.getServer().getConsoleSender().sendMessage("Plugin "+ plugin.getName() +" is not hook! Please report this to developer");
            return;
        }
    }

}
