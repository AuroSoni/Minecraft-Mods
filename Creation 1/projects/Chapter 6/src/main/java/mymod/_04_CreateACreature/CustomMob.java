package mymod._04_CreateACreature;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
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
		
		this.moveSpeed = 0F;
		this.attackDamage = 0F;
		this.health = 0F;
		
		Codakid.setMovementSpeed(this, this.moveSpeed);
		Codakid.setAttackDamage(this, this.attackDamage);
		Codakid.setMaxHealth(this, this.health);
		
	}
	
	@Override
    protected ResourceLocation getLootTable() {
        return LOOT;
    }

}
