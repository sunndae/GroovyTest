// Este codigo tiene la finalidad de entender las estructuras de control
// que maneja groovy para tener una idea mas clara.

// input en groovy por consola

print("Ingresa tu nombre: ")
nombre = System.in.newReader().readLine()

if (nombre.toLowerCase() == "tomas"){
    println("hola! $nombre")
}else if (nombre.toLowerCase() == "Ignacio"){
    println("hola! $nombre")
}else {
    println("No se quien eres :(")
}


