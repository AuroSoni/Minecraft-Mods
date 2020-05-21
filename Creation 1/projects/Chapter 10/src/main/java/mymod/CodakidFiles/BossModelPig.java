package mymod.CodakidFiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BossModelPig extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
  
  public BossModelPig()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -8F, 8, 8, 8);
      head.setRotationPoint(0F, 12F, -6F);
      head.setTextureSize(128, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 33, 0);
      body.addBox(-5F, -10F, -7F, 10, 16, 8);
      body.setRotationPoint(0F, 11F, 3F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 70, 11);
      leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-3F, 18F, 7F);
      leg1.setTextureSize(128, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 87, 11);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(3F, 18F, 7F);
      leg2.setTextureSize(128, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 70, 0);
      leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-3F, 18F, -5F);
      leg3.setTextureSize(128, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 87, 0);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(3F, 18F, -5F);
      leg4.setTextureSize(128, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity	);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.leg1.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1 * -1;
    this.leg2.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1;
    this.leg3.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1;
    this.leg4.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1 * -1;
    
    this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f5 / (180F / (float)Math.PI);
  }

}
