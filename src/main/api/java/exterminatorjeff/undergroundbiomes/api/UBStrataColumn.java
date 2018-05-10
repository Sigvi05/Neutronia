/*
 */

package exterminatorjeff.undergroundbiomes.api;

import net.minecraft.block.state.IBlockState;

/**
 * @author Zeno410
 */
public interface UBStrataColumn {
    IBlockState stone(int height);

    IBlockState cobblestone(int height);

    IBlockState stone();

    IBlockState cobblestone();

}