package com.fredhappyface.anothergemsmod.lib.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class OreBlock extends net.minecraft.block.OreBlock {
    @Nullable
    private final int harvestLevel;


    /**
     * Define an OreBlock
     * @param harvestLevel
     */
    public OreBlock(int harvestLevel) {
        this(Properties.create(Material.ROCK).hardnessAndResistance(3, 3), harvestLevel);

    }

    public OreBlock(Properties builder, int harvestLevel) {
        super(builder);
        this.harvestLevel = harvestLevel;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 1, 5) : 0;
    }


    @Override
    public int getHarvestLevel(BlockState state) {
        return this.harvestLevel;
    }

    
}