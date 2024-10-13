package app.simplecloud.event.paper.mapped

import CloudPaperEvent
import com.google.protobuf.Message

class CloudGenericEvent<T : Message>(private val type: Class<T>, private val message: T) : CloudPaperEvent<T>() {
    override fun getType(): Class<T> {
        return type
    }

    override fun getPayload(): T {
        return message
    }
}