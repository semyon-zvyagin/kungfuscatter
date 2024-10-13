package io.github.semyonzvyagin.kungfuscatter


abstract class BaseKungFuScatter<T : Comparable<T>, Ext : Comparable<Ext>>(
    from: T,
    to: T,
    salt: Ext,
    private val ext: T.() -> Ext,
    private val asT: Ext.() -> T,
    private val ext0: Ext,
    private val ext1: Ext,
    ext2: Ext,
    abs: Ext.() -> Ext,
    private val mod: Ext.(Ext) -> Ext,
    private val add: Ext.(Ext) -> Ext,
    private val subtract: Ext.(Ext) -> Ext,
    private val multiply: Ext.(Ext) -> Ext,
    private val divide: Ext.(Ext) -> Ext,
    private val gcd: Ext.(Ext) -> Ext,
    private val modInverse: Ext.(Ext) -> Ext,
) : KungFuScatter<T> {

    private val extFrom = from.ext
    private val extTo = to.ext
    private val a: Ext
    private val b: Ext
    private val m: Ext
    private val range: ClosedRange<T>

    init {
        check(to > from) { "to value ($to) should be bigger than from value ($from)" }
        range = from..to
        val candidate = ext1 + (salt % (extTo - extFrom)).abs() // Start with the original candidate
        m = extTo - extFrom + ext1 // Size of the range
        a = findCoprime(candidate, m) // Find a coprime to m
        b = salt / ext2
    }

    private fun findCoprime(a: Ext, m: Ext): Ext {
        var candidate = a
        while (candidate.gcd(m) != ext1) {
            candidate += ext1
            if (candidate >= m) { // Prevent going out of bounds
                candidate = ext1 // Reset if we've gone beyond
            }
        }
        return candidate
    }

    override fun obfuscate(value: T): T {
        check(range.contains(value)) { "value ($value) should be in range ($range)" }
        val adjustedValue = value.ext - extFrom
        val obfuscatedValue = ((a * adjustedValue + b) % m + m) % m // Corrected
        return (extFrom + obfuscatedValue).asT
    }

    override fun deobfuscate(value: T): T {
        check(range.contains(value)) { "value ($value) should be in range ($range)" }
        val adjustedValue = value.ext - extFrom
        val modAdjustedValue = (adjustedValue - b + m) % m // Ensure non-negative
        val aInverse = a.modInverse(m)
        val originalValue = ((aInverse * modAdjustedValue % m + m) % m + extFrom)
        return originalValue.asT
    }

    private val T.ext: Ext
        get() = ext()

    private val Ext.asT: T
        get() = asT()

    private operator fun Ext.rem(other: Ext): Ext = mod(other)
    private operator fun Ext.plus(other: Ext): Ext = add(other)
    private operator fun Ext.minus(other: Ext): Ext = subtract(other)
    private operator fun Ext.times(other: Ext): Ext = multiply(other)
    private operator fun Ext.div(other: Ext): Ext = divide(other)
}
