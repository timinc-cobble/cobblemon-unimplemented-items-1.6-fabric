package us.timinc.mc.cobblemon.unimplementeditems.config

import net.minecraft.block.Blocks
import net.minecraft.loot.LootTables
import net.minecraft.util.Identifier
import us.timinc.mc.cobblemon.unimplementeditems.util.cobblemon.Pokematcher

class UnimplementedItemsConfig {
    val abilityPatchGen9: Boolean = true
    val lootPoolOverrides: List<Identifier> = listOf(
        LootTables.FISHING_TREASURE_GAMEPLAY.value,
        Blocks.TALL_GRASS.lootTableKey.value,
        Blocks.SHORT_GRASS.lootTableKey.value,
        Blocks.FERN.lootTableKey.value
    )
    val shinyCharmBonusRolls: Int = 2
    val bottleCapBlacklist: List<Pokematcher> = listOf()

    // Fishing treasure loot weights
    val fishingAirWeight: Int = 88
    val fishingBottleCapWeight: Int = 10
    val fishingGoldenBottleCapWeight: Int = 1
    val fishingAbilityPatchWeight: Int = 1
}