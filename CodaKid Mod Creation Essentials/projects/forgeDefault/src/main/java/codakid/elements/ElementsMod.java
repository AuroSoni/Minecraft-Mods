package codakid.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.Console;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

@Mod(modid = ElementsMod.MODID, name = ElementsMod.NAME, version = ElementsMod.VERSION)
public class ElementsMod
{
    public static final String MODID = "elements";
    public static final String NAME = "Elements Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;
    public static ToolMaterial tM;
    
    //Declare your variables
    


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        tM = EnumHelper.addToolMaterial("Codakid", 20,2000, 200, 200, 255);
        
        //Instantiate your objects here
        
        //Register your objects in Minecraft
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Register the textures
    	
    }
}
