package app.simplecloud.event.paper.mapped

import CloudPaperEvent
import app.simplecloud.controller.shared.server.Server
import app.simplecloud.controller.shared.time.ProtoBufTimestamp
import app.simplecloud.event.shared.CloudServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopCause
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerTerminationMode
import java.time.LocalDateTime

class CloudServerStopEvent(private val message: ServerStopEvent) : CloudPaperEvent<ServerStopEvent>(), CloudServerStopEvent {
    override fun getStopCause(): ServerStopCause {
        return message.stopCause
    }

    override fun getTerminationMode(): ServerTerminationMode {
        return message.terminationMode
    }

    override fun getServer(): Server {
        return Server.fromDefinition(message.server)
    }

    override fun getStoppedAt(): LocalDateTime {
        return ProtoBufTimestamp.toLocalDateTime(message.stoppedAt)
    }

    override fun getPayload(): ServerStopEvent {
        return message
    }
}