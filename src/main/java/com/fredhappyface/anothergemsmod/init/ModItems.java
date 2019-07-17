package com.fredhappyface.anothergemsmod.init;

import com.fredhappyface.anothergemsmod.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {


    static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();


    public static void registerAll(RegistryEvent.Register<Item> event){

        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) {
            return;
        }


        // Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);


        // Items
        for (ModGems gem : ModGems.values()) {
            register(gem.getName(), gem.getGemItem());
        }

    }

    private static <T extends Item> T register(String name, T item){
        ResourceLocation id = Main.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;

    }

}