package mymod._05_LuckyBlock;

import java.util.Random;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuckyBlock extends Block{

	public LuckyBlock(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		
		Random rand=new Random();
		
		int number = rand.nextInt(100)+1;
		
		System.out.println(number);

		if(number<=5){     //5% - 15 chicken
			for(int i=0;i<15;i++){
				Codakid.spawnEntity(world, pos, new EntityChicken(world));	
			}
		}
		else if(number<15){ //10%- 16 diamonds
			Codakid.spawnItem(world, pos, Items.DIAMOND, 16);
		}
		else if(number<20){ // 5% - 3 lucky blocks
			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 5);
		}
		else if(number<40){  //20% - nothing
			
		}
		else if(number < 79){
			Codakid.spawnItem(world, pos, Items.DIAMOND_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_AXE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_PICKAXE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HOE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_SHOVEL, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_SWORD, rand.nextInt(2)+1);
			for(int i=0;i<rand.nextInt(6)+2;i++){
				Codakid.spawnEntity(world, pos,new EntityZombie(world));
			}
			Codakid.spawnItem(world, pos, Items.DIAMOND_BOOTS, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_CHESTPLATE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HELMET, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_LEGGINGS, 1);
		}
		else if(number <80){
			Codakid.spawnEntity(world, pos, new EntityWither(world));
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
			Codakid.spawnEntity(world, pos, new EntityGiantZombie(world));
		}
		else if(number <95){
			for(int i=0;i<rand.nextInt(7)+4;i++)
			Codakid.spawnEntity(world, pos, new EntityVillager(world));
		}
		else if(number<99){
			Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, rand.nextInt(3)+5);
			Codakid.spawnBlock(world, pos, Blocks.REDSTONE_BLOCK, 3);
			Codakid.spawnBlock(world, pos, Blocks.END_STONE, 1);
		}
		else{
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 10);
		}
	}

}
