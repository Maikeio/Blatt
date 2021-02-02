package net.ddns.maikeio.nbtrecipe;

import org.bukkit.inventory.ItemStack;

public class ShapelessNBTRecipe extends NBTRecipe{
	
	private ItemStack[] ingredient;

	public ShapelessNBTRecipe(String name) {
		super(name);
	}
	
	public ShapelessNBTRecipe(String name, ItemStack result) {
		super(name, result);
	}
	
	public ShapelessNBTRecipe(String name, ItemStack result, ItemStack[] ingredient) {
		super(name, result);
		this.ingredient = ingredient;
	}

	public ItemStack[] getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(ItemStack[] ingredient) {
		this.ingredient = ingredient;
	}

}
