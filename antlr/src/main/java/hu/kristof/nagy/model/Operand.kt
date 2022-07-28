package hu.kristof.nagy.model

import com.google.errorprone.annotations.Var

abstract class Operand : Expression()

open class Value(val x: Number) : Operand() {
    override fun toLatex(): String {
        return x.toString()
    }

    override fun simplify(): Expression = this

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Value

        if (x != other.x) return false

        return true
    }

    override fun hashCode(): Int {
        return x.hashCode()
    }

    override fun toString(): String {
        return "Value(x=$x)"
    }
}

class Infinity : Value(Int.MAX_VALUE) {
    override fun toLatex(): String {
        return """\\infty"""
    }

    override fun simplify(): Expression = this
}

class Pi : Value(3.14159) {
    override fun toLatex(): String {
        return """\\pi"""
    }

    override fun simplify(): Expression = this
}

open class Variable(val name: String) : Operand() {
    override fun toLatex(): String {
        return name
    }

    override fun simplify(): Expression = this

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Variable

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Variable(name='$name')"
    }
}

class Alpha : Variable("""\\alpha""") { override fun simplify(): Expression = this }
class Beta : Variable("""\\beta""") { override fun simplify(): Expression = this }
class Gamma: Variable("""\\gamma""") { override fun simplify(): Expression = this }
class Omega : Variable("""\\omega""") { override fun simplify(): Expression = this }
class Epsilon : Variable("""\\epsilon""") { override fun simplify(): Expression = this }
class VarEpsilon : Variable("""\\varepsilon""") { override fun simplify(): Expression = this }
class Phi : Variable("""\\phi""") { override fun simplify(): Expression = this }
class VarPhi : Variable("""\\varphi""") { override fun simplify(): Expression = this }