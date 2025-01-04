package us.timinc.mc.cobblemon.unimplementeditems

import net.fabricmc.fabric.api.loot.v3.LootTableSource
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.LootTableEntry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object Loot {
    fun register(source: LootTableSource, id: Identifier, tableBuilder: LootTable.Builder) {
        if (source.isBuiltin && UnimplementedItems.config.lootPoolOverrides.contains(id)) {
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