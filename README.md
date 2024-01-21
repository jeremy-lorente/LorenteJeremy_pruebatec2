# LorenteJeremy_pruebaTec1

 ## Objetivo
> [!NOTE]
> El objetivo de esta prueba es evaluar tus conocimientos en Java y Java Web, incluyendo sintaxis, estructuras repetitivas, estructuras selectivas, manejo de colecciones y operaciones CRUD (Crear, Leer, Actualizar y Borrar) utilizando JPA (Java Persistence API)  para interactuar con una base de datos, JSP para interactuar con el usuario y programación funcional como complemento.


## Iniciación proyecto
> [!IMPORTANT]
> - Clonar repositorio
> - Abrir en Netbeans
> - Abrir gestor de base de Datos (XAMPP en mi caso)
> - Tener descargado apache-tomcat 9.0.85 (Versiones inferiores podrian provocar fallos)
> - Crear la base de datos con el SQL facilitado en: [Abrir carpeta](https://github.com/jeremy-lorente/LorenteJeremy_pruebatec2/tree/main/src/main/java/sql)
> - Ejecutar 

## Usos
> [!NOTE]
> - Ejecute el programa y mostrara una web en su navegador con 3 opciones en la parte superior:
>    - Inicio:
>      - Permite la creación de nuevas personas en la base de datos.
>      - Permite la eliminacion de las personas en base a su dni.  
>    - Gestiones:
>      - Permite crear nuevos tipos de gestiones en la base de datos.
>      - Permite mostrar las gestiones mediante una tabla
>    - Turnos:
>      - Permite la creacion de nuevos turnos asociados a una persona y a un tipo de gestion
>      - Permite mostrar los turnos entre dos fechas
>      - Permite mostrar los turnos entre dos fechas y el estado en el que se encuentra ("En espera" y "Ya atendido")
>          - Dentro de ambas tablas, se permite eliminar el turno o editarlo. En caso de editarlo se abrira una nueva pestaña que permitira modificar el estado y la descripcion del turno.

## Casos Supuestos
> [!WARNING]
> - Usuario conoce el DNI:
>   - Al registrar un turno, se entiende que la persona que utiliza el programa conoce el dni de la persona a la que va asignar el turno.
>   - Al eliminar a una persona, se entiende que la persona que utiliza el programa conoce el dni de la persona a la que va asignar el turno.
## Documentación 
> [!NOTE]
> Las clases utilizadas han sido comentadas y se ha generado la javadoc en la carpeta: 
> [Abrir carpeta](https://github.com/jeremy-lorente/LorenteJeremy_pruebatec2/tree/main/target/site/apidocs)


