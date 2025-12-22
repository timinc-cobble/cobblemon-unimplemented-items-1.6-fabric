package us.timinc.mc.cobblemon.unimplementeditems

import net.fabricmc.fabric.api.loot.v3.LootTableSource
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LootTableEntry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object Loot {
    fun register(source: LootTableSource, id: Identifier, tableBuilder: LootTable.Builder) {
        if (UnimplementedItems.config.lootPoolOverrides.contains(id)) {
            if (id == net.minecraft.loot.LootTables.FISHING_TREASURE_GAMEPLAY.value) {
                // Dynamic fishing treasure pool using config weights
                val pool = LootPool.builder()
                    .with(ItemEntry.builder(Items.AIR).weight(UnimplementedItems.config.fishingAirWeight))
                    .with(ItemEntry.builder(net.minecraft.registry.Registries.ITEM.get(UnimplementedItems.modIdentifier("bottle_cap"))).weight(UnimplementedItems.config.fishingBottleCapWeight))
                    .with(ItemEntry.builder(net.minecraft.registry.Registries.ITEM.get(UnimplementedItems.modIdentifier("bottle_cap_gold"))).weight(UnimplementedItems.config.fishingGoldenBottleCapWeight))
                    .with(ItemEntry.builder(net.minecraft.registry.Registries.ITEM.get(UnimplementedItems.modIdentifier("ability_patch"))).weight(UnimplementedItems.config.fishingAbilityPatchWeight))
                tableBuilder.pool(pool)
            } else {
                // For other loot tables, use the static JSON
                println(id.path)
                val pool = LootPool.builder()
                    .with(
                        LootTableEntry.builder(
                            RegistryKey.of(
                                RegistryKeys.LOOT_TABLE,
                                UnimplementedItems.modIdentifier("overrides/${id.path}")
                            )
                        )
                    )
                tableBuilder.pool(pool)
            }
        }
    }
}