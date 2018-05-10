/*******************************************************************************
 * Copyright 2014-2016, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.api.generation;

import biomesoplenty.api.config.IConfigObj;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public interface IGenerator {
    void scatter(World world, Random random, BlockPos pos);

    boolean generate(World world, Random random, BlockPos pos);

    /**
     * A unique name used to classify the purpose of a generator. For example, emeralds and ruby use the
     * same generator (and thus, have the same identifier) but have differing names.
     */
    String getName();

    void setName(String name);

    /**
     * The identifier for this generator should be consistent across all instances of the same type
     */
    String getIdentifier();

    GeneratorStage getStage();

    void setStage(GeneratorStage stage);

    void configure(IConfigObj conf);

    interface IGeneratorBuilder<T extends IGenerator> {
        T create();
    }
}
