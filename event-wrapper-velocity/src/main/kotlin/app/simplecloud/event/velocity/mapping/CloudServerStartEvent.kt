package app.simplecloud.event.velocity.mapping

import app.simplecloud.controller.shared.server.Server
import app.simplecloud.controller.shared.time.ProtoBufTimestamp
import app.simplecloud.event.shared.CloudServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStartCause
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import java.time.LocalDateTime

class CloudServerStartEvent(private val payload: ServerStartEvent) : CloudServerStartEvent {
    override fun getType(): Class<ServerStartEvent> {
        return ServerStartEvent::class.java
    }

    override fun getPayload(): ServerStartEvent {
        return payload
    }

    override fun getServer(): Server {
        return Server.fromDefinition(payload.server)
    }

    override fun getStartCause(): ServerStartCause {
        return payload.startCause
    }

    override fun getStartedAt(): LocalDateTime {
        return ProtoBufTimestamp.toLocalDateTime(payload.startedAt)
    }
}