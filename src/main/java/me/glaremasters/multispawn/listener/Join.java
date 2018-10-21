package me.glaremasters.multispawn.listener;

import co.aikar.commands.ACFBukkitUtil;
import me.glaremasters.multispawn.MultiSpawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Random;

/**
 * Created by GlareMasters
 * Date: 10/21/2018
 * Time: 3:58 PM
 */
public class Join implements Listener {

    private MultiSpawn ms;

    public Join(MultiSpawn ms) {
        this.ms = ms;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            List<String> spawns = ms.getConfig().getStringList("spawn-list");
            Random rand = new Random();
            String randomSpawn = spawns.get(rand.nextInt(spawns.size()));
            player.teleport(ACFBukkitUtil.stringToLocation(randomSpawn));
        }
    }
}
