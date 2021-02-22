package net.ddns.maikeio.customblock;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomBlockHandler {

	private HashMap<Location, CustomBlock> placedCustomBlocks;
	private HashMap<String, CustomMaterial> customMaterials;

	public CustomBlockHandler(JavaPlugin plugin) {
		this.placedCustomBlocks = new HashMap<Location, CustomBlock>();
		this.customMaterials = new HashMap<String, CustomMaterial>();

		plugin.getServer().getPluginManager().registerEvents(new CustomBlockListener(this), plugin);
	}

	public void addCustomMaterial(CustomMaterial material) {
		this.customMaterials.put(material.getName(), material);
	}

	public HashMap<Location, CustomBlock> getPlacedCustomBlocks() {
		return placedCustomBlocks;
	}

	public CustomBlock getPlacedCustomBlock(Location location) {
		if (placedCustomBlocks.containsKey(location))
			return placedCustomBlocks.get(location);
		else return null;
	}


	public HashMap<String, CustomMaterial> getCustomMaterial() {
		return customMaterials;
	}
	
	public CustomMaterial getCustomMaterial(String name) {
		if (customMaterials.containsKey(name))
			return customMaterials.get(name);
		else return null;
	}
	
	void CustomblockPlaced(Location location){
		
	}
	
	void CustomBlockBreack(Location location) {
		
	}
}
