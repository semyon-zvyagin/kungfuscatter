package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterPropertyTest
import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterTest
import io.github.semyonzvyagin.kungfuscatter.type.BigIntegerKungFuScatter.Companion.NEGATIVE_GOOGOL
import io.kotest.property.Arb
import io.kotest.property.arbitrary.bigInt
import java.math.BigInteger

class BigIntegerKungFuScatterTest : BaseKungFuScatterTest<BigInteger>(
    kungFuScatterGen = { salt -> BigIntegerKungFuScatter(RANGE, salt) },
    values = SET
) {
    companion object {
        private val RANGE = NEGATIVE_GOOGOL..NEGATIVE_GOOGOL.plus(10_000.toBigInteger())
        private val SET =
            generateSequence(NEGATIVE_GOOGOL) {
                it + BigInteger.ONE
            }
                .takeWhile { RANGE.contains(it) }
                .toSet()
    }
}

class BigIntegerKungFuScatterPropertyTest : BaseKungFuScatterPropertyTest<BigInteger>(
    kungFuScatter = BigIntegerKungFuScatter(),
    gen = Arb.bigInt(
        maxNumBits = NEGATIVE_GOOGOL.bitCount()
    )
)