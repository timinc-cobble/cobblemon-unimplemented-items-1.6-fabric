package us.timinc.mc.cobblemon.unimplementeditems.influences

import com.cobblemon.mod.common.Cobblemon
import com.cobblemon.mod.common.api.spawning.detail.PokemonSpawnAction
import com.cobblemon.mod.common.api.spawning.detail.SpawnAction
import com.cobblemon.mod.common.api.spawning.influence.SpawningInfluence
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems.config
import us.timinc.mc.cobblemon.unimplementeditems.items.UnimplementedItemsItems.SHINY_CHARM
import kotlin.random.Random.Default.nextInt

class ShinyCharm(private val player: ServerPlayerEntity) : SpawningInfluence {
    override fun affectAction(action: SpawnAction<*>) {
        if (action !is PokemonSpawnAction) return
        if (!player.inventory.contains(ItemStack(SHINY_CHARM))) return

        val shinyRate: Int = Cobblemon.config.shinyRate.toInt()
        for (i in 1..config.shinyCharmBonusRolls) {
            if (nextInt(shinyRate) < 1) {
                action.props.shiny = true
                return
            }
        }
    }
}