package com.sample.unresolved.uuid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform