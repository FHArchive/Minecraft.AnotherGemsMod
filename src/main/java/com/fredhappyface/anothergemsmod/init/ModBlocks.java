package com.fredhappyface.anothergemsmod.init;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import com.fredhappyface.anothergemsmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;


public class ModBlocks {

    public static Block myblock;

    public static void registerAll(RegistryEvent.Register<Block> event){



        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) {
            return;
        }



        myblock = register("myblock", new Block(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5F, 6.0F)
                .sound(SoundType.STONE)));

        for (ModGems gem : ModGems.values()) {
            // Names will be: ruby_block, sapphire_block
            // This comment is, of course, not necessary, so you can remove it
            register(gem.getName() + "_block", gem.getStorageBlock());
        }

        for (ModGems gem : ModGems.values()) {
            // ruby_ore, sapphire_ore
            register(gem.getName() + "_ore", gem.getOreBlock());
        }

    }

    private static <T extends Block> T register(String name, T block){
        return register(name, block, new BlockItem(block, new Item.Properties().group(CreativeTabGroups.ITEM_GROUP)));
    }

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
