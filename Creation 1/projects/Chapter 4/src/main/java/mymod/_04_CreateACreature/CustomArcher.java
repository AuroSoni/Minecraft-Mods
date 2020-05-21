package mymod._04_CreateACreature;

import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class CustomArcher extends AbstractSkeleton{

	public CustomArcher(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected SoundEvent getStepSound() {
		// TODO Auto-generated method stub
		return null;
	}

}
