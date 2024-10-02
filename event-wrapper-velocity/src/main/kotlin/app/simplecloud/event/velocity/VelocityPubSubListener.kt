package app.simplecloud.event.velocity

import app.simplecloud.event.shared.CloudEvent
import app.simplecloud.event.shared.CloudEventPubSubListener
import app.simplecloud.event.velocity.mapping.CloudGenericEvent
import app.simplecloud.event.velocity.mapping.CloudServerStartEvent
import app.simplecloud.event.velocity.mapping.CloudServerStopEvent
import app.simplecloud.event.velocity.mapping.CloudServerUpdateEvent
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import com.velocitypowered.api.proxy.ProxyServer

class VelocityPubSubListener<T : com.google.protobuf.Message>(private val server: ProxyServer) : CloudEventPubSubListener<T, CloudEvent<*>>() {
    override fun map(message: T): CloudEvent<*> {
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

    override fun fire(event: CloudEvent<*>) {
        server.eventManager.fire(event)
    }
}