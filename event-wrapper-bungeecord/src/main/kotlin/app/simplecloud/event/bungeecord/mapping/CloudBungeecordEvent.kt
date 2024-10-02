package app.simplecloud.event.bungeecord.mapping

import app.simplecloud.event.shared.CloudEvent
import com.google.protobuf.Message
import net.md_5.bungee.api.plugin.Event

abstract class CloudBungeecordEvent<T : Message> : CloudEvent<T>, Event()