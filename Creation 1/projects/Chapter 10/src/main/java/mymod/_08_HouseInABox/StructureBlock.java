package mymod._08_HouseInABox;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureBlock extends Block{
	
	
	IBlockState G = Blocks.GOLD_BLOCK.getDefaultState();
	IBlockState I = Blocks.IRON_BLOCK.getDefaultState();
	IBlockState C = Blocks.CHEST.getDefaultState();
	IBlockState A = Blocks.AIR.getDefaultState();
	IBlockState n = null;
	
	static ArrayList<IBlockState> structureX=new ArrayList<>();
	static ArrayList<ArrayList<IBlockState>> structureXZ = new ArrayList<>();
	static ArrayList<ArrayList<ArrayList<IBlockState>>> structureXYZ = new ArrayList<>();
	
	
	public StructureBlock(){
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		//layer 1
		addX(G,G,G,G,G,G,G,G,G,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,G,G,G,G,G,G,G,G,G);
		nextLayer();
		//layer 2
		addX(G,G,G,G,G,G,G,G,G,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,G,G,G,G,G,G,G,G,G);
		nextLayer();
		//layer 3
		addX(G,G,G,G,G,G,G,G,G,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,G,G,G,G,G,G,G,G,G);
		nextLayer();
		//layer 4
		addX(G,G,G,G,G,G,G,G,G,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,A,A,A,A,A,A,A,A,G);
		addX(G,G,G,G,G,G,G,G,G,G);
		nextLayer();
		//layer 5
		addX(G,G,G,G,G,G,G,G,G,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,I,I,I,I,I,I,I,I,G);
		addX(G,G,G,G,G,G,G,G,G,G);
		nextLayer();
		
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		int l=0;
		int r=0;
		int c=0;
		for (ArrayList<ArrayList<IBlockState>> xz : structureXYZ) {
			r=0;
			for (ArrayList<IBlockState> x : xz) {
				c=0;
				for (IBlockState blockState : x) {
					if(blockState==null){
						continue;
					}
					worldIn.setBlockState(pos.add(c, l, r), blockState);
					c++;
				}
				r++;
			}
			l++;
		}
		worldIn.setBlockState(pos, G);
		super.onBlockAdded(worldIn, pos, state);
	}
	
	void addX(IBlockState ...states){
		
		structureX = new ArrayList<>();
		
		for (IBlockState iBlockState : states) {
			structureX.add(iBlockState);
		}
		addXZ(structureX);
	}
	
	void addXZ(ArrayList<IBlockState> xList){
		structureXZ.add(xList);
	}
	
	void addXYZ(ArrayList<ArrayList<IBlockState>> xyList){
		structureXYZ.add(xyList);
	}
	
	void nextLayer(){
		addXYZ(structureXZ);
		structureXZ = new ArrayList<>();
	}
}
