package spigot.sage.cardinal.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;

public class BanPlayerTemporarily {
    public static void ban(Player executor, Player target, String reason, int duration) {
        Bukkit.getBanList(BanList.Type.NAME)
                .addBan(
                        target
                                .getDisplayName(),
                        reason,
                        new Date(System.currentTimeMillis() + duration),
                        executor
                                .getDisplayName());

        if ( target.isOnline() ) {
            target.kickPlayer("");
        }

        executor.sendMessage("");
    }
}
