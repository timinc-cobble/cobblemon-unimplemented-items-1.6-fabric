package us.timinc.mc.cobblemon.unimplementeditems.items

import com.cobblemon.mod.common.api.Priority
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity
import com.cobblemon.mod.common.pokemon.Pokemon
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import us.timinc.mc.cobblemon.unimplementeditems.ErrorMessages
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems

class AbilityPatch : PokemonItem(
    Item.Properties().stacksTo(16)
) {
    override fun processInteraction(
        itemStack: ItemStack, player: Player, target: PokemonEntity, pokemon: Pokemon,
    ): InteractionResult {
        // Pre-Gen9, if you already had your hidden, it had no effect.
        val preGen9 = !UnimplementedItems.config.abilityPatchGen9;

        // It has its hidden if the priority is Low.
        val hasHidden = pokemon.ability.priority == Priority.LOW
        // If we already have our hidden, and we're pre-gen9, get out.
        if (hasHidden && preGen9) {
            player.sendSystemMessage(Component.translatable(ErrorMessages.alreadyHasHiddenAbility))
            return InteractionResult.FAIL
        }

        val tForm = pokemon.form
        // If we don't have our hidden, check to make sure there is a hidden.
        if (!hasHidden && tForm.abilities.mapping[Priority.LOW] == null) {
            player.sendSystemMessage(Component.translatable(ErrorMessages.noHiddenAbility))
            return InteractionResult.FAIL
        }

        // Get the new ability.
        val priority = if (hasHidden) Priority.LOWEST else Priority.LOW
        val targetAbilityMapping = tForm.abilities.mapping[priority]
        val potentialAbility = targetAbilityMapping?.get(0) ?: return InteractionResult.FAIL
        val newAbilityBuilder = potentialAbility.template.builder
        val newAbility = newAbilityBuilder.invoke(potentialAbility.template, false, priority)
        pokemon.updateAbility(newAbility)

        // Consume and succeed.
        itemStack.count--
        return InteractionResult.SUCCESS
    }
}