package mymod;

import mymod.CodakidFiles.Codakid;
import mymod._04_CreateACreature.CustomArcher;
import mymod._04_CreateACreature.CustomMob;
import mymod._04_CreateACreature.RenderCustomMob;
import mymod._04_CreateACreature.myMob;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.awt.Color;

@Mod.EventBusSubscriber
public class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent e) {
    	
    	//************* REGISTER BLOCKS AND ITEMS ***************
	    
    	
    	
    	//************* REGISTER MOBS ***************
    	Codakid.registerMobEntity(CustomMob.class, "my_mob", RenderCustomMob.FACTORY, 0x499be3, 0x5ee3f2);
    	EntityRegistry.addSpawn(CustomMob.class, 1500, 15, 20, EnumCreatureType.CREATURE, Biomes.FOREST,Biomes.DESERT,Biomes.PLAINS);
    	
    	Codakid.registerMobEntity(CustomArcher.class, "my_mob", RenderCustomMob.FACTORY, 0x499be3, 0x5ee3f2);
    	EntityRegistry.addSpawn(CustomArcher.class, 1500, 15, 20, EnumCreatureType.CREATURE, Biomes.FOREST,Biomes.DESERT,Biomes.PLAINS);
    	
    	
    	// ************* MAKE RENDERERS ***************
    	
    	
        
        //************* REGISTER ENTITIES ***************
    	
    	
        
        //************* REGISTER BIOMES ***************
    	
    	
    }

    public void init(FMLInitializationEvent e) {
        
        //************* REGISTER WORLD GEN ***************


        
    	//************* SMELTING RECIPES ***************
    	
    	
    	
    	//************* BIOME SETUP ***************


    	
    }
    

    public void postInit(FMLPostInitializationEvent e) {
    	
    }
    
    
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    	Codakid.doBiomeRegistry(event);
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	Codakid.doBlockRegistry(event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	Codakid.doItemRegistry(event);
    }

}
