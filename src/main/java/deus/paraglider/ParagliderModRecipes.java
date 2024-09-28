package deus.paraglider;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeRegistry;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;

import static deus.paraglider.ParagliderMod.MOD_ID;
import static deus.paraglider.ParagliderMod.paraglider;

public class ParagliderModRecipes extends RecipeRegistry {
	public static final RecipeNamespace PARAGLIDER = new RecipeNamespace();


	public static void InitRecipes() {
		RecipeBuilder.Shaped(MOD_ID).setShape(
				" F ",
				"LCL",
				"SIS")
			.addInput('F', Item.featherChicken)
			.addInput('S', Item.string)
			.addInput('L', Item.leather)
			.addInput('C', Item.cloth)
			.addInput('I', Item.ingotIron)
			.create("ParagliderRecipe", paraglider.getDefaultStack());
	}

	public static void InitNameSpaces() {
		final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));
		PARAGLIDER.register("workbench", WORKBENCH);
		Registries.RECIPES.register("paraglider", PARAGLIDER);
	}

}
