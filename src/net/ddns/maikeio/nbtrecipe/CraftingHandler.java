package net.ddns.maikeio.nbtrecipe;

import java.util.Map.Entry;
import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingHandler {
	NBTRecipeHandler handler;

	public CraftingHandler(NBTRecipeHandler handler) {
		this.handler = handler;
	}

	public ItemStack getSmithingTableResult(ItemStack base, ItemStack addition) {

		if (base == null || addition == null)
			return null;

		Optional<Entry<String, SmithingNBTRecipe>> matchingRecipes = handler.getSmithingNBTRecipe().entrySet()
				.parallelStream().filter(recipe -> recipe.getValue().getResult().getType() == base.getType()
						&& recipe.getValue().getAddition().isSimilar(addition))
				.findAny();

		if (matchingRecipes.isEmpty())
			return null;

		SmithingNBTRecipe recipe = matchingRecipes.get().getValue();
		ItemStack result = base.clone();
		ItemMeta meta = result.getItemMeta();

		meta.setCustomModelData(recipe.getResult().getItemMeta().getCustomModelData());
		meta.setLore(recipe.getResult().getItemMeta().getLore());
		meta.setDisplayName(recipe.getResult().getItemMeta().getDisplayName());
		result.setItemMeta(meta);

		return result;
	}

	public ItemStack getShapelessResult(ItemStack[] ingredient) {
		return null;
	}

	public ItemStack giveSmithinTableResult(Inventory deInv, int rawSlot) {
		// Inventory of deInvstination

		// Test for Upgrade Item was put into upgrable Dropper
		if (deInv.getType() != InventoryType.SMITHING || rawSlot != 2)
			return null;

		if (deInv.getItem(2) == null)
			return null;

		ItemStack result = deInv.getItem(2);

		deInv.setItem(0, null);

		deInv.setItem(2, null);

		if (deInv.getItem(1).getAmount() == 1) {
			deInv.setItem(1, null);
			return result;
		}

		deInv.getItem(1).setAmount(deInv.getItem(1).getAmount() - 1);

		return result;
	}

}
