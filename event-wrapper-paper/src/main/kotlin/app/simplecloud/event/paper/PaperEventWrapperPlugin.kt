package app.simplecloud.event.paper

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class PaperEventWrapperPlugin : JavaPlugin() {

    private val wrapper: PaperEventWrapper = PaperEventWrapper(Bukkit.getServer())

    override fun onEnable() {
        wrapper.initialize()
    }

    override fun onDisable() {
        wrapper.shutdown()
    }

}