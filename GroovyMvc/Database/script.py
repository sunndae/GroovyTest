import random

def create_file():
    archivo = open("insert_notas_certamenes.psql", "w")

    ponderaciones = [20, 25, 30, 35]
    format_table = "INSERT INTO notas (id_alumno_ramo, tipo_nota, valor_nota, fecha_evaluacion, ponderacion) VALUES"
    script_line = archivo.write(format_table)
    for id_alumno_ramo in range(1, 241):  
        
        certamen_1 = f"({id_alumno_ramo}, 'Certamen 1', {random.randint(0, 100)}, '2024-{random.randint(3, 6)}-{random.randint(1, 28)}', {random.choice(ponderaciones)})"
        
        certamen_2 = f"({id_alumno_ramo}, 'Certamen 2', {random.randint(0, 100)}, '2024-{random.randint(3, 6)}-{random.randint(1, 28)}', {random.choice(ponderaciones)})"
        
        certamen_3 = f"({id_alumno_ramo}, 'Certamen 3', {random.randint(0, 100)}, '2024-{random.randint(3, 6)}-{random.randint(1, 28)}', {random.choice(ponderaciones)})"

        script_line = f"{certamen_1}, {certamen_2}, {certamen_3},\n"
        archivo.write(script_line)

    archivo.close()
    return "Archivo generado correctamente."

print(create_file())
