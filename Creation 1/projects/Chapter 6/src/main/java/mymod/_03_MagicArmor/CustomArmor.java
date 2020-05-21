package mymod._03_MagicArmor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CustomArmor extends ItemArmor{

	public CustomArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		
		player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20, 5));
		player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20, 5));
		
		if(this.armorType == EntityEquipmentSlot.FEET){
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 5));
		}
		
		if(this.armorType == EntityEquipmentSlot.HEAD){
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20, 5));
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20, 5));
		}
		
		super.onArmorTick(world, player, itemStack);
	}

}
