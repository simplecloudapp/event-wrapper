package app.simplecloud.event.velocity

import app.simplecloud.event.shared.CloudEvent
import app.simplecloud.event.shared.CloudEventPubSubListener
import app.simplecloud.event.shared.CloudEventWrapper
import com.google.protobuf.Message
import com.velocitypowered.api.proxy.ProxyServer

class VelocityCloudEventWrapper(private val server: ProxyServer) : CloudEventWrapper() {
    override fun <T : Message> getPubSubListener(): CloudEventPubSubListener<T, CloudEvent<*>> {
        return VelocityPubSubListener(server)
    }
}