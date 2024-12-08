package app.simplecloud.event.shared

import app.simplecloud.controller.shared.server.Server
import build.buf.gen.simplecloud.controller.v1.ServerStartCause
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import java.time.LocalDateTime

interface CloudServerStartEvent : CloudEvent<ServerStartEvent> {
    override fun getType(): Class<ServerStartEvent> {
        return ServerStartEvent::class.java
    }

    fun getServer(): Server

    fun getStartCause(): ServerStartCause

    fun getStartedAt(): LocalDateTime
}