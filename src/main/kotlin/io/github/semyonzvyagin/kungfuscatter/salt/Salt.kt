package io.github.semyonzvyagin.kungfuscatter.salt

import java.math.BigInteger

@JvmInline
value class Salt(val value: String) {
    val asLong: Long
        get() = value.hashCode().toLong()
    val asBigInteger: BigInteger
        get() {
            val mid = value.length / 2
            val left = value.slice(0..< mid).hashCode()
            val right = value.slice(mid ..< value.length).hashCode()
            return left.toBigInteger().shiftLeft(Int.SIZE_BITS) + right.toBigInteger()
        }

    companion object {
        val EMPTY_SALT = Salt(value = "")
    }
}
