/*************************************************************
 ****************CODAKID MINECRAFT MODDING********************
 *************************************************************/

package mymod;

import org.apache.logging.log4j.Logger;

import mymod.CodakidFiles.Codakid;
import mymod._03_MagicArmor.CustomArmor;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, useMetadata = true)
public class Main {

    public static final String MODID = "foundations";
    public static final String MODNAME = "Chapter 6";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "mymod.CodakidFiles.ClientProxy", serverSide = "mymod.CodakidFiles.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance
    public static Main instance;
    public static Logger logger;
    
    //************* DECLARE VARIABLES ***************
    public static CustomArmor myHelmet;
    public static CustomArmor myChestplate;
    public static CustomArmor myLeggings;
    public static CustomArmor myBoots;    
    public static ArmorMaterial knightArmorMaterial;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	
    	//************* INITIALIZE MATERIALS ***************
    	knightArmorMaterial= EnumHelper.addArmorMaterial("knight_armor", MODID+":my_armor", 500, new int[]{6,10,6,6}, 30, SoundEvents.ENTITY_ILLAGER_MIRROR_MOVE, 100);
    	
    	
    	//************* INITIALIZE VARIABLES ***************
    	myHelmet = new CustomArmor(Main.knightArmorMaterial, 1, EntityEquipmentSlot.HEAD);
    	myChestplate= new CustomArmor(Main.knightArmorMaterial, 1, EntityEquipmentSlot.CHEST);
    	myLeggings= new CustomArmor(Main.knightArmorMaterial, 2, EntityEquipmentSlot.LEGS);
    	myBoots= new CustomArmor(Main.knightArmorMaterial, 1, EntityEquipmentSlot.FEET);    	
    	
    	
        proxy.preInit(event);
    }
    

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	Codakid.initModels();
    }

}