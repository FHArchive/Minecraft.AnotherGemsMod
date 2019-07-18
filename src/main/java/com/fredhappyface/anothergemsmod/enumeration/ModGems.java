package com.fredhappyface.anothergemsmod.enumeration;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.lib.blocks.OreBlock;
import com.fredhappyface.anothergemsmod.lib.data.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
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
            new ToolAttrs(6,6f, 4, 2000,15f, 4f, 22),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)), // hexagonal diamond (12)
    ZIRCONIA(new OreGenAttrs(3,4),
            new ToolAttrs(5,5f,3,1000,10f,3f,15),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)), // 8.5
    AQUAMARINE(new OreGenAttrs(3,6),
            new ToolAttrs(4,4f,3,700,7f,2.5f,10),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)), // 8
    GALAXITE(new OreGenAttrs(2,8),
            new ToolAttrs(4,3f,2,400,5f,2f,8),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)), // 8
    ZIRCON(new OreGenAttrs(2,11),
            new ToolAttrs(3,3f,2,100,3f,1.5f,4),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)); // 7

    // Attrs
    private OreGenAttrs oreGenAttrs;
    private ToolAttrs toolAttrs;
    private ArmorAttrs armorAttrs;


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

    // Armour
    private final LazyLoadBase<ArmorItem> helm;
    private final LazyLoadBase<ArmorItem> chest;
    private final LazyLoadBase<ArmorItem> leggings;
    private final LazyLoadBase<ArmorItem> boots;



    ModGems(OreGenAttrs oreGenAttrs, ToolAttrs toolAttrs, ArmorAttrs armorAttrs) {
        // Attrs
        this.oreGenAttrs = oreGenAttrs;
        this.toolAttrs = toolAttrs;
        this.armorAttrs = armorAttrs;


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
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getSwordAttackDamageIn(), getToolAttrs().getSwordAttackSpeedIn(), getToolAttrs().getItemProperties()));
        shovel  = new LazyLoadBase<>(() -> new ShovelItem(new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), () -> {
            return Ingredient.fromItems(getGemItem());}), getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));


        // Armour (enchantability is from tool attributes)
        helm = new LazyLoadBase<>(() -> new ArmorItem(new ModArmorMaterial(getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), () -> {
            return Ingredient.fromItems(getGemItem());}), EquipmentSlotType.HEAD, getArmorAttrs().getItemProperties()));
        chest = new LazyLoadBase<>(() -> new ArmorItem(new ModArmorMaterial(getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), () -> {
                  return Ingredient.fromItems(getGemItem());}), EquipmentSlotType.CHEST, getArmorAttrs().getItemProperties()));
        leggings = new LazyLoadBase<>(() -> new ArmorItem(new ModArmorMaterial(getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), () -> {
            return Ingredient.fromItems(getGemItem());}), EquipmentSlotType.LEGS, getArmorAttrs().getItemProperties()));
        boots = new LazyLoadBase<>(() -> new ArmorItem(new ModArmorMaterial(getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), () -> {
            return Ingredient.fromItems(getGemItem());}), EquipmentSlotType.FEET, getArmorAttrs().getItemProperties()));


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

    public ArmorAttrs getArmorAttrs(){
        return armorAttrs;
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

    // Armour

    public ArmorItem getHelm(){
        return helm.getValue();
    }
    public ArmorItem getChest(){
        return chest.getValue();
    }
    public ArmorItem getLeggings(){
        return leggings.getValue();
    }
    public ArmorItem getBoots(){
        return boots.getValue();
    }



}
