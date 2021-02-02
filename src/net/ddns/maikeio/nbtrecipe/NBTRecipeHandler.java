package net.ddns.maikeio.nbtrecipe;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class NBTRecipeHandler {

	HashMap<String, SmithingNBTRecipe> SmithingRecipe;
	HashMap<String, ShapelessNBTRecipe> ShapelessRecipe;

	public NBTRecipeHandler(JavaPlugin plugin) {
		this.SmithingRecipe = new HashMap<String, SmithingNBTRecipe>();
		this.ShapelessRecipe = new HashMap<String, ShapelessNBTRecipe>();
		CraftingHandler handler = new CraftingHandler(this);
		plugin.getServer().getPluginManager().registerEvents(new NBTRecipeListener(handler), plugin);
	}

	public void addSmithingNBTRecipe(SmithingNBTRecipe recipe) {
		if (SmithingRecipe.containsKey(recipe.getName()))
			return;

		Optional<Entry<String, SmithingNBTRecipe>> matchingRecipes = this.SmithingRecipe.entrySet().parallelStream()
				.filter(r -> r.getValue().getResult().getType() == recipe.getResult().getType()
						&& r.getValue().getAddition().isSimilar(recipe.getAddition()))
				.findAny();

		if (matchingRecipes.isEmpty())
			SmithingRecipe.put(recipe.getName(), recipe);

	}

	public void addShapelessNBTRecipe(ShapelessNBTRecipe recipe) {
		if (SmithingRecipe.containsKey(recipe.getName()))
			return;
		ShapelessRecipe.put(recipe.getName(), recipe);
	}

	public void forceAddSmithingNBTRecipe(SmithingNBTRecipe recipe) {
		SmithingRecipe.put(recipe.getName(), recipe);
	}

	public void forceAddShapelessNBTRecipe(ShapelessNBTRecipe recipe) {
		ShapelessRecipe.put(recipe.getName(), recipe);
	}

	public ShapelessNBTRecipe getShapelessNBTRecipe(String name) {
		return ShapelessRecipe.get(name);
	}

	public SmithingNBTRecipe getSmithingNBTRecipe(String name) {
		return SmithingRecipe.get(name);
	}

	public HashMap<String, ShapelessNBTRecipe> getShapelessNBTRecipe() {
		return ShapelessRecipe;
	}

	public HashMap<String, SmithingNBTRecipe> getSmithingNBTRecipe() {
		return SmithingRecipe;
	}
}
