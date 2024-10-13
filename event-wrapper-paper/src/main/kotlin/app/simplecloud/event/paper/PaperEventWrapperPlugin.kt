package app.simplecloud.event.paper

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class PaperEventWrapperPlugin : JavaPlugin() {

    private lateinit var wrapper: PaperEventWrapper

    override fun onEnable() {
        wrapper = PaperEventWrapper(Bukkit.getServer())
        wrapper.initialize()
    }

    override fun onDisable() {
        wrapper.shutdown()
    }

}