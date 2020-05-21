package mymod.CodakidFiles;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CKWorldGenerater extends WorldGenerator {
	
	public IBlockState blockToGenerate;
	public int tries;
	
	public CKWorldGenerater(IBlockState blockState, int spawnTries) {
		blockToGenerate = blockState;
		tries = spawnTries;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
        for (int i = 0; i < tries; i++)
        {
            int offset = net.minecraftforge.common.ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-114332
            BlockPos blockpos = pos.add(rand.nextInt(16) + offset, rand.nextInt(200) + 4, rand.nextInt(16) + offset);

            net.minecraft.block.state.IBlockState state = worldIn.getBlockState(blockpos);
            if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, net.minecraft.block.state.pattern.BlockMatcher.forBlock(Blocks.STONE)))
            {
                worldIn.setBlockState(blockpos, blockToGenerate, 16 | 2);
            }
        }
        return true;
	}

}
