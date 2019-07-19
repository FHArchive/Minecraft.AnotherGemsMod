package com.fredhappyface.anothergemsmod.registers;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.Main;
import com.fredhappyface.anothergemsmod.enumeration.ModGems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;


public class ModBlocks {

    // Example block with public access
    /*
    public static Block myblock;
     */

    public static void registerAll(RegistryEvent.Register<Block> event){



        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) {
            return;
        }

        // Namespaces
        String DECORATIONS  = "decorations/";


        // Example block registration
        /*
        myblock = register("myblock", new Block(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5F, 6.0F)
                .sound(SoundType.STONE)));
         */

        // Storage Blocks
        for (ModGems gem : ModGems.values()) {
            register("storage_block/" + gem.getName() + "_block", gem.getStorageBlock());
        }
        // Ores
        for (ModGems gem : ModGems.values()) {
            register("ore/" +gem.getName() + "_ore", gem.getOreBlock());
        }
        // Decoration Blocks, Slabs, Stairs
        for (ModGems gem : ModGems.values()) {
            register(DECORATIONS + gem.getName() + "_bricks", gem.getBricks(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + gem.getName() + "_brick_slab", gem.getBrickSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + gem.getName() + "_brick_stairs", gem.getBrickStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + gem.getName() + "_slab", gem.getSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + gem.getName() + "_stairs", gem.getStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);

        }

    }

    /**
     * Lazy block registration. Item to put in creative tab automatically generated with tag ITEM_GROUP_RESOURCES
     * @param name name of the block (unlocalized)
     * @param block the block object
     * @return block
     */
    private static <T extends Block> T register(String name, T block){
        return register(name, block, new BlockItem(block, new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_RESOURCES)));
    }

    private static <T extends Block> T register(String name, T block, ItemGroup itemGroup){
        return register(name, block, new BlockItem(block, new Item.Properties().group(itemGroup)));
    }

    /**
     * Long hand block registration. Can specify a different creative tab or hide from creative mode by passing null
     * @param name name of the block (unlocalized)
     * @param block the block object
     * @param item the item to add to the creative tab
     * @return block
     */
    private static <T extends Block> T register(String name, T block, @Nullable BlockItem item ){
        ResourceLocation id = Main.getId(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null){
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
            return block;
        }
        return block;
    }


}
