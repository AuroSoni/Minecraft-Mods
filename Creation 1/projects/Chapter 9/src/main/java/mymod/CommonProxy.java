package mymod;

import mymod.CodakidFiles.Codakid;
import mymod.CodakidFiles.RenderGrenadeBuild;
import mymod.CodakidFiles.RenderGrenadeBuild.FactoryBG;
import mymod.CodakidFiles.RenderGrenadeCluster;
import mymod.CodakidFiles.RenderGrenadeCluster.FactoryCG;
import mymod.CodakidFiles.RenderGrenadeClusterFragment;
import mymod.CodakidFiles.RenderGrenadeClusterFragment.FactoryCGF;
import mymod.CodakidFiles.RenderGrenadeCustom;
import mymod.CodakidFiles.RenderGrenadeCustom.FactoryG;
import mymod._07_BuildAndBoom.ClusterGrenade;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenadeFragment;
import mymod._07_BuildAndBoom.EntityGrenade;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
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
	    Codakid.registerItem(Main.myGrenade, "my_grenade");
    	Codakid.registerItem(Main.clusterGrenade, "my_cluster_grenade");
    	Codakid.registerItem(Main.myBuildGrenade, "my_build_grenade");
    	
    	//************* REGISTER MOBS ***************
    	
    	
    	
    	// ************* MAKE RENDERERS ***************
    	FactoryG renderGrenade = (FactoryG) RenderGrenadeCustom.FACTORY;
    	renderGrenade.setGrenade(Main.myGrenade);
    	
    	FactoryCG renderClusterGrenade = (FactoryCG) RenderGrenadeCluster.FACTORY;
    	renderClusterGrenade.setGrenade(Main.clusterGrenade);
    	
    	FactoryCGF renderClusterGrenadeFragment = (FactoryCGF) RenderGrenadeClusterFragment.FACTORY;
    	renderClusterGrenadeFragment.setGrenade(Main.clusterGrenade);
    	
    	FactoryBG renderBuildGrenade = (FactoryBG) RenderGrenadeBuild.FACTORY;
    	renderBuildGrenade.setGrenade(Main.myBuildGrenade);
    	
        
        //************* REGISTER ENTITIES ***************
    	Codakid.registerEntity(EntityGrenade.class, "my_grenade", renderGrenade);
    	Codakid.registerEntity(EntityClusterGrenade.class, "my_cluster_grenade", renderClusterGrenade);
    	Codakid.registerEntity(EntityClusterGrenadeFragment.class, "my_cluster_grenade", renderClusterGrenadeFragment);
    	Codakid.registerEntity(EntityBuildGrenade.class, "my_build_grenade", renderBuildGrenade);
    	
        
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
