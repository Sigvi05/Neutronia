package net.hdt.neutronia.world.gen;

import com.google.common.collect.Lists;
import net.hdt.neutronia.world.CoralFeature;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CoralTreeFeature extends CoralFeature
{
    public boolean generate(World p_204623_1_, Random p_204623_2_, BlockPos p_204623_3_)
    {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(p_204623_3_);
        int i = p_204623_2_.nextInt(3) + 1;

        for (int j = 0; j < i; ++j)
        {
            if (!this.generate(p_204623_1_, p_204623_2_, blockpos$mutableblockpos))
            {
                return true;
            }

            blockpos$mutableblockpos.move(EnumFacing.UP);
        }

        BlockPos blockpos = blockpos$mutableblockpos.toImmutable();
        int k = p_204623_2_.nextInt(3) + 2;
        List<EnumFacing> list = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL);
        Collections.shuffle(list, p_204623_2_);

        for (EnumFacing enumfacing : list.subList(0, k))
        {
            blockpos$mutableblockpos.setPos(blockpos);
            blockpos$mutableblockpos.move(enumfacing);
            int l = p_204623_2_.nextInt(5) + 2;
            int i1 = 0;

            for (int j1 = 0; j1 < l && this.generate(p_204623_1_, p_204623_2_, blockpos$mutableblockpos); ++j1)
            {
                ++i1;
                blockpos$mutableblockpos.move(EnumFacing.UP);

                if (j1 == 0 || i1 >= 2 && p_204623_2_.nextFloat() < 0.25F)
                {
                    blockpos$mutableblockpos.move(enumfacing);
                    i1 = 0;
                }
            }
        }

        return true;
    }
}
