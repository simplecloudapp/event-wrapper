package app.simplecloud.event.paper

import CloudPaperEvent
import app.simplecloud.event.shared.CloudEventPubSubListener
import app.simplecloud.event.shared.CloudEventWrapper
import com.google.protobuf.Message
import org.bukkit.Server

class PaperEventWrapper(private val server: Server) : CloudEventWrapper() {
    override fun <T : Message> getPubSubListener(): CloudEventPubSubListener<T, CloudPaperEvent<*>> {
        return PaperPubSubListener(server)
    }
}