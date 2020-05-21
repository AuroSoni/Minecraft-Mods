package mymod;

import mymod.CodakidFiles.Codakid;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.awt.Color;

@Mod.EventBusSubscriber
public class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent e) {
    	
    	//************* REGISTER BLOCKS AND ITEMS ***************
	    
    	
    	
    	//************* REGISTER MOBS ***************
    	
    	
    	
    	// ************* MAKE RENDERERS ***************
    	
    	
        
        //************* REGISTER ENTITIES ***************
    	
    	
        
        //************* REGISTER BIOMES ***************
    	Codakid.registerBiome(Main.myBiome);
    	
    }

    public void init(FMLInitializationEvent e) {
        
        //************* REGISTER WORLD GEN ***************


        
    	//************* SMELTING RECIPES ***************
    	
    	
    	
    	//************* BIOME SETUP ***************
    	BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(Main.myBiome, 1024));
    	BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(Main.myBiome, 1024));
    	BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Main.myBiome, 1024));
    	BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(Main.myBiome, 1024));
    	BiomeManager.addSpawnBiome(Main.myBiome);
    	
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
