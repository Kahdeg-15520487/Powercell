package powercell.content

import mindustry.content.Fx.*
import mindustry.content.Items
import mindustry.content.Liquids
import mindustry.ctype.ContentList
import mindustry.gen.Sounds.door
import mindustry.gen.Sounds.release
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.type.ItemStack.with
import mindustry.type.LiquidStack
import mindustry.world.Block
import mindustry.world.blocks.production.GenericCrafter

import powercell.world.blocks.power.Discharger

public class PowercellBlocks: ContentList{
    override fun load(){
        discharger = object : Discharger("discharger"){
            init{
                requirements(Category.power, with(Items.copper, 100, Items.lead, 50, Items.graphite, 100))
                size = 2
                powerProduction = 1f

                alwaysUnlocked = true
            }
        }

        sieve = object : GenericCrafter("sieve") {
            init {
                requirements(Category.crafting, with(Items.copper, 35))

                size = 1
                craftTime = 60f
                craftEffect = pulverize

                hasPower = false
                hasLiquids = false
                hasItems = true

                outputItem = ItemStack(Items.scrap, 1)

                consumes.item(Items.sand, 4)

                alwaysUnlocked = true
            }
        }
    }

    companion object{
        lateinit var discharger: Block
        lateinit var sieve: Block
    }
}