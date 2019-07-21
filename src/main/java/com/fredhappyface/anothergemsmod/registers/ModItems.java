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


    @SuppressWarnings("CollectionWithoutInitialCapacity")
    static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();


    public static void registerAll(final RegistryEvent.Register<Item> event){

        if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName())) {
            return;
        }

        // Namespaces
        final String TOOLS  = "tools/";
        final String ARMOUR  = "armor/";


        // Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);


        // Items
        // Gems
        for (ModGems gem : ModGems.values()) {
            register(gem.getName(), gem.getGemItem());
        }

        // Tools
        for (ModGems gem : ModGems.values()) {
            register(TOOLS + gem.getName()+ "_pickaxe", gem.getPickaxeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(TOOLS + gem.getName()+ "_axe", gem.getAxeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(TOOLS + gem.getName()+ "_hoe", gem.getHoeItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(TOOLS + gem.getName()+ "_shovel", gem.getShovelItem());
        }
        for (ModGems gem : ModGems.values()) {
            register(TOOLS + gem.getName()+ "_sword", gem.getSwordItem());
        }

        // Armour
        for (ModGems gem : ModGems.values()) {
            register(ARMOUR + gem.getName() + "_helm", gem.getHelm());
        }
        for (ModGems gem : ModGems.values()) {
            register(ARMOUR + gem.getName() + "_chest", gem.getChest());
        }
        for (ModGems gem : ModGems.values()) {
            register(ARMOUR + gem.getName() + "_leggings", gem.getLeggings());
        }
        for (ModGems gem : ModGems.values()) {
            register(ARMOUR + gem.getName() + "_boots", gem.getBoots());
        }
    }



    /**
     * Register an item to the creative mode tab and to the game
     * @param name name of the item (unlocalized)
     * @param item the item object
     * @return item
     */
    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Item> T register(final String name, final T item){
        final ResourceLocation id = Main.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;

    }

}