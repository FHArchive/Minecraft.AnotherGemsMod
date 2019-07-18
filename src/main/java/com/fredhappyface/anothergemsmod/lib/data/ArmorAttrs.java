package com.fredhappyface.anothergemsmod.lib.data;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import net.minecraft.item.Item;

public class ArmorAttrs {

    private Item.Properties itemProperties = new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_ARMOUR);


    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final float toughness;

    public ArmorAttrs(int maxDamageFactor, int[] damageReductionAmountArray, float toughness) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.toughness = toughness;
    }

    public int getMaxDamageFactor() {
        return maxDamageFactor;
    }

    public int[] getDamageReductionAmountArray() {
        return damageReductionAmountArray;
    }

    public float getToughness() {
        return toughness;
    }

    public Item.Properties getItemProperties(){
        return itemProperties;
    }
}
