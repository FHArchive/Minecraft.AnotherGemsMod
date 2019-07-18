package com.fredhappyface.anothergemsmod;

import com.fredhappyface.anothergemsmod.enumeration.ModGems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabGroups {
    public static final ItemGroup ITEM_GROUP_RESOURCES = new ItemGroup(Main.MOD_ID + ".resources") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getOreBlock());
        }
    };

    public static final ItemGroup ITEM_GROUP_TOOLS = new ItemGroup(Main.MOD_ID + ".tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getPickaxeItem());
        }
    };

    // Additional groups (hidden)
    /*
    public static final ItemGroup ITEM_GROUP_WEAPONS = new ItemGroup(Main.MOD_ID + ".weapons") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getOreBlock());
        }
    };

     */

    public static final ItemGroup ITEM_GROUP_ARMOUR = new ItemGroup(Main.MOD_ID + ".armour") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getOreBlock());
        }
    };


    

}
