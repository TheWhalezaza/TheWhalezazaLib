package me.thewhalezaza.thewhalezazalib;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TWZLibralyCommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("thewhalezazalib.use")){
                if(args[0].equalsIgnoreCase("sendCommandAsConsole")){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args[1]);
                    return true;
                }
            }else {
                TWZLibralyMessageManager.getInstance().sendMessage("§f[§aTheWhalezazaLib§f] §7", "§4You don't have permissions to do this!", TWZLibraly.getInstance());
                return true;
            }
        }else {
            TWZLibralyMessageManager.getInstance().sendMessage("§f[§aTheWhalezazaLib§f] §7", "§4Only player can execute this command!", TWZLibraly.getInstance());
            return true;
        }
        return true;
    }
}
