package me.glaremasters.multispawn.commands;

import co.aikar.commands.ACFBukkitUtil;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import me.glaremasters.multispawn.MultiSpawn;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by GlareMasters
 * Date: 10/21/2018
 * Time: 3:54 PM
 */
@CommandAlias("ms|multispawn")
public class Commands extends BaseCommand {

    @Dependency
    private MultiSpawn multiSpawn;

    @Subcommand("setspawn")
    @CommandPermission("ms.setspawn")
    private void onSpawn(Player player) {
        List<String> spawns = multiSpawn.getConfig().getStringList("spawn-list");
        spawns.add(ACFBukkitUtil.fullLocationToString(player.getLocation()));
        multiSpawn.getConfig().set("spawn-list", spawns);
        multiSpawn.saveConfig();
        multiSpawn.reloadConfig();
        player.sendMessage("New Spawn Set!");
    }

    @HelpCommand
    @CommandPermission("ms.help")
    private void onHelp(CommandHelp help) {
        help.showHelp();
    }
}
