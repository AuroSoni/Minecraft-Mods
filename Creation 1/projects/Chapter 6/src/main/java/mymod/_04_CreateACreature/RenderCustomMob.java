package mymod._04_CreateACreature;

import mymod.Main;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCustomMob extends RenderLiving {

	private static final ResourceLocation mobTexture = new ResourceLocation(
			Main.MODID, "mobs/TEXTURE_NAME_HERE.png");
	
	public static final Factory FACTORY = new Factory();

	public RenderCustomMob(RenderManager renderManager) {
		// erase null and add your model
		super(renderManager, null, 0.5f);
	}

	public void func_177_a(EntityLiving entity, double d, double d1, double d2,
			float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a(entityliving, d, d1, d2, f, f1);
	}

	public void doRender(EntityLiving entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a(entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation func_110872_a(EntityLiving par1Entity) {
		return mobTexture;
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return func_110872_a((EntityLiving)var1);
	}
	
	public static class Factory implements IRenderFactory<CustomMob> {

        @Override
        public Render<? super CustomMob> createRenderFor(RenderManager manager) {
            return new RenderCustomMob(manager);
        }

    }
}
