package app.simplecloud.event.shared

import app.simplecloud.controller.shared.server.Server
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import java.time.LocalDateTime

interface CloudServerUpdateEvent : CloudEvent<ServerUpdateEvent> {
    override fun getType(): Class<ServerUpdateEvent> {
        return ServerUpdateEvent::class.java
    }

    fun getFrom(): Server

    fun getTo(): Server

    fun getUpdatedAt(): LocalDateTime

}