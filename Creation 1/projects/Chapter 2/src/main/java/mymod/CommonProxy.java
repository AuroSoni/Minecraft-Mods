package mymod;

import mymod.CodakidFiles.Codakid;
import mymod.CodakidFiles.RenderMonsterPig;
import mymod.CodakidFiles.RenderMonsterWolf;
import mymod._01_ForgeYourSword.CustomMonster;
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
	    Codakid.registerItem(Main.mySword, "my_sword");
    	
    	
    	//************* REGISTER MOBS ***************
    	Codakid.registerMobEntity(CustomMonster.class, "my_monster", RenderMonsterPig.FACTORY, Color.BLACK.getRGB(), 0xd195f9);
    	
    	EntityRegistry.addSpawn(CustomMonster.class, 100, 5, 100, EnumCreatureType.CREATURE, Biomes.PLAINS,Biomes.DESERT,Biomes.BEACH);
    	
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
