package hu.kristof.nagy.mathapp.view.step.model

interface Operand : Expression

open class Value(val x: Number) : Operand {
    override fun toLatex(): String {
        return x.toString()
    }

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
}

class Pi : Value(3.14159) {
    override fun toLatex(): String {
        return """\\pi"""
    }
}

open class Variable(val name: String) : Operand {
    override fun toLatex(): String {
        return name
    }

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

class Alpha : Variable("""\\alpha""")
class Beta : Variable("""\\beta""")
class Gamma: Variable("""\\gamma""")
class Omega : Variable("""\\omega""")
class Epsilon : Variable("""\\epsilon""")
class VarEpsilon : Variable("""\\varepsilon""")
class Phi : Variable("""\\phi""")
class VarPhi : Variable("""\\varphi""")