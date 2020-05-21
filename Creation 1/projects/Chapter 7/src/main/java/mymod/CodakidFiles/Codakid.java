package mymod.CodakidFiles;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

import mymod.Main;
import mymod._01_ForgeYourSword.CustomMonster;
import mymod._02_PowerOre.CustomOre;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenadeFragment;
import mymod._07_BuildAndBoom.EntityGrenade;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

 //Welcome to the Codakid helper file! I'm glad you decided to
 //take a look at some of the code we wrote to make your modding life easier.
 //All of the blue lines of text which looks like
/**
 * these are also comments. They will help explain what each method does.
 */
 //Hope you have fun looking through our code, and thanks again for taking a course with Codakid!
 // ANDY WAS HERE

public class Codakid {	 
	
	//**************************** Registry Stuff ****************************
	
	private static ArrayList<Block> blocksToRegister = new ArrayList<Block>();
    private static ArrayList<Item> itemsToRegister = new ArrayList<Item>();
    private static ArrayList<Biome> biomesToRegister = new ArrayList<Biome>();
    
	/**
	 * Registers a block and that block's item. Call this in preInit.
	 * 
	 * @param block
	 * @param registryName
	 */
	public static void registerBlock(Block block, String registryName) {
		block.setRegistryName(registryName);
		block.setUnlocalizedName(Main.MODID + "." + registryName);
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(registryName);
		blocksToRegister.add(block);
		itemsToRegister.add(itemBlock);
	}
	
	
	/**
	 * Registers an item. Call this in preInit.
	 * 
	 * @param item
	 * @param registryName
	 */
	public static void registerItem(Item item, String registryName) {
		item.setRegistryName(registryName);
		item.setUnlocalizedName(Main.MODID + "." + registryName);
		itemsToRegister.add(item);
	}
	
	/**
	 * Registers a biome. Call this in preInit.
	 * 
	 * @param biome
	 */
	public static void registerBiome(Biome biome) {
		biomesToRegister.add(biome);
	}
	
	static int id = 1;
	
	/**
	 * Registers a mob and its spawn egg. Call this in preInit.
	 * 
	 * @param entityClass
	 * @param name
	 * @param factory
	 * @param color1
	 * @param color2
	 */
	public static void registerMobEntity(Class entityClass, String name, IRenderFactory factory, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID+":"+name), entityClass, Main.MODID+"."+name, id++, Main.instance, 64, 3, true, color1, color2);
		RenderingRegistry.registerEntityRenderingHandler(entityClass, factory);
	}
	
	/**
	 * Registers an entity. Call this in preInit.
	 * 
	 * @param entityClass
	 * @param name
	 * @param factory
	 */
	public static void registerEntity(Class entityClass, String name, IRenderFactory factory) {
		EntityRegistry.registerModEntity(new ResourceLocation(Main.MODID+":"+name), entityClass, Main.MODID+"."+name, id++, Main.instance, 64, 3, true);
		RenderingRegistry.registerEntityRenderingHandler(entityClass, factory);
	}
	
	
	/**
	 * So, registerBlock, registerItem, and registerBiome don't actually register those things.
	 * They just add them to the blocksToRegister, itemsToRegister, and biomesToRegister lists.
	 * These three methods go through those lists and register everything at once.
	 */
	public static void doBlockRegistry(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(blocksToRegister.toArray(new Block[blocksToRegister.size()]));
	}
	public static void doItemRegistry(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(itemsToRegister.toArray(new Item[itemsToRegister.size()]));
	}
	public static void doBiomeRegistry(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(biomesToRegister.toArray(new Biome[biomesToRegister.size()]));		
	}
	
    /**
     * Initializes all the models, so that the game can actually show the stuff we tell it to.
     */
	public static void initModels() {
		for(Item item : itemsToRegister) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
		for(Block block : blocksToRegister) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
	}
	
	
	//**************************** Other Stuff ****************************
	
	
	/**
	 * Applies a potion effect to the player.
	 * 
	 * Potions come from the Potion list. Duration is counted in frames, so a duration of 30 will last one second.
	 * The amplifier will make the potion effect more powerful.
	 * 
	 * Example: Codakid.applyPotion(player, Potion.moveSpeed, 300, 3);
	 * 
	 * @param player
	 * @param potion
	 * @param duration
	 * @param amplifier
	 */
	public static void applyPotion(EntityPlayer player, Potion potion, int duration, int amplifier) {
		player.addPotionEffect(new PotionEffect(potion, duration, amplifier));
	}
	
	
	/**
	 * Sets the move speed of a mob.
	 * 
	 * @param mob
	 * @param value
	 */
	public static void setMovementSpeed(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(value);
	}
	
	
	/**
	 * Sets the attack damage of a mob.
	 * 
	 * @param mob
	 * @param value
	 */
	public static void setAttackDamage(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(value);
	}
	
	
	/**
	 * Sets the maximum health of a mob.
	 * 
	 * @param mob
	 * @param value
	 */
	public static void setMaxHealth(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(value);
	}
	
	
	/**
	 * Sets the follow range of a mob.
	 * (how close you have to be before the mob follows you) 
	 * 
	 * @param mob
	 * @param value
	 */
	public static void setFollowRange(EntityCreature mob, float value) {
		mob.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(value);
	}
	
	
	/**
	 * Spawns items of a given type at the block position.
	 * 
	 * @param world
	 * @param pos
	 * @param item
	 * @param count
	 */
	public static void spawnItem(World worldIn, BlockPos pos, Item item, int count)
	{
		for(int i = 0; i < count; i++)
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item)));
	}
	
	
	/**
	 * Spawns grabbable blocks of a given type at the block position.
	 * 
	 * @param world
	 * @param pos
	 * @param block
	 * @param count
	 */
	public static void spawnBlock(World worldIn, BlockPos pos, Block block, int count)
	{
		for(int i = 0; i < count; i++)
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block)));
	}
	
	
	/**
	 * Spawns a single entity of a given type at the block position with a minor, random offset. Retype this line to spawn multiple entities.
	 * 
	 * @param world
	 * @param pos
	 * @param entity
	 */
	public static void spawnEntity(World worldIn, BlockPos pos, Entity entity)
	{
		Random rand = new Random();
		entity.setPosition(pos.getX()+rand.nextInt(2), pos.getY()+rand.nextInt(2), pos.getZ()+rand.nextInt(2));
		worldIn.spawnEntity(entity);
	}
	
	/**
	 * Handles the ugly code of adding a block to the world generation.
	 * 
	 * @param world
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param minY
	 * @param maxY
	 * @param chance
	 * @param newBlock
	 * @param hostBlocks
	 */
	public static void fullGeneration(World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int chance, Block newBlock, Block... hostBlocks)
	{
			
		int veinSize = 3;
		int heightRange = maxY - minY;
		
		for(Block b : hostBlocks)
		{
			for(int i = 0; i < chance; i++) {
				int xRand = chunkX * 16 + random.nextInt(16);
				int yRand = random.nextInt(heightRange) + minY;
				int zRand = chunkZ * 16 + random.nextInt(16);
				new WorldGenMinable(newBlock.getDefaultState(), veinSize, BlockMatcher.forBlock(b)).generate(world, random, new BlockPos(xRand, yRand, zRand ));
			}
		}
	}

}
