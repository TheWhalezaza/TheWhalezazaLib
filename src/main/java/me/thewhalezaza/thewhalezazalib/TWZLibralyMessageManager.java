package me.thewhalezaza.thewhalezazalib;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TWZLibralyMessageManager {
    public static TWZLibralyMessageManager getInstance() {
        TWZLibralyMessageManager twzLibralyMessageManager = new TWZLibralyMessageManager();
        return twzLibralyMessageManager;
    }

    public void sendMessage(String prefix, String msg, Plugin plugin){
        if(TWZLibraly.getInstance().plugins.contains(plugin)){
            plugin.getServer().getConsoleSender().sendMessage(prefix + msg);
            return;
        }else {
            plugin.getServer().getConsoleSender().sendMessage("Plugin "+ plugin.getName() +" is not hook! Please report this to developer");
            return;
        }
    }

    public void sendMessage(String prefix, String msg, Plugin plugin, Player player){
        if(TWZLibraly.getInstance().plugins.contains(plugin)){
            player.sendMessage(prefix + msg);
            return;
        }else {
            plugin.getServer().getConsoleSender().sendMessage("Plugin "+ plugin.getName() +" is not hook! Please report this to developer");
            return;
        }
    }

    public void sendMessage(String prefix, String msg, Plugin plugin, Server server){
        if(TWZLibraly.getInstance().plugins.contains(plugin)){
            server.broadcastMessage(prefix + msg);
            return;
        }else {
            plugin.getServer().getConsoleSender().sendMessage("Plugin "+ plugin.getName() +" is not hook! Please report this to developer");
            return;
        }
    }

    public String formatColor(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
