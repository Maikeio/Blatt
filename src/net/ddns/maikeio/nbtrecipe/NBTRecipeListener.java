package net.ddns.maikeio.nbtrecipe;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;

public class NBTRecipeListener implements Listener {
	CraftingHandler handler;

	public NBTRecipeListener(CraftingHandler handler) {
		this.handler = handler;
	}

	@EventHandler
	public void PrepareSmithingEvent(PrepareSmithingEvent event) {

		ItemStack result = handler.getSmithingTableResult(event.getInventory().getItem(0),
				event.getInventory().getItem(1));
		if (result != null)
			event.setResult(result);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void InventoryEvent(InventoryClickEvent event) {

		ItemStack result = handler.giveSmithinTableResult(event.getInventory(), event.getRawSlot());
		if (result != null)
			event.setCursor(result);
	}
}
