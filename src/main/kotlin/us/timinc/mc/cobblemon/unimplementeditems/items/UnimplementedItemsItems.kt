@file:Suppress("MemberVisibilityCanBePrivate")

package us.timinc.mc.cobblemon.unimplementeditems.items

import com.cobblemon.mod.common.api.pokemon.stats.Stats
import com.cobblemon.mod.common.item.group.CobblemonItemGroups
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems


object UnimplementedItemsItems {
    val BOTTLE_CAP_ATK = BottleCap(Stats.ATTACK)
    val BOTTLE_CAP_DEF = BottleCap(Stats.DEFENCE)
    val BOTTLE_CAP_SA = BottleCap(Stats.SPECIAL_ATTACK)
    val BOTTLE_CAP_SD = BottleCap(Stats.SPECIAL_DEFENCE)
    val BOTTLE_CAP_SPD = BottleCap(Stats.SPEED)
    val BOTTLE_CAP_HP = BottleCap(Stats.HP)
    val BOTTLE_CAP = Item(Item.Properties().stacksTo(16))
    val BOTTLE_CAP_GOLD = BottleCap(null)
    val POTION = Item(Item.Properties())
    val POTION_HYPER = Item(Item.Properties())
    val POTION_MAX = Item(Item.Properties())
    val ELIXIR = Item(Item.Properties())
    val ETHER = Item(Item.Properties())
    val DRY_ROOT = DryRoot()
    val POWER_WEIGHT = Item(Item.Properties())
    val POWER_BRACER = Item(Item.Properties())
    val POWER_BELT = Item(Item.Properties())
    val POWER_LENS = Item(Item.Properties())
    val POWER_BAND = Item(Item.Properties())
    val POWER_ANKLET = Item(Item.Properties())
    val ABILITY_PATCH = AbilityPatch()
    val ABILITY_CAPSULE = Item(Item.Properties())
    val SHINY_CHARM = Item(Item.Properties())

    fun register() {
        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.CONSUMABLES_KEY).register { content ->
            content.accept(BOTTLE_CAP_ATK)
            content.accept(BOTTLE_CAP_DEF)
            content.accept(BOTTLE_CAP_SA)
            content.accept(BOTTLE_CAP_SD)
            content.accept(BOTTLE_CAP_SPD)
            content.accept(BOTTLE_CAP_HP)
            content.accept(BOTTLE_CAP_GOLD)
            content.accept(ABILITY_PATCH)
            content.accept(ABILITY_CAPSULE)
        }

        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.CONSUMABLES_KEY).register { content ->
            content.accept(BOTTLE_CAP)
            content.accept(POTION)
            content.accept(POTION_HYPER)
            content.accept(POTION_MAX)
            content.accept(ELIXIR)
            content.accept(ETHER)
            content.accept(DRY_ROOT)
        }

        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.HELD_ITEMS_KEY).register { content ->
            content.accept(POWER_ANKLET)
            content.accept(POWER_BAND)
            content.accept(POWER_BELT)
            content.accept(POWER_LENS)
            content.accept(POWER_BRACER)
            content.accept(POWER_WEIGHT)
        }

        ItemGroupEvents.modifyEntriesEvent(CobblemonItemGroups.UTILITY_ITEMS_KEY).register {content ->
            content.accept(SHINY_CHARM)
        }

        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_atk"), BOTTLE_CAP_ATK
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_def"), BOTTLE_CAP_DEF
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_sa"), BOTTLE_CAP_SA
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_sd"), BOTTLE_CAP_SD
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_spd"), BOTTLE_CAP_SPD
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_hp"), BOTTLE_CAP_HP
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap"), BOTTLE_CAP
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("bottle_cap_gold"), BOTTLE_CAP_GOLD
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("potion"), POTION
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("potion_hyper"), POTION_HYPER
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("potion_max"), POTION_MAX
        )
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("ether"), ETHER)
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("elixir"), ELIXIR
        )
        Registry.register(
            BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("dry_root"), DRY_ROOT
        )
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_weight"), POWER_WEIGHT)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_bracer"), POWER_BRACER)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_belt"), POWER_BELT)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_lens"), POWER_LENS)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_band"), POWER_BAND)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("power_anklet"), POWER_ANKLET)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("ability_patch"), ABILITY_PATCH)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("ability_capsule"), ABILITY_CAPSULE)
        Registry.register(BuiltInRegistries.ITEM, UnimplementedItems.modIdentifier("shiny_charm"), SHINY_CHARM)

        FuelRegistry.INSTANCE.add(DRY_ROOT, 100)
        CompostingChanceRegistry.INSTANCE.add(DRY_ROOT, 0.3F)
    }
}