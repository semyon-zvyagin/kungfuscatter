package io.github.semyonzvyagin.kungfuscatter.type

import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterPropertyTest
import io.github.semyonzvyagin.kungfuscatter.BaseKungFuScatterTest
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int

class IntKungFuScatterTest : BaseKungFuScatterTest<Int>(
    kungFuScatterGen = { salt -> IntKungFuScatter(RANGE, salt) },
    values = RANGE.toSet()
) {
    companion object {
        private val RANGE = -5_000..10_000
    }
}

class IntKungFuScatterPropertyTest : BaseKungFuScatterPropertyTest<Int>(
    kungFuScatter = IntKungFuScatter(),
    gen = Arb.int(Int.MIN_VALUE..Int.MAX_VALUE)
)