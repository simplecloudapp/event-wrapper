package app.simplecloud.event.bungeecord

import app.simplecloud.event.bungeecord.mapping.*
import app.simplecloud.event.shared.CloudEventPubSubListener
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import com.google.protobuf.Message
import net.md_5.bungee.api.ProxyServer

class BungeecordPubSubListener<T : Message>(private val server: ProxyServer) : CloudEventPubSubListener<T, CloudBungeecordEvent<*>>() {
    override fun map(message: T): CloudBungeecordEvent<*> {
        if(message is ServerStartEvent) {
            return CloudServerStartEvent(message)
        }

        if(message is ServerStopEvent) {
            return CloudServerStopEvent(message)
        }

        if(message is ServerUpdateEvent){
            return CloudServerUpdateEvent(message)
        }
        return CloudGenericEvent(message.javaClass, message)
    }

    override fun fire(event: CloudBungeecordEvent<*>) {
        server.pluginManager.callEvent(event)
    }
}