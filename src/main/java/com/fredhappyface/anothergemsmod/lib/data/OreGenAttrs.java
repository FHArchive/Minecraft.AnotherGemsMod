package com.fredhappyface.anothergemsmod.lib.data;

import net.minecraft.world.gen.placement.CountRangeConfig;

/**
 * @author FredHappyface
 * @date 2019/07/18
 *
 * Object holding data for world gen. Uses a harvest level, CountRangeConfig and a veinSize
 */
public class OreGenAttrs {
    private int harvestLevel;
    private CountRangeConfig countRangeConfig;
    private int veinSize;

    /**
     * Lazy constructor, use if you are happy with default ore clusters per chunk
     * @param harvestLevel pick level required to obtain tbe ore
     * @param veinSize number of ore in a vein
     */
    public OreGenAttrs(int harvestLevel, int veinSize){
        this(harvestLevel, new CountRangeConfig(15, 20,0, 15), veinSize);

    }

    /**
     *
     * @param harvestLevel pick level required to obtain tbe ore
     * @param countRangeConfig settings for the ore clusters in a chunk
     * @param veinSize number of ore in a vein
     */
    public OreGenAttrs(int harvestLevel, CountRangeConfig countRangeConfig, int veinSize){
        this.harvestLevel = harvestLevel;
        this.countRangeConfig = countRangeConfig;
        this.veinSize = veinSize;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public CountRangeConfig getCountRangeConfig() {
        return countRangeConfig;
    }

    public int getVeinSize() {
        return veinSize;
    }
}