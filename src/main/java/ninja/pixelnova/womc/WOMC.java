package ninja.pixelnova.womc;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WOMC extends JavaPlugin {
    @Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
    	getLogger().info("WOMC ENABLED!");
    	
    	/*for (Player player : Bukkit.getServer().getOnlinePlayers()) {
    	    playerList.put(player.getName(), playerData(player));
    	}*/
    }
    
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("WOMC NOT UN-DE-ENABLED!");
    }
    
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
      getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " is logging in!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
    		// doSomething, I SAID DO SOMETHING
    		getLogger().log(Level.INFO, "Player " + sender.getName() + " typed BASIC, EVERYONE BE SURE TO SPAM THEM!");
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the value of false will be returned.
    	return false; 
    }
}
