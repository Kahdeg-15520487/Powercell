package powercell.content

import mindustry.Vars
import mindustry.content.Fx.*
import mindustry.content.Items
import mindustry.content.Liquids
import mindustry.ctype.ContentList
import mindustry.gen.Sounds.door
import mindustry.gen.Sounds.release
import mindustry.type.Category
import mindustry.type.Item
import mindustry.type.ItemStack
import mindustry.type.ItemStack.with
import mindustry.type.LiquidStack
import mindustry.world.Block
import mindustry.world.blocks.production.GenericCrafter
import mindustry.world.blocks.power.ItemLiquidGenerator

// import powercell.world.blocks.power.Discharger

public class PowercellBlocks: ContentList{
    override fun load(){
        discharger = object : ItemLiquidGenerator("discharger"){
            init{
                requirements(Category.power, with(Items.copper, 100, Items.lead, 50, Items.graphite, 100))
                size = 2
                powerProduction = 1f
                itemDuration = 120f

                // 120 * 10 * 1 = 120 * 10 * 

                consumes.item(PowercellItems.powercell,1)
                
                alwaysUnlocked = true
                randomlyExplode = false

                description = "Release the stored energy in powercells."
            }

            override fun getItemEfficiency(item: Item): Float{
                return -item.radioactivity;
            }
        }
        charger = object : GenericCrafter("charger"){
            init{
                requirements(Category.power, with(Items.copper, 100, Items.lead, 50, Items.graphite, 100))

                size = 2
                craftTime = 120f
                ambientSound = door
                craftEffect = pickup

                hasPower = true
                hasLiquids = false
                hasItems = true

                consumes.power(15f)
                consumes.item(Items.graphite,1)
                outputItem = ItemStack(PowercellItems.powercell,1)

                alwaysUnlocked = true

                description = "Charge graphite to store energy, result in powercell"
            }
        }
    }

    companion object{
        lateinit var discharger: Block
        lateinit var charger: Block
    }
}