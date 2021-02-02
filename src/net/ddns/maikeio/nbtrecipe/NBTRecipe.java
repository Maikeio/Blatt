package net.ddns.maikeio.nbtrecipe;

import org.bukkit.inventory.ItemStack;

public abstract class NBTRecipe {
	private String name;
	private ItemStack result;

	public NBTRecipe(String name) {
		this.name = name;
	}
	
	public NBTRecipe(String name, ItemStack result) {
		this.name = name;
		this.result = result;
	}
	
	public void setResult(ItemStack result) {
		this.result = result;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ItemStack getResult() {
		return this.result;
	}
}
