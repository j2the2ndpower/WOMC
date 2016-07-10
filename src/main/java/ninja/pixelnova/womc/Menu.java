package ninja.pixelnova.womc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
 
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
		        player.setHealth(0);
		        player.getInventory().addItem(new ItemStack(Material.COAL, 1));
	        }
        }
    }
}