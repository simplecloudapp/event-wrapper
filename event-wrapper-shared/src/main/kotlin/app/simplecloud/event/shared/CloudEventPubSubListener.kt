package app.simplecloud.event.shared

import app.simplecloud.pubsub.PubSubListener

abstract class CloudEventPubSubListener<T: com.google.protobuf.Message, E : CloudEvent<*>> : PubSubListener<T> {
    override fun handle(message: T) {
        fire(map(message))
    }

    abstract fun map(message: T): E

    abstract fun fire(event: E)
}