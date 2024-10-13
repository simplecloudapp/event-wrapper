
import app.simplecloud.event.shared.CloudEvent
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

abstract class CloudPaperEvent<T : com.google.protobuf.Message> : CloudEvent<T>, Event() {
    companion object {
        val handlers: HandlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList {
        return Companion.handlers
    }
}