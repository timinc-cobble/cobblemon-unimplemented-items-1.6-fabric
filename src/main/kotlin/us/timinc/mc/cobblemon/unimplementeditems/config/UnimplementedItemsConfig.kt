package us.timinc.mc.cobblemon.unimplementeditems.config

import net.minecraft.block.Blocks
import net.minecraft.loot.LootTables
import net.minecraft.util.Identifier

class UnimplementedItemsConfig {
    val abilityPatchGen9: Boolean = true
    val lootPoolOverrides: List<Identifier> = listOf(
        LootTables.FISHING_TREASURE_GAMEPLAY.value,
        Blocks.TALL_GRASS.lootTableKey.value,
        Blocks.SHORT_GRASS.lootTableKey.value,
        Blocks.FERN.lootTableKey.value
    )
    val shinyCharmBonusRolls: Int = 2
}