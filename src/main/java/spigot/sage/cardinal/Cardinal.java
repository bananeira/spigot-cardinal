package spigot.sage.cardinal;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import spigot.sage.cardinal.commands.BanishPlayerCommand;
import spigot.sage.cardinal.commands.BanishPlayerTabComplete;

import java.util.Objects;

public final class Cardinal extends JavaPlugin {
    private static Cardinal plugin;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin = this;
        config.options().copyDefaults(true);

        Objects.requireNonNull(getCommand("banish")).setExecutor(new BanishPlayerCommand());
        Objects.requireNonNull(getCommand("banish")).setTabCompleter(new BanishPlayerTabComplete());
    }

    public static Cardinal getInstance() {
        return plugin;
    }

    public FileConfiguration getConfigFile() {
        return config;
    }
}
