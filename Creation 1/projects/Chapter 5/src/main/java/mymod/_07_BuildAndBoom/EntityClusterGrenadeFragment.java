package mymod._07_BuildAndBoom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityClusterGrenadeFragment extends EntityThrowable {

	public EntityClusterGrenadeFragment(World worldIn, double x, double y, double z, double motX, double motY,
			double motZ) {
		super(worldIn, x, y, z);
		this.setVelocity(motX, motY, motZ);
	}

	public EntityClusterGrenadeFragment(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote) {
			this.setDead();
		}
	}

}
