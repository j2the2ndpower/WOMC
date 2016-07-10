package ninja.pixelnova.womc;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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

            Inventory menuInventory = Bukkit.createInventory(null, 9, "Menu of Destiny");
            menuInventory.setItem(4, new ItemStack(Material.DIAMOND, 1));
            
            target.openInventory(menuInventory);
            
    		return true;
    	} //If this has happened the function will return true. 
    	
    	return false; 
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	Player player = (Player) e.getWhoClicked();
    	ItemStack clicked = e.getCurrentItem();
    	Inventory inventory = e.getInventory();
    	
    	if (inventory.getName().equals("Menu of Destiny")) {
    		if (clicked.getType() == Material.DIAMOND) {
    			player.setHealth(0);
    		}
    	}
    }
}
