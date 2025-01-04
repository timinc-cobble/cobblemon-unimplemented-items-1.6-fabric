@file:Suppress("MemberVisibilityCanBePrivate")

package us.timinc.mc.cobblemon.unimplementeditems.items

import com.cobblemon.mod.common.api.pokemon.stats.Stats
import com.cobblemon.mod.common.item.group.CobblemonItemGroups
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.Item
import net.minecraft.item.Item.Settings
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems

object UnimplementedItemsItems {
    val BOTTLE_CAP_ATK = BottleCap(Stats.ATTACK)
    val BOTTLE_CAP_DEF = BottleCap(Stats.DEFENCE)
    val BOTTLE_CAP_SA = BottleCap(Stats.SPECIAL_ATTACK)
    val BOTTLE_CAP_SD = BottleCap(Stats.SPECIAL_DEFENCE)
    val BOTTLE_CAP_SPD = BottleCap(Stats.SPEED)
    val BOTTLE_CAP_HP = BottleCap(Stats.HP)
    val BOTTLE_CAP = Item(Settings().maxCount(16))
    val BOTTLE_CAP_GOLD = BottleCap(null)
    val POTION = Item(Settings())
    val POTION_HYPER = Item(Settings())
    val POTION_MAX = Item(Settings())
    val ELIXIR = Item(Settings())
    val ETHER = Item(Settings())
    val DRY_ROOT = DryRoot()
    val POWER_WEIGHT = Item(Settings())
    val POWER_BRACER = Item(Settings())
    val POWER_BELT = Item(Settings())
    val POWER_LENS = Item(Settings())
    val POWER_BAND = Item(Settings())
    val POWER_ANKLET = Item(Settings())
    val ABILITY_PATCH = AbilityPatch()
    val ABILITY_CAPSULE = Item(Settings())
    val SHINY_CHARM = Item(Settings())

    fun register() {
        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.CONSUMABLES_KEY).register { content ->
            content.add(BOTTLE_CAP_ATK)
            content.add(BOTTLE_CAP_DEF)
            content.add(BOTTLE_CAP_SA)
            content.add(BOTTLE_CAP_SD)
            content.add(BOTTLE_CAP_SPD)
            content.add(BOTTLE_CAP_HP)
            content.add(BOTTLE_CAP_GOLD)
            content.add(ABILITY_PATCH)
            content.add(ABILITY_CAPSULE)
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { content ->
            content.add(BOTTLE_CAP)
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register { content ->
            content.add(POTION)
            content.add(POTION_HYPER)
            content.add(POTION_MAX)
            content.add(ELIXIR)
            content.add(ETHER)
            content.add(DRY_ROOT)
            content.add(POWER_ANKLET)
            content.add(POWER_BAND)
            content.add(POWER_BELT)
            content.add(POWER_LENS)
            content.add(POWER_BRACER)
            content.add(POWER_WEIGHT)
            content.add(SHINY_CHARM)
        }

        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_atk"), BOTTLE_CAP_ATK
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_def"), BOTTLE_CAP_DEF
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_sa"), BOTTLE_CAP_SA
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_sd"), BOTTLE_CAP_SD
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_spd"), BOTTLE_CAP_SPD
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_hp"), BOTTLE_CAP_HP
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap"), BOTTLE_CAP
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_gold"), BOTTLE_CAP_GOLD
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("potion"), POTION
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("potion_hyper"), POTION_HYPER
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("potion_max"), POTION_MAX
        )
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("ether"), ETHER)
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("elixir"), ELIXIR
        )
        Registry.register(
            Registries.ITEM, UnimplementedItems.modIdentifier("dry_root"), DRY_ROOT
        )
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_weight"), POWER_WEIGHT)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_bracer"), POWER_BRACER)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_belt"), POWER_BELT)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_lens"), POWER_LENS)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_band"), POWER_BAND)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("power_anklet"), POWER_ANKLET)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("ability_patch"), ABILITY_PATCH)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("ability_capsule"), ABILITY_CAPSULE)
        Registry.register(Registries.ITEM, UnimplementedItems.modIdentifier("shiny_charm"), SHINY_CHARM)

        FuelRegistry.INSTANCE.add(DRY_ROOT, 100)
        CompostingChanceRegistry.INSTANCE.add(DRY_ROOT, 0.3F)
    }
}