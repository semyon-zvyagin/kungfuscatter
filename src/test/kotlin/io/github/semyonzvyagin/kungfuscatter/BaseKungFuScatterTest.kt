package io.github.semyonzvyagin.kungfuscatter

import io.github.semyonzvyagin.kungfuscatter.salt.Salt
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

abstract class BaseKungFuScatterTest<T>(
    kungFuScatterGen: (Salt) -> KungFuScatter<T>,
    values: Collection<T>,
) : StringSpec({

    val kungFuScatter = kungFuScatterGen(Salt("salt"))

    "obfuscate and deobfuscate should be inverse operations" {
        for (value in values) {
            val obfuscated = kungFuScatter.obfuscate(value)
            val deobfuscated = kungFuScatter.deobfuscate(obfuscated)
            deobfuscated shouldBe value
        }
    }

    "obfuscated values should be unique" {
        val obfuscatedValues = values.map { kungFuScatter.obfuscate(it) }
        val uniqueObfuscatedValues = obfuscatedValues.toSet()

        uniqueObfuscatedValues.size shouldBe obfuscatedValues.size
    }

    "obfuscated values should be in the range" {
        val obfuscatedValues = values.map { kungFuScatter.obfuscate(it) }

        obfuscatedValues.forEach { obfuscatedValue ->
            obfuscatedValue shouldBeIn values
        }
    }

    "obfuscation should produce different results with different salts" {
        val kungFuScatterA = kungFuScatterGen(Salt("saltA"))
        val kungFuScatterB = kungFuScatterGen(Salt("saltB"))

        val obfuscatedA = values.map { kungFuScatterA.obfuscate(it) }
        val obfuscatedB = values.map { kungFuScatterB.obfuscate(it) }

        obfuscatedA shouldNotBe obfuscatedB
    }

})