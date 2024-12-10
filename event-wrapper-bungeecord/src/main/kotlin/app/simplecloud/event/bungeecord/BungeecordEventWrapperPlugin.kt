package app.simplecloud.event.bungeecord

import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.plugin.Plugin

class BungeecordEventWrapperPlugin : Plugin() {

    private val wrapper: BungeecordEventWrapper = BungeecordEventWrapper(ProxyServer.getInstance())

    override fun onEnable() {
        wrapper.initialize()
    }

    override fun onDisable() {
        wrapper.shutdown()
    }
}