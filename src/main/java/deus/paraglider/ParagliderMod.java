package deus.paraglider;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class ParagliderMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "paraglider";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ParagliderItem paraglider;


    @Override
    public void onInitialize() {
		LOGGER.info("Paraglider Mop initialized.");

		ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);
		paraglider = genericItemBuilder.setStackSize(1).build(new ParagliderItem("paraglider",11000));
		CreativeHelper.setPriority(paraglider, 1000);
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
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

	@Override
	public void initNamespaces() {

	}
}
