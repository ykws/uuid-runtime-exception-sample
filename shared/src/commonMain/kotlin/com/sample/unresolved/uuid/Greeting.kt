package com.sample.unresolved.uuid

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()
    private val user = User(uuid4())

    fun greet(): String {
        // A Runtime Exception occurs here.
        //
        // iOS:
        // kotlin.native.internal.IrLinkageError: Reference to class 'Uuid' can not be evaluated: No class found for symbol 'kotlin.uuid/Uuid|null[0]'
        //
        // Android:
        // kotlinx.serialization.SerializationException: Serializer for class 'User' is not found.
        //
        val jsonString = Json.encodeToString(user)

        return "Hello, ${platform.name}! $jsonString"
    }
}

@Serializable data class User(val uuid: Uuid)
