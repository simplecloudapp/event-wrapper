package app.simplecloud.event.velocity.mapping

import app.simplecloud.controller.shared.server.Server
import app.simplecloud.controller.shared.time.ProtoBufTimestamp
import app.simplecloud.event.shared.CloudServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopCause
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerTerminationMode
import java.time.LocalDateTime

class CloudServerStopEvent(private val payload: ServerStopEvent) : CloudServerStopEvent {
    override fun getType(): Class<ServerStopEvent> {
        return ServerStopEvent::class.java
    }

    override fun getPayload(): ServerStopEvent {
        return payload
    }

    override fun getStopCause(): ServerStopCause {
        return payload.stopCause
    }

    override fun getTerminationMode(): ServerTerminationMode {
        return payload.terminationMode
    }

    override fun getServer(): Server {
        return Server.fromDefinition(payload.server)
    }

    override fun getStoppedAt(): LocalDateTime {
        return ProtoBufTimestamp.toLocalDateTime(payload.stoppedAt)
    }
}