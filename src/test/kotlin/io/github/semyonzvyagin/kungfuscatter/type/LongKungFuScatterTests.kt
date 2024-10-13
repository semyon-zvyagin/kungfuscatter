package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterPropertyTest
import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterTest
import io.kotest.property.Arb
import io.kotest.property.arbitrary.long

class LongKungFuScatterTest : BaseKungFuScatterTest<Long>(
    kungFuScatterGen = { salt -> LongKungFuScatter(RANGE, salt) },
    values = RANGE.toSet()
) {
    companion object {
        private val RANGE = Int.MAX_VALUE.toLong()..(Int.MAX_VALUE.toLong() + 10_000)
    }
}

class LongKungFuScatterPropertyTest : BaseKungFuScatterPropertyTest<Long>(
    kungFuScatter = LongKungFuScatter(),
    gen = Arb.long(Long.MIN_VALUE..Long.MAX_VALUE)
)