package com.fredhappyface.anothergemsmod.lib.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;

public class InvertedRedstoneLampBlock extends RedstoneLampBlock {
    /**
     * Creates an inverted light block like has been present in various mods over the
     * ages. Example usage:
     * final  Block.Properties gemLightProperties = Block.Properties.create(Material.REDSTONE_LIGHT)
     * .hardnessAndResistance(0.3f, 15).lightValue(15);
     * @param blockProperties pass a set of properties into the block such as the desired
     *                        light level
     */
    public InvertedRedstoneLampBlock(final Properties blockProperties) {
        super(blockProperties);
    }

    @Override
    /*
     * getlightValue doesn't seem to be behaving so i am returning 15 as a hard coded
     * value. This is sufficient for this mod but doesn't make this the best if you
     * wish to set a different value in the blockProperties
     */
    public int getLightValue(final BlockState p_149750_1_) {
        //return (Boolean)p_149750_1_.get(LIT) ? 0 : super.getLightValue(p_149750_1_);
        return p_149750_1_.get(LIT) ? 0 : 15;

    }
}
