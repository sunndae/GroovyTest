import java.util.Random

// solucion original
def PrepararRaciones(String estacion, int PronosticoTemperatura, float ProbabilidadLluvia){
    int raciones
    if(ProbabilidadLluvia < 0.5){
        if(estacion.toLowerCase() == "verano"){
            raciones = Math.round(3 * PronosticoTemperatura + 20*(1-ProbabilidadLluvia))
        } else if(estacion.toLowerCase() == "otoño"){
            raciones = Math.round(2 * PronosticoTemperatura + 15*(1-ProbabilidadLluvia))
        }else if(estacion.toLowerCase() == "invierno"){
            raciones = Math.round(0.5 * PronosticoTemperatura + 5*(1-ProbabilidadLluvia))
        } else if(estacion.toLowerCase() == "primavera"){
            raciones = PronosticoTemperatura + 15*(1-ProbabilidadLluvia)
        }
    } else if(ProbabilidadLluvia >= 0.5){
        if(estacion.toLowerCase() == "verano"){
            raciones = Math.round(2*PronosticoTemperatura + 20* (1-ProbabilidadLluvia))
        } else if(estacion.toLowerCase() == "otoño"){
            raciones = Math.round(PronosticoTemperatura + 10* (1-ProbabilidadLluvia))
        }else if(estacion.toLowerCase() == "invierno"){
            raciones = Math.round(0.5*PronosticoTemperatura)
        } else if(estacion.toLowerCase() == "primavera"){
            raciones = Math.round(PronosticoTemperatura + 10*(1-ProbabilidadLluvia))
        }
    }

    return raciones
}

//solucion refactorizada
def nueva (String estacion, int pronosticoTemperatura, float probabilidadLluvia){

    int raciones = 0

    switch(estacion.toLowerCase()){

        case "verano":
            if(probabilidadLluvia <0.5){ raciones = Math.round(3* pronosticoTemperatura + 20*(1-probabilidadLluvia))}
            else { raciones = Math.round(2* pronosticoTemperatura + 20*(1-probabilidadLluvia))}
            break

        case "otoño":
            if(probabilidadLluvia <0.5){raciones = Math.round(2* pronosticoTemperatura + 15*(1-probabilidadLluvia))}
            else { raciones = Math.round(1* pronosticoTemperatura + 10*(1-probabilidadLluvia))}
            break

        case "invierno":
            if(probabilidadLluvia < 0.5){raciones =  Math.round(0.5 * pronosticoTemperatura + 5*(1-probabilidadLluvia))}
            else { raciones =  Math.round(0.5 * pronosticoTemperatura)}
            break

        case "primavera":
            if(probabilidadLluvia < 0.5){ raciones =  Math.round(pronosticoTemperatura * 15*(1-probabilidadLluvia))}
            else {raciones =  Math.round(pronosticoTemperatura+ 10*(1-probabilidadLluvia))}
            break
    }
    return raciones
}


def RacionesDeRegalo(String estacion, int PorcionesPreparadas) {
    int divisor = switch (estacion.toLowerCase()) {
        case "verano" -> 10
        case "otoño" -> 8
        case "invierno" -> 5
        case "primavera" -> 7
    };

    Random randint = new Random()
    int maxRacionesDeRegalo = PorcionesPreparadas / divisor

    if (maxRacionesDeRegalo > 0) {
        return randint.nextInt(maxRacionesDeRegalo) + 1
    }
}


println("El kiwi del Mote con huesillos")
print("Estacion: ")
estacion = System.in.newReader().readLine()
for (int i = 1; i <= 7; i++){

    println("Día $i")
    print("Pronóstico de temperatura: ")
    int pronosticoTemp = System.in.newReader().readLine().toInteger()

    print("Probabilidad de lluvia: ")
    float probabilidadLluvia = System.in.newReader().readLine().toFloat()

    raciones = nueva(estacion, pronosticoTemp, probabilidadLluvia)
    regalo = RacionesDeRegalo(estacion,raciones)

    println("Se producirán $raciones raciones; se regalará $regalo para promoción")
}