package app.simplecloud.event.velocity.mapping

import app.simplecloud.controller.shared.server.Server
import app.simplecloud.controller.shared.time.ProtoBufTimestamp
import app.simplecloud.event.shared.CloudServerUpdateEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import java.time.LocalDateTime

class CloudServerUpdateEvent(private val payload: ServerUpdateEvent) : CloudServerUpdateEvent {
    override fun getType(): Class<ServerUpdateEvent> {
        return ServerUpdateEvent::class.java
    }

    override fun getPayload(): ServerUpdateEvent {
        return payload
    }

    override fun getFrom(): Server {
        return Server.fromDefinition(payload.serverBefore)
    }

    override fun getTo(): Server {
        return Server.fromDefinition(payload.serverAfter)
    }

    override fun getUpdatedAt(): LocalDateTime {
        return ProtoBufTimestamp.toLocalDateTime(payload.updatedAt)
    }

}