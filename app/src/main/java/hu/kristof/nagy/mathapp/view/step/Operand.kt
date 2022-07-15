package hu.kristof.nagy.mathapp.view.step

interface Operand : Expression

open class Value(val x: Number) : Operand {
    override fun toLatex(): String {
        return x.toString()
    }
}

class Infinity : Value(Int.MAX_VALUE) {
    override fun toLatex(): String {
        return "\\infty"
    }
}

class EulersNumber : Value(2.7183) {
    override fun toLatex(): String {
        return "e"
    }
}

class Pi : Value(3.14159) {
    override fun toLatex(): String {
        return "\\pi"
    }
}

open class Variable(val name: String) : Operand {
    override fun toLatex(): String {
        return name
    }
}

class Alpha : Variable("\\alpha")
class Beta : Variable("\\beta")
class Gamma: Variable("\\gamma")
class Omega : Variable("\\omega")
class Epsilon : Variable("\\epsilon")
class VarEpsilon : Variable("\\varepsilon")
class Phi : Variable("\\phi")
class VarPhi : Variable("\\varphi")