package app.simplecloud.event.shared

import com.google.protobuf.Message

interface CloudEvent<T : Message> {
    fun getType(): Class<T>
    fun getPayload(): T
}