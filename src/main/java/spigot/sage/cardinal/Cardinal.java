package spigot.sage.cardinal;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cardinal extends JavaPlugin {
    private static Cardinal plugin;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin = this;
        config.options().copyDefaults(true);

    }

    public static Cardinal getInstance() {
        return plugin;
    }

    public FileConfiguration getConfigFile() {
        return config;
    }
}
