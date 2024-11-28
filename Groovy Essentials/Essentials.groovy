
// Como recorrer un string en groovy
texto = "esto es una prueba";

// 1. ciclo for
println("Ciclo for")
for(int i = 0; i < texto.length(); i++){
    println(texto[i])
};

// 2. ciclo while
int contador = 0;
println("Ciclo while")
while(contador < texto.length()){
    println(texto[contador])
    contador++
}

// como recorrer un array de cosas en groovy
lista = ["tomas", "Dismar", "null"]

for (item in lista){
    println(item);
}

