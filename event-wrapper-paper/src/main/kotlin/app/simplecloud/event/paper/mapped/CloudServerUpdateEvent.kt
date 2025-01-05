package app.simplecloud.event.paper.mapped

import CloudPaperEvent
import app.simplecloud.controller.shared.server.Server
import app.simplecloud.droplet.api.time.ProtobufTimestamp
import app.simplecloud.event.shared.CloudServerUpdateEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import java.time.LocalDateTime

class CloudServerUpdateEvent(private val message: ServerUpdateEvent) : CloudPaperEvent<ServerUpdateEvent>(), CloudServerUpdateEvent {
    override fun getFrom(): Server {
        return Server.fromDefinition(message.serverBefore)
    }

    override fun getTo(): Server {
        return Server.fromDefinition(message.serverAfter)
    }

    override fun getUpdatedAt(): LocalDateTime {
        return ProtobufTimestamp.toLocalDateTime(message.updatedAt)
    }

    override fun getPayload(): ServerUpdateEvent {
        return message
    }
}