import kotlin.math.PI

open class Acuario(open var largo: Int = 100, open var ancho: Int = 20, open var alto: Int = 40) {
    fun imprimirTamano(){
        println("Ancho:  $ancho cm" + "Alto: $alto"  + "largo + $largo" )
        println("Volumen: $volumen l Agua: $agua l (${agua/volumen*100.0}% lleno)")
    }
//    init {
//        println("inicializando acuario")
//    }
//    init {
//        // 1 litro = 1000 cm^3
//        println("Volumen: ${ancho * largo * alto / 1000} l")
//    }
   open var volumen: Int
        get() = ancho * alto * largo / 1000  // 1000 cm^3 = 1 l
        set(valor){
            alto = (valor *1000)/(ancho*largo)
        }
    open val forma = "rectángulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9


    class TanqueTorre (override var alto: Int, var diametro: Int): Acuario(alto = alto, ancho = diametro, largo = diametro) {
        override var volumen: Int
            // área elíptica = π * r1 * r2
            get() = (ancho/2 * largo/2 * alto / 1000 * PI).toInt()
            set(valor) {
                alto = ((valor * 1000 / PI) / (ancho/2 * largo/2)).toInt()
            }

        override var agua = volumen * 0.8
        override val forma = "cilindro"
    }






    constructor(numeroDePeces: Int) : this() {
        // 2,000 cm^3 por pez + espacio extra para que no se derrame

        val tanque = numeroDePeces * 2000 * 1.1
    }


}

