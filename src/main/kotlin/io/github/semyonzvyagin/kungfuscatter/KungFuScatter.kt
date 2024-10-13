package io.github.semyonzvyagin.kungfuscatter


interface KungFuScatter<T> {

    fun obfuscate(value: T): T

    fun deobfuscate(value: T): T

}