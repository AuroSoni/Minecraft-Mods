package mymod.CodakidFiles;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraftforge.fml.relauncher.SideOnly;
import mymod.Main;
import mymod._01_ForgeYourSword.CustomMonster;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMonsterPig extends RenderLiving {

	private static final ResourceLocation pigTexture = new ResourceLocation(
			Main.MODID, "mobs/pig_texture.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderMonsterPig(RenderManager renderManager) {
		super(renderManager, new BossModelPig(), 0.5f);
	}
	

	public void func_177_a(CustomMonster entity, double d, double d1, double d2,
			float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
			double d2, float f, float f1) {
		func_177_a((CustomMonster) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		func_177_a((CustomMonster) entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation func_110872_a(CustomMonster par1Entity) {
		return pigTexture;
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return func_110872_a((CustomMonster) var1);
	}
	
	public static class Factory implements IRenderFactory<CustomMonster> {

        @Override
        public Render<? super CustomMonster> createRenderFor(RenderManager manager) {
            return new RenderMonsterPig(manager);
        }

    }
	
}