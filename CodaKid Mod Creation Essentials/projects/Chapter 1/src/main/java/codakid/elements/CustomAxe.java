package codakid.elements;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CustomAxe extends ItemAxe {

	//Declare variables here
	public int power = 3;
	public String axeName="my_axe";

	public CustomAxe(ToolMaterial material) {
		super(material, 1, 1);
		//Write your code here
		this.setUnlocalizedName(axeName);
		this.setRegistryName(axeName);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		//Create your conditional statement here
		if(!world.isRemote){
			world.spawnEntity(CK.getFireball(world, player, power));
		}

		return super.onItemRightClick(world, player, hand);
	}
}
