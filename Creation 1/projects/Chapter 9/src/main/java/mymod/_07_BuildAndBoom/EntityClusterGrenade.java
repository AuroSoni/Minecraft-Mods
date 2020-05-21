package mymod._07_BuildAndBoom;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityClusterGrenade extends EntityThrowable {

	public EntityClusterGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityClusterGrenade(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			Random rand = new Random();
			if(result.entityHit ==null){
				int number=0;
				while(number<100){
					world.spawnEntity(new EntityClusterGrenadeFragment(world, this.posX, this.posY, this.posZ, 
							rand.nextFloat()-0.5,this.motionY*-1,rand.nextFloat()-0.5));
					number++;
				}
			}
			else{
				int number=0;
				while(number<10){
					world.spawnEntity(new EntityClusterGrenadeFragment(world, this.posX, this.posY, this.posZ, 
							rand.nextFloat()-0.5,this.motionY*-1,rand.nextFloat()-0.5));
					number++;
				}
			}
			this.setDead();
		}
	}

}
