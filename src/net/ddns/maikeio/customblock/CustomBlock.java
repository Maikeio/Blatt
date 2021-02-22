package net.ddns.maikeio.customblock;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomBlock extends CustomMaterial{

	private Location location;
	
	CustomBlock(String name, Material blockType, ItemStack placeItem){
		super(name,blockType,placeItem);
	}
	
	CustomBlock(String name, CustomBlockTexture texture, ItemStack placeItem){
		super(name,texture,placeItem);
	}
	
	Location getLocation(){
		return this.location;
	}
	
	void setLocation(Location location) {
		this.location = location;
	}

	public Material getBlockType() {
		return getBlockType();
	}
}
