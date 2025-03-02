package us.timinc.mc.cobblemon.unimplementeditems

import net.fabricmc.fabric.api.loot.v3.LootTableSource
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.NestedLootTable

object Loot {
    fun register(source: LootTableSource, id: ResourceLocation, tableBuilder: LootTable.Builder) {
        if (source.isBuiltin && UnimplementedItems.config.lootPoolOverrides.contains(id)) {
            println(id.path)
            val pool = LootPool.Builder()
                .add(
                    NestedLootTable.simpleBuilder(
                        RegistryKey.of(
                            BuiltInRegistries.LOOT_POOL_ENTRY_TYPE,
                            UnimplementedItems.modIdentifier("overrides/${id.path}")
                        )
                    )
                ).build()
            tableBuilder.pool(pool)
        }
    }
}