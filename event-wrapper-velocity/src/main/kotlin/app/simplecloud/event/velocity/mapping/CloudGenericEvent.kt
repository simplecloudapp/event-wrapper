package app.simplecloud.event.velocity.mapping

import app.simplecloud.event.shared.CloudEvent
import com.google.protobuf.Message

open class CloudGenericEvent<T : Message>(private val type: Class<T>, private val payload: T) : CloudEvent<T> {
    override fun getType(): Class<T> {
        return type
    }

    override fun getPayload(): T {
        return payload
    }
}