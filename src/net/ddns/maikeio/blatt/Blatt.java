package net.ddns.maikeio.blatt;

import org.bukkit.plugin.java.JavaPlugin;

import net.ddns.maikeio.customblock.CustomBlockHandler;
import net.ddns.maikeio.nbtrecipe.NBTRecipeHandler;

public class Blatt extends JavaPlugin{

	private NBTRecipeHandler recipeHandler;
	private CustomBlockHandler blockHandler;
	
	@Override
	public void onEnable(){
		recipeHandler = new NBTRecipeHandler(this);
		blockHandler = new CustomBlockHandler(this);
	}

	public NBTRecipeHandler getNBTRecipeHandler() {
		return recipeHandler;
	}

	public CustomBlockHandler getCustomBlockHandler() {
		return blockHandler;
	}
}
