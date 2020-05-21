package mymod.CodakidFiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BossModelWolf extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer mane;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer tail;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer nose;
  
  public BossModelWolf()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 9);
      head.addBox(-3F, -3F, -2F, 6, 6, 4);
      head.setRotationPoint(-1F, 13.5F, -7F);
      head.setTextureSize(128, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 52, 0);
      body.addBox(-4F, -2F, -3F, 6, 9, 6);
      body.setRotationPoint(0F, 14F, 2F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      mane = new ModelRenderer(this, 21, 0);
      mane.addBox(-4F, -3F, -3F, 8, 6, 7);
      mane.setRotationPoint(-1F, 14F, -3F);
      mane.setTextureSize(128, 32);
      mane.mirror = true;
      setRotation(mane, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 80, 11);
      leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
      leg1.setRotationPoint(-2.5F, 16F, 7F);
      leg1.setTextureSize(128, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 89, 11);
      leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
      leg2.setRotationPoint(0.5F, 16F, 7F);
      leg2.setTextureSize(128, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 80, 0);
      leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
      leg3.setRotationPoint(-2.5F, 16F, -4F);
      leg3.setTextureSize(128, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 89, 0);
      leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
      leg4.setRotationPoint(0.5F, 16F, -4F);
      leg4.setTextureSize(128, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 101, 5);
      tail.addBox(-1F, 0F, -1F, 2, 8, 2);
      tail.setRotationPoint(-1F, 12F, 8F);
      tail.setTextureSize(128, 32);
      tail.mirror = true;
      setRotation(tail, 1.130069F, 0F, 0F);
      ear1 = new ModelRenderer(this, 2, 4);
      ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
      ear1.setRotationPoint(-1F, 13.5F, -7F);
      ear1.setTextureSize(128, 32);
      ear1.mirror = true;
      setRotation(ear1, 0F, 0F, 0F);
      ear2 = new ModelRenderer(this, 10, 4);
      ear2.addBox(1F, -5F, 0F, 2, 2, 1);
      ear2.setRotationPoint(-1F, 13.5F, -7F);
      ear2.setTextureSize(128, 32);
      ear2.mirror = true;
      setRotation(ear2, 0F, 0F, 0F);
      nose = new ModelRenderer(this, 2, 20);
      nose.addBox(-2F, 0F, -5F, 3, 3, 4);
      nose.setRotationPoint(-0.5F, 13.5F, -7F);
      nose.setTextureSize(128, 32);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    mane.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    tail.render(f5);
    ear1.render(f5);
    ear2.render(f5);
    nose.render(f5);
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
  }

}
