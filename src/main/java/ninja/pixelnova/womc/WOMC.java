package ninja.pixelnova.womc;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
    		sender.sendMessage("You pressed the basic button.  Prepare for spam.");
    		getLogger().log(Level.INFO, "Player " + sender.getName() + " typed BASIC, EVERYONE BE SURE TO SPAM THEM!");
    		
            // Get the player who should be set on fire. Remember that indecies start with 0, not 1.
            @SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(sender.getName());
            target.openInventory(Menu.myInventory);
            
    		return true;
    	} //If this has happened the function will return true. 
    	
    	return false; 
    }
}
