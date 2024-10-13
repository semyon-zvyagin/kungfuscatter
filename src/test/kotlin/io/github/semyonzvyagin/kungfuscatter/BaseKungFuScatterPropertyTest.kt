package io.github.semyonzvyagin.kungfuscatter

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Gen
import io.kotest.property.checkAll

abstract class BaseKungFuScatterPropertyTest<T>(
    kungFuScatter: KungFuScatter<T>,
    gen: Gen<T>,
) : StringSpec({

    "obfuscate and deobfuscate should be inverse operations" {
        checkAll(gen) { value ->
            val obfuscated = kungFuScatter.obfuscate(value)
            val deobfuscated = kungFuScatter.deobfuscate(obfuscated)
            deobfuscated shouldBe value
        }
    }

})