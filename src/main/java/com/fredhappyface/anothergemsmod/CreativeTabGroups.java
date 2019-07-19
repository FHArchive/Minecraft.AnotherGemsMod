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

    public static final ItemGroup ITEM_GROUP_DECORATION = new ItemGroup(Main.MOD_ID + ".decoration") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getBricks());
        }
    };



    public static final ItemGroup ITEM_GROUP_ARMOUR = new ItemGroup(Main.MOD_ID + ".armor") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModGems.AQUAMARINE.getChest());
        }
    };


    

}
