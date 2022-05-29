package spigot.sage.cardinal.events;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BanPlayerPermanently {
    public static void ban(Player executor, Player target, String reason) {
        Bukkit.getBanList(BanList.Type.NAME)
                .addBan(
                        target
                                .getDisplayName(),
                        reason,
                        null,
                        executor
                                .getDisplayName()
                );

        if ( target.isOnline() ) {
            target.kickPlayer("");
        }

        executor.sendMessage("");
    }
}
