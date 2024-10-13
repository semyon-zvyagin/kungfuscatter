package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatter
import io.github.semyonzvyagin.kungfuscatter.salt.Salt
import io.github.semyonzvyagin.kungfuscatter.salt.Salt.Companion.EMPTY_SALT
import io.github.semyonzvyagin.kungfuscatter.type.BigIntegerKungFuScatter.Companion.NEGATIVE_GOOGOL
import io.github.semyonzvyagin.kungfuscatter.type.BigIntegerKungFuScatter.Companion.POSITIVE_GOOGOL
import java.math.BigInteger

class BigIntegerKungFuScatter(
    from: BigInteger = NEGATIVE_GOOGOL,
    to: BigInteger = POSITIVE_GOOGOL,
    salt: Salt = EMPTY_SALT,
) : BaseKungFuScatter<BigInteger, BigInteger>(
    from = from,
    to = to,
    salt = salt.asBigInteger,

    ext = { this },
    asT = { this },

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
        range: ClosedRange<BigInteger> = NEGATIVE_GOOGOL..POSITIVE_GOOGOL,
        salt: Salt = EMPTY_SALT,
    ) : this(
        from = range.start,
        to = range.endInclusive,
        salt = salt
    )

    companion object {
        val POSITIVE_GOOGOL: BigInteger = BigInteger.TEN.pow(100)
        val NEGATIVE_GOOGOL: BigInteger = POSITIVE_GOOGOL.negate()
    }
}
