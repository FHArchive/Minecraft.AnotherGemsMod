package com.fredhappyface.anothergemsmod.lib.data;

import com.fredhappyface.anothergemsmod.CreativeTabGroups;
import net.minecraft.item.Item;


/**
 * @author FredHappyface
 * @date 2019/07/18
 *
 * Object holding data for tool attributes. harvestLevelIn, maxUsesIn, efficiencyIn, maxDamageIn, enchantabilityIn is used
 * by ModItemTier
 */
public class ToolAttrs {
    private int attackDamageIn;
    private float attackSpeedIn;
    private Item.Properties itemProperties = new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_TOOLS);

    // Used by ModItemTier
    private int harvestLevelIn;
    private int maxUsesIn;
    private float efficiencyIn;
    private float maxDamageIn;
    private int enchantabilityIn;

    /**
     * Lazy constructor, use if you are hardcoding values for ModItemTier
     * @param attackDamageIn
     * @param attackSpeedIn
     */
    public ToolAttrs(int attackDamageIn, float attackSpeedIn) {
        this(attackDamageIn, attackSpeedIn, 0,0,0,0,0);
    }

    /**
     * Required if enumerating tools with different ModItemTier properties. Use getters to access these properties. eg.
     * getAttackDamageIn to get attackDamageIn
     * @param attackDamageIn
     * @param attackSpeedIn
     * @param harvestLevelIn
     * @param maxUsesIn
     * @param efficiencyIn
     * @param maxDamageIn
     * @param enchantabilityIn
     */
    public ToolAttrs(int attackDamageIn, float attackSpeedIn, int harvestLevelIn, int maxUsesIn, float efficiencyIn, float maxDamageIn, int enchantabilityIn) {
        this.attackDamageIn = attackDamageIn;
        this.attackSpeedIn = attackSpeedIn;
        this.harvestLevelIn = harvestLevelIn;
        this.maxUsesIn = maxUsesIn;
        this.efficiencyIn = efficiencyIn;
        this.maxDamageIn = maxDamageIn;
        this.enchantabilityIn = enchantabilityIn;
    }

    public int getAttackDamageIn() {
        return attackDamageIn;
    }

    public float getAttackSpeedIn() {
        return attackSpeedIn;
    }

    public Item.Properties getItemProperties() {
        return itemProperties;
    }

    public int getHarvestLevelIn() {
        return harvestLevelIn;
    }

    public int getMaxUsesIn() {
        return maxUsesIn;
    }

    public float getEfficiencyIn() {
        return efficiencyIn;
    }

    public float getMaxDamageIn() {
        return maxDamageIn;
    }

    public int getEnchantabilityIn() {
        return enchantabilityIn;
    }
}
