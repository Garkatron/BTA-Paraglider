package deus.paraglider;


import deus.gravitylib.interfaces.IGravityObject;
import deus.gravitylib.interfaces.accesor.ILivingEntity;
import deus.gravitylib.main;
import net.minecraft.client.Minecraft;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;

public class ParagliderItem extends Item {

	protected boolean activated = false;
	private Minecraft minecraft;

	public ParagliderItem(int id) {
		super(id);
		minecraft = Minecraft.getMinecraft(this);
	}

	public ParagliderItem(String name, int id) {
		super(name, id);
		minecraft = Minecraft.getMinecraft(this);
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {

		IGravityObject iLivingEntity = (IGravityObject) entityplayer;
		iLivingEntity.gravityLib$setYGravityScale(0.1f);
		activated = !activated;


		this.minecraft.sndManager.playSound("random.click", SoundCategory.GUI_SOUNDS, 1.0F, 1.0F);


		return super.onUseItem(itemstack, world, entityplayer);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		super.inventoryTick(itemstack, world, entity, i, flag);


		IGravityObject iLivingEntity = (IGravityObject) entity;


		if (entity.onGround || entity.isInWater() || entity.isInLava()) {
			activated = false;
		}

		if (activated) {
			entity.flySpeed = 0.06f;

		} else {
			entity.flySpeed = 0.02f;
			iLivingEntity.gravityLib$setYGravityScale(main.MOD_CONFIG.getDouble("overworld.y_gravity_scale.value"));
		}
	}
}
