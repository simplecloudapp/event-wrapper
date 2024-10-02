package app.simplecloud.event.bungeecord

import app.simplecloud.event.bungeecord.mapping.CloudBungeecordEvent
import app.simplecloud.event.shared.CloudEventPubSubListener
import app.simplecloud.event.shared.CloudEventWrapper
import com.google.protobuf.Message
import net.md_5.bungee.api.ProxyServer

class BungeecordEventWrapper(private val server: ProxyServer) : CloudEventWrapper() {
    override fun <T : Message> getPubSubListener(): CloudEventPubSubListener<T, CloudBungeecordEvent<*>> {
        return BungeecordPubSubListener(server)
    }
}