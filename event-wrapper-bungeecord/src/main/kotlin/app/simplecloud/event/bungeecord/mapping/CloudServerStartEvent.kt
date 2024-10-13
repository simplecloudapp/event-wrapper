package app.simplecloud.event.bungeecord.mapping

import app.simplecloud.controller.shared.server.Server
import app.simplecloud.controller.shared.time.ProtoBufTimestamp
import app.simplecloud.event.shared.CloudServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStartCause
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import java.time.LocalDateTime

class CloudServerStartEvent(private val message: ServerStartEvent) : CloudBungeecordEvent<ServerStartEvent>(), CloudServerStartEvent {
    override fun getServer(): Server {
        return Server.fromDefinition(message.server)
    }

    override fun getStartCause(): ServerStartCause {
        return message.startCause
    }

    override fun getStartedAt(): LocalDateTime {
        return ProtoBufTimestamp.toLocalDateTime(message.startedAt)
    }

    override fun getPayload(): ServerStartEvent {
        return message
    }
}