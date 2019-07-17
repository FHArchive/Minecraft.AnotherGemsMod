package com.fredhappyface.anothergemsmod.init;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.blocks.OreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModGems {
    LONSDALEITE(4), // hexagonal diamond (12)
    ZIRCONIA(3), // 8.5
    AQUAMARINE(3), // 8
    GALAXITE(2), // 8
    ZIRCON(2); // 7

    //private int harvestLevel;

    private final LazyLoadBase<OreBlock> oreBlock;
    private final LazyLoadBase<Block> storageBlock;
    private final LazyLoadBase<Item> gemItem;

    ModGems(int harvestLevel) {
        // Note that this::getGemItem is a method reference. The gem item should not be created
        // until later. Conveniently, the method signature matches IItemProvider.
        oreBlock = new LazyLoadBase<>(() -> new OreBlock(harvestLevel));
        storageBlock = new LazyLoadBase<>(() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL)));
        gemItem = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(CreativeTabGroups.ITEM_GROUP)));
    }


    public String getName() {
        // Locale.ROOT will ensure consistent behavior (prevent crashes) on all locales
        return name().toLowerCase(Locale.ROOT);
    }


    public OreBlock getOreBlock() {
        return oreBlock.getValue();
    }


    public Block getStorageBlock() {
        return storageBlock.getValue();
    }


    public Item getGemItem() {
        return gemItem.getValue();
    }
}
