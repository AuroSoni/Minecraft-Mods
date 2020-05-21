package codakid.elements;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CK {

	public static void addItem(Item item) {
		GameRegistry.findRegistry(Item.class).register(item);
	}
	public static void addTexture(Item item) {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ElementsMod.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }
	
	public static EntityLargeFireball getFireball(World world, EntityPlayer player, int power){
		EntityLargeFireball fireball =new EntityLargeFireball(world,player.posX,player.posY+2,player.posZ, player.getLookVec().x,player.getLookVec().y,player.getLookVec().z);
		fireball.explosionPower = power;
		fireball.shootingEntity = player;
		fireball.rotationPitch = player.rotationPitch;
		fireball.rotationYaw = player.rotationYaw;
		return fireball;
	}
	
	public static List<Entity> getTargets(World world, EntityPlayer player, int range)
	{
	 	Vec3d playerPos = new Vec3d(player.posX,player.posY,player.posZ);
	 	Vec3d cubeSides = new Vec3d(range,range,range);
	 	Vec3d lower = playerPos.subtract(cubeSides);
	 	Vec3d higher = playerPos.add(cubeSides);
		return world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lower.x,lower.y,lower.z,higher.x,higher.y,higher.z));
	}
	
public static void sendOppositeDirection(World world,Entity enemy, EntityPlayer player,double multiplier) {
		
		Vec3d playerPos = new Vec3d(player.posX,player.posY,player.posZ);
		Vec3d enemyPos = new Vec3d(enemy.posX,enemy.posY,enemy.posZ);
		Vec3d pushVector = enemyPos.subtract(playerPos).normalize();
		enemy.motionX += pushVector.x *multiplier;
		enemy.motionY += pushVector.y *multiplier;
		enemy.motionZ += pushVector.z *multiplier;
		emitParticleBomb(world,player, 5);
		
		
	}
	public static void emitParticleBomb(World world, EntityPlayer player,int multi) {
		world.spawnAlwaysVisibleParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleID(), player.posX+player.getLookVec().x,player.posY+player.getEyeHeight(),player.posZ+player.getLookVec().z, 0,0,0,0);
		for(double i=.5; i< multi;i+=.5)
		{
			Vec3d particlePos = new Vec3d( player.posX-i, player.posY, player.posZ);
			randomParticleHelper(particlePos,world);
		}
		
		for(double i=.5; i< multi;i+=.5)
		{
			Vec3d particlePos = new Vec3d( player.posX+i, player.posY, player.posZ);
			randomParticleHelper(particlePos,world);
		}
		for(double i=.5; i< multi;i+=.5)
		{
			Vec3d particlePos = new Vec3d( player.posX, player.posY, player.posZ-i);
			randomParticleHelper(particlePos,world);
		}
		for(double i=.5; i< multi;i+=.5)
		{
			Vec3d particlePos = new Vec3d( player.posX-i, player.posY, player.posZ+i);
			randomParticleHelper(particlePos,world);
		}
		
		
	}
	private static void randomParticleHelper(Vec3d vector,World world)
	{
		double randomness = 7;
		Random rand = new Random();
		double randomX = -randomness+rand.nextDouble()*(randomness*2);
		double randomY = -randomness+rand.nextDouble()*(randomness*2);
		double randomZ = -randomness+rand.nextDouble()*(randomness*2);
		world.spawnParticle(EnumParticleTypes.CRIT_MAGIC,vector.x+randomX,vector.y+randomY,vector.z+randomZ, 0,0,0);
	}
}
