package ninja.pixelnova.womc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
 
public class Menu implements Listener {
    public static Inventory myInventory = Bukkit.createInventory(null, 9, "Menu of Destiny");
    static {
            myInventory.setItem(4, new ItemStack(Material.DIAMOND, 1));
            myInventory.setItem(8, new ItemStack(Material.GOLD_BLOCK, 1));
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(myInventory.getName())) {
	        if (clicked.getType() == Material.DIAMOND) {
		        event.setCancelled(true);
		        player.closeInventory();
		        player.getInventory().addItem(new ItemStack(Material.COAL, 1));
		        player.sendMessage("YOU HAVE BEEN A BAD BOY!!!");
		        Location loc = player.getLocation();
		        loc.add(0, 100, 0);
		        player.teleport(loc);
		        player.setFireTicks(300);
	        }
	        
	        if (clicked.getType() == Material.GOLD_BLOCK) {
	        	Location loc = player.getLocation();
	        	Vector dir = loc.getDirection();
	        	dir.multiply(3);
	        	loc.add(dir);
	        	
	        	Double i = loc.getY();
	        	Material b = player.getWorld().getBlockAt(loc).getType();
	        	Boolean LastBlockGround = false;
	        	
	        	while (b == Material.AIR && LastBlockGround == true) {
	        		b = player.getWorld().getBlockAt(loc).getType();
	        		if (b != Material.AIR) {
	        			loc.setY(loc.getY()+1);
	        			LastBlockGround = true;
	        		} else {
	        			loc.setY(loc.getY()-1);
	        			LastBlockGround = false;
	        		}
	        	}
	        	
	        	player.teleport(loc);
	        }
        }
    }
}