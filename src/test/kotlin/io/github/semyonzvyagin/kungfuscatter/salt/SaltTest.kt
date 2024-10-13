package io.github.semyonzvyagin.kungfuscatter.salt

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger

class SaltTest : StringSpec({

    "asLong should return zero for empty salt" {
        Salt.EMPTY_SALT.asLong shouldBe 0L
    }

    "asLong should return correct value for non empty salt" {
        Salt("salt").asLong shouldBe 3522646L
    }

    "asBigInteger should be consistent for empty string" {
        Salt.EMPTY_SALT.asBigInteger shouldBe BigInteger.ZERO
    }

    "asBigInteger should return correct value for non empty salt" {
        Salt("salt").asBigInteger shouldBe 15728170241416.toBigInteger()
    }
})