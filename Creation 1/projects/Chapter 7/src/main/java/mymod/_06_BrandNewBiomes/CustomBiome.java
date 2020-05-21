package mymod._06_BrandNewBiomes;

import java.awt.Color;
import java.util.Random;

import mymod.Main;
import mymod.CodakidFiles.CKWorldGenerater;
import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CustomBiome extends Biome {
	
	private static BiomeProperties properties = new Biome.BiomeProperties("Rhineland");
	static {
		
	    //Set properties here
		properties.setBaseHeight(0.5F);
		properties.setHeightVariation(1F);
		properties.setWaterColor(Color.CYAN.getRGB());
		properties.setTemperature(0f);
		//properties.setRainDisabled();
	}

	public CustomBiome() {
		super(properties);
		this.setRegistryName(new ResourceLocation(Main.MODID, "my_biome"));
		
		this.decorator.bigMushroomsPerChunk = 100;
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityVillager.class, 100, 3, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 1000, 2, 3));
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
			
		super.decorate(worldIn, rand, pos);
		
		WorldGenerator wg;
		wg = new CKWorldGenerater(Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), 50000);
		wg.generate(worldIn, rand, pos);
		
		wg = new CKWorldGenerater(Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), 50000);
		wg.generate(worldIn, rand, pos);
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunk, int num1, int num2, double num3) {
		
		//Set top and filler blocks here
		
		
		
		Random number = new Random();
		int n = number.nextInt(10)+1;
		
		if(n< 9){
			this.topBlock = Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK);
		}
		else {
			this.topBlock = Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED);
		}
		
		if(n<5){
			this.fillerBlock = Blocks.ICE.getDefaultState();
		}
		else if(n<6){
			this.fillerBlock = Blocks.DIAMOND_BLOCK.getDefaultState();
		}
		else if(n<9){
			this.fillerBlock = Blocks.IRON_BLOCK.getDefaultState();
		}
		else{
			this.fillerBlock = Blocks.CLAY.getDefaultState();
		}
		this.generateBiomeTerrain(worldIn, rand, chunk, num1, num2, num3);
	}

}
