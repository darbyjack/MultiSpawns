package me.glaremasters.multispawn;

import co.aikar.commands.BukkitCommandManager;
import me.glaremasters.multispawn.commands.Commands;
import me.glaremasters.multispawn.listener.Join;
import org.bukkit.plugin.java.JavaPlugin;

public final class MultiSpawn extends JavaPlugin {

    private BukkitCommandManager manager;

    @Override
    public void onEnable() {

        manager = new BukkitCommandManager(this);
        manager.enableUnstableAPI("help");
        manager.registerCommand(new Commands());
        getServer().getPluginManager().registerEvents(new Join(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
