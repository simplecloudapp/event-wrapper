package app.simplecloud.event.shared

import app.simplecloud.droplet.api.auth.AuthCallCredentials
import app.simplecloud.pubsub.PubSubClient
import build.buf.gen.simplecloud.controller.v1.ServerStartEvent
import build.buf.gen.simplecloud.controller.v1.ServerStopEvent
import build.buf.gen.simplecloud.controller.v1.ServerUpdateEvent
import build.buf.gen.simplecloud.pubsub.v1.Message

abstract class CloudEventWrapper {

    private val client =
        PubSubClient(
            System.getenv("CONTROLLER_PUBSUB_HOST"),
            System.getenv("CONTROLLER_PUBSUB_PORT").toInt(),
            AuthCallCredentials(System.getenv("CONTROLLER_SECRET"))
        )

    fun initialize() {
        client.subscribe("event", Message::class.java, getPubSubListener())
        client.subscribe("event", ServerStartEvent::class.java, getPubSubListener())
        client.subscribe("event", ServerUpdateEvent::class.java, getPubSubListener())
        client.subscribe("event", ServerStopEvent::class.java, getPubSubListener())
    }

    abstract fun <T : com.google.protobuf.Message> getPubSubListener(): CloudEventPubSubListener<T, *>

    fun shutdown() {
        client.shutdown()
    }

}