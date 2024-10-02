package app.simplecloud.event.paper

import CloudPaperEvent
import app.simplecloud.event.paper.mapped.*
import app.simplecloud.event.shared.CloudEventPubSubListener
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import com.google.protobuf.Message
import org.bukkit.Server

class PaperPubSubListener<T : Message>(private val server: Server) : CloudEventPubSubListener<T, CloudPaperEvent<*>>() {
    override fun map(message: T): CloudPaperEvent<*> {
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

    override fun fire(event: CloudPaperEvent<*>) {
        server.pluginManager.callEvent(event)
    }
}