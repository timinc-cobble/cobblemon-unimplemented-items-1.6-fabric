package us.timinc.mc.cobblemon.unimplementeditems.util.cobblemon

import com.cobblemon.mod.common.api.pokemon.PokemonProperties
import com.cobblemon.mod.common.pokemon.Pokemon

class Pokematcher(
    val properties: List<String>? = null,
    val labels: List<String>? = null,
    val blacklistedProperties: List<String>? = null,
    val blacklistedLabels: List<String>? = null,
) {
    private fun propertiesMatch(pokemon: Pokemon) = (properties === null || (properties.isEmpty() || properties.any {
        PokemonProperties.parse(it).matches(pokemon)
    })) && (blacklistedProperties === null || (blacklistedProperties.isEmpty() || blacklistedProperties.none {
        PokemonProperties.parse(
            it
        ).matches(pokemon)
    }))

    private fun labelsMatch(pokemon: Pokemon) =
        (labels === null || (labels.isEmpty() || labels.any { pokemon.form.labels.contains(it) })) && (blacklistedLabels === null || (blacklistedLabels.isEmpty() || blacklistedLabels.none {
            pokemon.form.labels.contains(
                it
            )
        }))

    fun matches(pokemon: Pokemon) =
        propertiesMatch(pokemon) && labelsMatch(pokemon)
}