package net.ddns.maikeio.nbtrecipe;

import org.bukkit.inventory.ItemStack;

public class SmithingNBTRecipe extends NBTRecipe{
	
	private ItemStack addition;

	public SmithingNBTRecipe(String name) {
		super(name);
	}
	
	public SmithingNBTRecipe(String name, ItemStack result) {
		super(name, result);
	}
	
	public SmithingNBTRecipe(String name, ItemStack addition, ItemStack result) {
		super(name, result);
		this.setAddition(addition);
	}

	public ItemStack getAddition() {
		return addition;
	}

	public void setAddition(ItemStack addition) {
		this.addition = addition;
	}

}
