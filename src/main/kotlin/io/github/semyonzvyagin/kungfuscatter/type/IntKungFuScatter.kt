package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatter
import io.github.semyonzvyagin.kungfuscatter.salt.Salt
import io.github.semyonzvyagin.kungfuscatter.salt.Salt.Companion.EMPTY_SALT
import kotlin.math.absoluteValue

class IntKungFuScatter(
    from: Int = Int.MIN_VALUE,
    to: Int = Int.MAX_VALUE,
    salt: Salt = EMPTY_SALT,
) : BaseKungFuScatter<Int, Long>(
    from = from,
    to = to,
    salt = salt.asLong,

    ext = { toLong() },
    asT = { toInt() },

    ext0 = 0L,
    ext1 = 1L,
    ext2 = 2L,

    abs = { absoluteValue },

    mod = { this % it },
    add = { this + it },
    subtract = { this - it },
    multiply = { this * it },
    divide = { this / it },
    gcd = { toBigInteger().gcd(it.toBigInteger()).toLong() },
    modInverse = { toBigInteger().modInverse(it.toBigInteger()).toLong() },
) {

    constructor(
        range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE,
        salt: Salt = EMPTY_SALT,
    ) : this(
        from = range.first,
        to = range.last,
        salt = salt
    )
}
