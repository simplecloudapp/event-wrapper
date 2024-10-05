package app.simplecloud.event.velocity

import BuildConstants
import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer

@Plugin(
    id = BuildConstants.MODULE_NAME,
    name = BuildConstants.MODULE_NAME,
    version = BuildConstants.VERSION,
    authors = ["daviidooo"],
    description = "An pubsub wrapper for listening to simplecloud events"
)
class VelocityEventWrapperPlugin @Inject constructor(server: ProxyServer) {
    private val wrapper = VelocityCloudEventWrapper(server)

    @Subscribe
    fun onProxyInitialize(event: ProxyInitializeEvent) {
        wrapper.initialize()
    }

    @Subscribe
    fun onProxyShutdown(event: ProxyShutdownEvent) {
        wrapper.shutdown()
    }
}