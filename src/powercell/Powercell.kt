package powercell

import arc.*
import arc.util.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*

import powercell.content.*

class Powercell : Mod(){

    override fun loadContent(){
        Log.info("Loading some example content.")
        PowercellItems().load()
        PowercellBlocks().load()
    }
}
