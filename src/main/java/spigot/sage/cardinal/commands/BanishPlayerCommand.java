package spigot.sage.cardinal.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import spigot.sage.cardinal.events.BanPlayerPermanently;
import spigot.sage.cardinal.events.BanPlayerTemporarily;
import spigot.sage.cardinal.util.ConvertDuration;

public class BanishPlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ( !( sender instanceof Player ) ) {
            //error message

            return false;
        }

        Player ingameExecutor = (Player) sender;

        if ( !ingameExecutor.hasPermission("permission") ) {
            //error message

            return false;
        }

        if ( args.length < 2 || args.length > 3 ) {
            //error message

            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if ( target == null ) {
            //error message

            return false;
        }

        String reason = args[1];

        if ( args.length == 2 )
            BanPlayerPermanently.ban(ingameExecutor, target, reason);
        else {
            String durationArgument = args[2];
            int duration = ConvertDuration.getDuration(durationArgument);

            if (duration == 0) {
                //error message

                return false;
            }

            BanPlayerTemporarily.ban(ingameExecutor, target, reason, duration);
        }

        return false;
    }
}
