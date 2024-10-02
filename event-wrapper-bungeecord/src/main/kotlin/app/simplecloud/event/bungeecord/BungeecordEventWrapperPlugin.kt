package app.simplecloud.event.bungeecord

import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.plugin.Plugin

class BungeecordEventWrapperPlugin : Plugin() {

    private lateinit var wrapper: BungeecordEventWrapper

    override fun onEnable() {
        wrapper = BungeecordEventWrapper(ProxyServer.getInstance())
    }

    override fun onDisable() {

    }
}