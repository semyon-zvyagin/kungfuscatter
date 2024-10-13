package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatter
import io.github.semyonzvyagin.kungfuscatter.salt.Salt
import io.github.semyonzvyagin.kungfuscatter.salt.Salt.Companion.EMPTY_SALT
import java.math.BigInteger

class LongKungFuScatter(
    from: Long = Long.MIN_VALUE,
    to: Long = Long.MAX_VALUE,
    salt: Salt = EMPTY_SALT,
) : BaseKungFuScatter<Long, BigInteger>(
    from = from,
    to = to,
    salt = salt.asBigInteger,

    ext = { toBigInteger() },
    asT = { toLong() },

    ext0 = 0.toBigInteger(),
    ext1 = 1.toBigInteger(),
    ext2 = 2.toBigInteger(),

    abs = { abs() },

    mod = { this % it },
    add = { this + it },
    subtract = { this - it },
    multiply = { this * it },
    divide = { this / it },
    gcd = { gcd(it) },
    modInverse = { modInverse(it) },
) {

    constructor(
        range: LongRange = Long.MIN_VALUE..Long.MAX_VALUE,
        salt: Salt = EMPTY_SALT,
    ) : this(
        from = range.first,
        to = range.last,
        salt = salt
    )
}
