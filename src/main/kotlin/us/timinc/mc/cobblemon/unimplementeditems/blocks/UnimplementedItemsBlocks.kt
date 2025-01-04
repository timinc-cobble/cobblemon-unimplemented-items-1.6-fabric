@file:Suppress("MemberVisibilityCanBePrivate")

package us.timinc.mc.cobblemon.unimplementeditems.blocks

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item.Settings
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems

object UnimplementedItemsBlocks {
    val REPEL = Block(FabricBlockSettings.copyOf(Blocks.STONE))

    fun register() {
        Registry.register(Registries.BLOCK, UnimplementedItems.modIdentifier("repel"), REPEL)
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("repel"), BlockItem(REPEL, Settings())
        )

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register { content ->
            content.add(REPEL)
        }
    }
}