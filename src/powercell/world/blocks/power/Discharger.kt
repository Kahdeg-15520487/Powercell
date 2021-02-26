// package powercell.world.blocks.power

// import arc.*
// import arc.func.*
// import arc.graphics.*
// import arc.graphics.g2d.*
// import arc.math.*
// import arc.util.*
// import arc.struct.EnumSet
// import mindustry.Vars
// import mindustry.Vars.tilesize
// import mindustry.graphics.Drawf
// import mindustry.graphics.Pal
// import mindustry.world.Edges
// import mindustry.world.blocks.power.PowerGenerator
// import mindustry.world.meta.StatUnit
// import mindustry.world.consumers.*
// import mindustry.world.meta.*
// import mindustry.type.*

// import  mindustry.world.blocks.power.ItemLiquidGenerator

// open class Discharger(name: String) : ItemLiquidGenerator (true,false,name) {

//     var fanRegion: TextureRegion? = null
//     var topRegion: TextureRegion? = null

//     override fun init() {
//         consumes.add(ConsumeItemFilter(Boolf<Item>it: Item -> it.name == "powercell"))
//     }

//     override fun load() {
//         super.load()
//         fanRegion = Core.atlas.find("$name-fan")
//         topRegion = Core.atlas.find("$name-top")
//     }

//     init {
//         flags = EnumSet.of()
//     }

//     override fun drawPlace(x: Int, y: Int, rotation: Int, valid: Boolean) {
//         Draw.color(Pal.placing)
//         Lines.stroke(size.toFloat())
//         Lines.square(x * Vars.tilesize + offset, y * Vars.tilesize + offset, Vars.tilesize * 1f)
//     }

//     override fun setStats() {
//         super.setStats()
//         stats.remove(generationType)
//         stats.add(generationType, powerProduction * 60f, StatUnit.powerSecond)
//     }

//     override fun icons(): Array<TextureRegion> {
//         return arrayOf(region, fanRegion!!, topRegion!!)
//     }

//     inner class DischargerBuild : ItemLiquidGeneratorBuild () {

//         override fun draw(){
//             Draw.rect(region, x, y)
//             super.draw();
//             Draw.rect(fanRegion, x, y)
//             // Draw.rect(topRegion, x, y)
//         }

//         override fun drawSelect() {
//             drawPlace(tileX(), tileY(), 0, true)
//         }
//     }
// }