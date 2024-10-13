package app.simplecloud.event.shared

import app.simplecloud.controller.shared.server.Server
import build.buf.gen.simplecloud.controller.v1.ServerStopCause
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerTerminationMode
import java.time.LocalDateTime

interface CloudServerStopEvent : CloudEvent<ServerStopEvent> {
    override fun getType(): Class<ServerStopEvent> {
        return ServerStopEvent::class.java
    }

    fun getStopCause(): ServerStopCause

    fun getTerminationMode(): ServerTerminationMode

    fun getServer(): Server

    fun getStoppedAt(): LocalDateTime
}