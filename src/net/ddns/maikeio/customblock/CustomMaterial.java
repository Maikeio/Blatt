package net.ddns.maikeio.customblock;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomMaterial {
	private String name;
	private Material type;
	private CustomBlockTexture texture;
	private ItemStack placeItem;
	
	public CustomMaterial(String name, Material type, ItemStack placeItem) {
		this.name = name;
		this.type = type;
		this.texture = null;
		this.placeItem = placeItem;
	}
	
	public CustomMaterial(String name, CustomBlockTexture texture, ItemStack placeItem) {
		this.name = name;
		this.type = null;
		this.texture = texture;
		this.placeItem = placeItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getType() {
		return type;
	}

	public void setType(Material type) {
		this.type = type;
	}

	public CustomBlockTexture getTexture() {
		return texture;
	}

	public void setTexture(CustomBlockTexture texture) {
		this.texture = texture;
	}

	public ItemStack getPlaceItem() {
		return placeItem;
	}

	public void setPlaceItem(ItemStack placeItem) {
		this.placeItem = placeItem;
	}
	
}
