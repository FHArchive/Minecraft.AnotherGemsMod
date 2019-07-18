package com.fredhappyface.anothergemsmod.enumeration;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.lib.blocks.OreBlock;
import com.fredhappyface.anothergemsmod.lib.data.ModItemTier;
import com.fredhappyface.anothergemsmod.lib.data.OreGenAttrs;
import com.fredhappyface.anothergemsmod.lib.data.ToolAttrs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModGems {
    /*
    Create different types of blocks and items from data. eg, gems, ore, storage blocks, tools...
    Hardcode values
    Item_base_name: OreGenAttrs, ToolAttrs
     */
    LONSDALEITE(new OreGenAttrs(4,2),
            new ToolAttrs(6,6f, 4, 2000,15f, 4f, 22)), // hexagonal diamond (12)
    ZIRCONIA(new OreGenAttrs(3,4),
            new ToolAttrs(5,5f,3,1000,10f,3f,15)), // 8.5
    AQUAMARINE(new OreGenAttrs(3,6),
            new ToolAttrs(4,4f,3,700,7f,2.5f,10)), // 8
    GALAXITE(new OreGenAttrs(2,8),
            new ToolAttrs(4,3f,2,400,5f,2f,8)), // 8
    ZIRCON(new OreGenAttrs(2,11),
            new ToolAttrs(3,3f,2,100,3f,1.5f,4)); // 7

    // Attrs
    private OreGenAttrs oreGenAttrs;
    private ToolAttrs toolAttrs;


    // Resources
    private final LazyLoadBase<OreBlock> oreBlock;
    private final LazyLoadBase<Item> gemItem;

    // Blocks
    private final LazyLoadBase<Block> storageBlock;

    // Tools
    private final LazyLoadBase<PickaxeItem> pickaxe;
    private final LazyLoadBase<AxeItem> axe;
    private final LazyLoadBase<ShovelItem> shovel;
    private final LazyLoadBase<SwordItem> sword;
    private final LazyLoadBase<HoeItem> hoe;



    ModGems(OreGenAttrs oreGenAttrs, ToolAttrs toolAttrs) {
        // Attrs
        this.oreGenAttrs = oreGenAttrs;
        this.toolAttrs = toolAttrs;


        // Resources
        oreBlock = new LazyLoadBase<>(() -> new OreBlock(oreGenAttrs.getHarvestLevel()));
        gemItem = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_RESOURCES)));


        // Blocks
        storageBlock = new LazyLoadBase<>(() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).sound(SoundType.METAL)));


        // Tools
        pickaxe = new LazyLoadBase<>(() -> new PickaxeItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        axe = new LazyLoadBase<>(() -> new AxeItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        hoe = new LazyLoadBase<>(() -> new HoeItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        sword  = new LazyLoadBase<>(() -> new SwordItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        shovel  = new LazyLoadBase<>(() -> new ShovelItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));

    }


    // Attrs
    public String getName() {
        // Locale.ROOT will ensure consistent behavior (prevent crashes) on all locales
        return name().toLowerCase(Locale.ROOT);
    }
    public OreGenAttrs getOreGenAttrs() {
        return oreGenAttrs;
    }
    public ToolAttrs getToolAttrs() {
        return toolAttrs;
    }


    // Resources
    public OreBlock getOreBlock() {
        return oreBlock.getValue();
    }
    public Item getGemItem() {
        return gemItem.getValue();
    }


    // Blocks
    public Block getStorageBlock() {
        return storageBlock.getValue();
    }


    // Tools
    public PickaxeItem getPickaxeItem(){
        return  pickaxe.getValue();
    }
    public AxeItem getAxeItem(){
        return  axe.getValue();
    }
    public HoeItem getHoeItem(){
        return  hoe.getValue();
    }
    public ShovelItem getShovelItem(){
        return  shovel.getValue();
    }
    public SwordItem getSwordItem(){
        return  sword.getValue();
    }



}
