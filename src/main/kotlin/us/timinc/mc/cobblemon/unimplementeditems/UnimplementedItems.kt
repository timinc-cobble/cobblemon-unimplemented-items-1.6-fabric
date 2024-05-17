package us.timinc.mc.cobblemon.unimplementeditems

import com.cobblemon.mod.common.api.events.CobblemonEvents
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import us.timinc.mc.cobblemon.unimplementeditems.blocks.UnimplementedItemsBlocks
import us.timinc.mc.cobblemon.unimplementeditems.blocks.UnimplementedItemsBlocks.REPEL
import us.timinc.mc.cobblemon.unimplementeditems.config.ConfigBuilder
import us.timinc.mc.cobblemon.unimplementeditems.config.UnimplementedItemsConfig
import us.timinc.mc.cobblemon.unimplementeditems.items.PostBattleItem
import us.timinc.mc.cobblemon.unimplementeditems.items.UnimplementedItemsItems

object UnimplementedItems : ModInitializer {
    const val MOD_ID = "unimplemented_items"
    var config: UnimplementedItemsConfig = ConfigBuilder.load(UnimplementedItemsConfig::class.java, MOD_ID)

    override fun onInitialize() {
        UnimplementedItemsItems.register()
        UnimplementedItemsBlocks.register()

        CobblemonEvents.POKEMON_ENTITY_SPAWN.subscribe { event ->
            val spawned = event.entity
            if (!spawned.pokemon.isWild()) return@subscribe

            val spawnedWorld = spawned.world
            val spawnedPos = spawned.pos
            for (xOff in -10..10) {
                for (yOff in -10..10) {
                    for (zOff in -10..10) {
                        val pos = spawnedPos.add(xOff.toDouble(), yOff.toDouble(), zOff.toDouble())
                        if (spawnedWorld.getBlockState(BlockPos.ofFloored(pos)).isOf(REPEL)) {
                            event.cancel()
                        }
                    }
                }
            }
        }

        CobblemonEvents.BATTLE_VICTORY.subscribe { event ->
            val ownedPokemon =
                event.battle.actors.flatMap { it.pokemonList }.map { it.originalPokemon }.filter { it.isPlayerOwned() }
            ownedPokemon.forEach { pokemon ->
                val heldItemStack = pokemon.heldItem()
                val heldItem = heldItemStack.item
                if (heldItem is PostBattleItem) {
                    heldItem.doPostBattle(heldItemStack, pokemon, event)
                }
            }
        }
    }

    fun myResourceLocation(str: String): Identifier {
        return Identifier(MOD_ID, str)
    }
}