package powercell.content

import arc.graphics.Color
import mindustry.ctype.ContentList
import mindustry.type.Item

class PowercellItems : ContentList {
    override fun load() {
        powercell = object : Item("powercell", Color.valueOf("45b6fe")) {
            init {
                alwaysUnlocked = true
                lowPriority = true
                radioactivity = -10f
            }
        }
    }

    companion object {
        var powercell: Item? = null
    }
}