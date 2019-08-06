package com.fredhappyface.anothergemsmod.enumeration;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.Main;
import com.fredhappyface.anothergemsmod.lib.blocks.*;
import com.fredhappyface.anothergemsmod.lib.data.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;
import java.util.function.Supplier;

@SuppressWarnings({"ClassWithTooManyFields", "ClassWithTooManyMethods"})
public enum ModGems {
    /*
    Create different types of blocks and items from data. eg, gems, ores, storage blocks, tools...
    Hardcode values
    Item_base_name: OreGenAttrs, ToolAttrs
     */
    LONSDALEITE(new OreGenAttrs(4,2),
            new ToolAttrs(6,6.0f, 4, 2000,15.0f, 4.0f, 22),
            new ArmorAttrs(36, new int[]{4, 7, 9, 4},  2.0F)), // hexagonal diamond (12)
    ZIRCONIA(new OreGenAttrs(3,4),
            new ToolAttrs(5,5.0f,3,1000,10.0f,3.0f,15),
            new ArmorAttrs(28, new int[]{3, 6, 8, 3},  1.5F)), // 8.5
    AQUAMARINE(new OreGenAttrs(3,6),
            new ToolAttrs(4,4.0f,3,700,7.0f,2.5f,10),
            new ArmorAttrs(23, new int[]{2, 6, 7, 3},  1.0F)), // 8
    GALAXITE(new OreGenAttrs(2,8),
            new ToolAttrs(4,3.0f,2,400,5.0f,2.0f,8),
            new ArmorAttrs(19, new int[]{2, 5, 7, 3},  0.5F)), // 8
    ZIRCON(new OreGenAttrs(2,11),
            new ToolAttrs(3,3.0f,2,100,3.0f,1.5f,4),
            new ArmorAttrs(15, new int[]{2, 5, 6, 2},  0.0F)); // 7

    // Attrs
    private final OreGenAttrs oreGenAttrs;
    private final ToolAttrs toolAttrs;
    private final ArmorAttrs armorAttrs;



    // Resources
    private final LazyLoadBase<ModOreBlock> oreBlock;
    private final LazyLoadBase<Item> gemItem;

    // Blocks
    private final LazyLoadBase<HopperBlock> hopperBlock;
    //private final LazyLoadBase<TileEntityType> hopper;

    private final LazyLoadBase<ModPaneBlock> bars;
    private final LazyLoadBase<ModDoorBlock> door;
    private final LazyLoadBase<RedstoneLampBlock> lamp;
    private final LazyLoadBase<InvertedRedstoneLampBlock> lampInverted;


    private final LazyLoadBase<Block> storageBlock;
    private final LazyLoadBase<Block> bricks;
    private final LazyLoadBase<SlabBlock> slab;
    private final LazyLoadBase<StairsBlock> stairs;
    private final LazyLoadBase<SlabBlock> brickSlab;
    private final LazyLoadBase<StairsBlock> brickStairs;
    //private final LazyLoadBase<StairsBlock> brickWall;

    // Tools

    private final LazyLoadBase<ShearsItem> shears;

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



    ModGems(final OreGenAttrs oreGenAttrs, final ToolAttrs toolAttrs, final ArmorAttrs armorAttrs) {
        // Attrs
        this.oreGenAttrs = oreGenAttrs;
        this.toolAttrs = toolAttrs;
        this.armorAttrs = armorAttrs;


        // Resources
        oreBlock = new LazyLoadBase<>(() -> new ModOreBlock(oreGenAttrs.getHarvestLevel()));
        gemItem = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_RESOURCES)));

        // Blocks

        final Block.Properties gemBlockProperties = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL);

        hopperBlock = new LazyLoadBase<>(() -> new HopperBlock(gemBlockProperties));
        //hopper = new LazyLoadBase<TileEntityType.Builder>(() -> new ModTileEntity.Builder(HopperTileEntity::new, getHopperBlock()).build(null));

        bars = new LazyLoadBase<>(() -> new ModPaneBlock(gemBlockProperties));
        door = new LazyLoadBase<>(() -> new ModDoorBlock(gemBlockProperties));

        final  Block.Properties gemLightProperties = Block.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(0.3f, 15).lightValue(15);

        lamp = new LazyLoadBase<>(() -> new RedstoneLampBlock(gemLightProperties));
        lampInverted = new LazyLoadBase<>(() -> new InvertedRedstoneLampBlock(gemLightProperties));


        storageBlock = new LazyLoadBase<>(() -> new Block(gemBlockProperties));
        bricks = new LazyLoadBase<>(() -> new Block(gemBlockProperties));
        slab = new LazyLoadBase<>(() -> new SlabBlock(gemBlockProperties));
        stairs = new LazyLoadBase<>(() -> new ModStairsBlock(getStorageBlock().getDefaultState(),gemBlockProperties));
        brickSlab = new LazyLoadBase<>(() -> new SlabBlock(gemBlockProperties));
        brickStairs = new LazyLoadBase<>(() -> new ModStairsBlock(getStorageBlock().getDefaultState(),gemBlockProperties));
        //brickWall = new LazyLoadBase<>(() -> new WallBlock(gemBlockProperties));


        // Tools

        final Supplier<Ingredient> gemIngredient =  () -> { return Ingredient.fromItems(getGemItem());};

        final ModItemTier itemTier = new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), gemIngredient);


        shears = new LazyLoadBase<>(() -> new ShearsItem(getToolAttrs().getItemProperties()));

        pickaxe = new LazyLoadBase<>(() -> new PickaxeItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        axe = new LazyLoadBase<>(() -> new AxeItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        hoe = new LazyLoadBase<>(() -> new HoeItem(itemTier, getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        sword  = new LazyLoadBase<>(() -> new SwordItem(itemTier, getToolAttrs().getSwordAttackDamageIn(), getToolAttrs().getSwordAttackSpeedIn(), getToolAttrs().getItemProperties()));
        shovel  = new LazyLoadBase<>(() -> new ShovelItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));


        // Armour (enchantability is from tool attributes)

        final ModArmorMaterial armorMaterial = new ModArmorMaterial(Main.MOD_ID + ":" + getName(),getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), gemIngredient);

        helm = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.HEAD, getArmorAttrs().getItemProperties()));
        chest = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.CHEST, getArmorAttrs().getItemProperties()));
        leggings = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.LEGS, getArmorAttrs().getItemProperties()));
        boots = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.FEET, getArmorAttrs().getItemProperties()));

        

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
    public ModOreBlock getOreBlock() {
        return oreBlock.getValue();
    }
    public Item getGemItem() {
        return gemItem.getValue();
    }


    // Blocks

    public HopperBlock getHopperBlock(){return hopperBlock.getValue();}
    //public TileEntityType getHopper(){return hopper.getValue();}

    public ModPaneBlock getBars(){return bars.getValue();}
    public ModDoorBlock getDoor(){return door.getValue();}
    public RedstoneLampBlock getLamp(){return lamp.getValue();}
    public InvertedRedstoneLampBlock getLampInverted(){return lampInverted.getValue();}

    public Block getStorageBlock() {
        return storageBlock.getValue();
    }
    public Block getBricks() {
        return bricks.getValue();
    }
    public SlabBlock getSlab() {
        return slab.getValue();
    }
    public StairsBlock getStairs() {
        return stairs.getValue();
    }
    public SlabBlock getBrickSlab() {
        return brickSlab.getValue();
    }
    public StairsBlock getBrickStairs() {
        return brickStairs.getValue();
    }

    // Tools

    public ShearsItem getShearsItem(){return  shears.getValue();}

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
