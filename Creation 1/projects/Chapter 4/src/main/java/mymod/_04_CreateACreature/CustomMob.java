package mymod._04_CreateACreature;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class CustomMob extends EntityMob {
	
	public float moveSpeed;
	public float attackDamage;
	public float health;
	
	public static final ResourceLocation LOOT = new ResourceLocation(Main.MODID, "entities/my_mob");

	public CustomMob(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		
		this.moveSpeed = 0.5F;
		this.attackDamage = 2F;
		this.health = 10F;
		
		Codakid.setMovementSpeed(this, this.moveSpeed);
		Codakid.setAttackDamage(this, this.attackDamage);
		Codakid.setMaxHealth(this, this.health);
		
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 15));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1, false));
		
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, true));
		super.initEntityAI();
	}
	
	@Override
    protected ResourceLocation getLootTable() {
        return LOOT;
    }

}
