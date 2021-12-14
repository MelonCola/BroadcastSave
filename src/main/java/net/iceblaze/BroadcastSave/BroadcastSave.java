package net.iceblaze.BroadcastSave;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BroadcastSave extends JavaPlugin implements Listener {
    private String msg;

    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        msg = getConfig().getString("message");
    }

    @EventHandler
    public void worldSaveEvent(WorldSaveEvent e) {
        Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', msg.replace("%WORLD%", e.getWorld().getName())), "broadcastsave.see");
    }

}
