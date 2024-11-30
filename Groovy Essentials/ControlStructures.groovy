// Este codigo tiene la finalidad de entender las estructuras de control
// que maneja groovy para tener una idea mas clara.

// input en groovy por consola

//print("Ingresa tu nombre: ")
//nombre = System.in.newReader().readLine()
nombre = ""

if (nombre.toLowerCase() == "tomas"){
    println("hola! $nombre")
}else if (nombre.toLowerCase() == "Ignacio"){
    println("hola! $nombre")
}else {
    println("No se quien eres :(")
}

// asi funciona un swictch case en groovy

print("¿Que dia de la semana es?: ")
String diaDeSemana = System.in.newReader().readLine()

switch (diaDeSemana.toLowerCase()){

    case "lunes":
        println("Hoy es lunes, toca programar en java para el proyecto")
        break
    case "martes":
        println("Hoy es chill, toca gestión de proyectos")
        break
    case "miercoles":
        println("Hoy es miercoles, toca emilio y visualizacion")
        break
    case "jueves":
        println("Dia libre")
        break
    case "viernes":
        println("Hoy es viernes, toca TAS")
        break

}

// TODO: hacer un ejercicio que combine todo esto
// suggest: hacer las UVAS de progra para practica logica de progamacion