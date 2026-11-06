package me.usainsrht.antiflood;

import me.usainsrht.antiflood.listener.PistonListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiFlood extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PistonListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
