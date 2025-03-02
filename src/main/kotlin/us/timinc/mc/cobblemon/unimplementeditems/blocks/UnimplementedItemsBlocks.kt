@file:Suppress("MemberVisibilityCanBePrivate")

package us.timinc.mc.cobblemon.unimplementeditems.blocks

import com.cobblemon.mod.common.item.group.CobblemonItemGroups
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems

object UnimplementedItemsBlocks {
    val REPEL = Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))

    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, UnimplementedItems.modIdentifier("repel"), REPEL)
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("repel"), BlockItem(REPEL, Item.Properties())
        )

        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.BLOCKS_KEY).register { content ->
            content.accept(REPEL)
        }
    }
}