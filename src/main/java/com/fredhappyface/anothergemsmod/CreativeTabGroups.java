package com.fredhappyface.anothergemsmod;

import com.fredhappyface.anothergemsmod.init.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabGroups {
    public static final ItemGroup ITEM_GROUP = new ItemGroup(Main.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.myblock);
        }
    };
}
