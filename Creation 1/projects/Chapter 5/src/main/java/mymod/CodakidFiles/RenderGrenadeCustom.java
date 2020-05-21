package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityGrenade;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
@SideOnly(Side.CLIENT)
public class RenderGrenadeCustom extends Render<EntityGrenade>
{   
	private static final ResourceLocation grenadeTexture = new ResourceLocation(
			Main.MODID, "items/my_grenade.png");
	
	public static final IRenderFactory FACTORY = new FactoryG();
	   
	public static ItemStack grenadeStack = ItemStack.EMPTY;
    
	public RenderGrenadeCustom(RenderManager renderManager)
    {
        super(renderManager);
    }

    @Override
    public void doRender(EntityGrenade entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(entity);
 
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
 
        Minecraft.getMinecraft().getRenderItem().renderItem(grenadeStack, ItemCameraTransforms.TransformType.GROUND);
 
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
 
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGrenade entity) {
		return grenadeTexture; 
	}
	
	public static class FactoryG implements IRenderFactory<EntityGrenade> {
		
		public void setGrenade(Item grenade) {
			grenadeStack = new ItemStack(grenade);
		}
		
        @Override
        public Render<? super EntityGrenade> createRenderFor(RenderManager manager) {
            return new RenderGrenadeCustom(manager);
        }

    }
}
