package app.simplecloud.event.bungeecord.mapping

import com.google.protobuf.Message

class CloudGenericEvent<T : Message>(private val type: Class<T>, private val message: T) : CloudBungeecordEvent<T>() {
    override fun getType(): Class<T> {
        return type
    }

    override fun getPayload(): T {
        return message
    }
}