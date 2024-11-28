 /*

Las clases en groovy se defininen de la misma
manera que en java, solamente que es un poco
mas legible y facil de entender el codigo (dicen)
*/


class Estudiante {

    String nombre
    String carrera
    int edad

    def Estudiante(nombre, carrera, edad){

        this.nombre = nombre
        this.carrera = carrera
        this.edad = edad
    }

    // el anotacion @override sirve para indicar que un metodo de una clase
    // que hereda de otra clase debe ser sobreescrito (reimplementado)
    // en este caso, el metodo tostring() se sobreescribe para que retorne un string con los datos del estudiante
    @override
    def tostring(){
        return "Nombre: $nombre, Carrera: $carrera, Edad: $edad"
    }





}