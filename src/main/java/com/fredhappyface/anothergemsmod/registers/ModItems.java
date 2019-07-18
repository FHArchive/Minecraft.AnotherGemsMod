package com.fredhappyface.anothergemsmod.registers;

import com.fredhappyface.anothergemsmod.Main;
import com.fredhappyface.anothergemsmod.enumeration.ModGems;
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

        if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName())) {
            return;
        }


        // Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);


        // Items
        // Gems
        for (ModGems gem : ModGems.values()) {
            register(gem.getName(), gem.getGemItem());
        }

        // Tools
        for (ModGems gem : ModGems.values()) {
            register(gem.getName()+ "_pickaxe", gem.getPickaxeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(gem.getName()+ "_axe", gem.getAxeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(gem.getName()+ "_hoe", gem.getHoeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(gem.getName()+ "_shovel", gem.getShovelItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(gem.getName()+ "_sword", gem.getSwordItem());
        }

    }

    /**
     * Register an item to the creative mode tab and to the game
     * @param name name of the item (unlocalized)
     * @param item the item object
     * @return
     */
    private static <T extends Item> T register(String name, T item){
        ResourceLocation id = Main.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;

    }

}