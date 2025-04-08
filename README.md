# ToDo
- [ ] Diagrama de clases
- [ ] Funcionalidades
  - [ ] Tabla de visualización de inventario
  - [ ] Control de suscripciones de afiliados
  - [ ] Control de horarios de los empleados
  - [ ] Programación de mantenimientos y limpiezas
  - [ ] Seguimiento de rutinas
- [ ] Interfaz gráfica

# Idea
Desarrollar un proyecto usando Java y Java Swing para la administración de un sistema basado en el servicio de un gimnasio.

# Problemática a resolver
Un gimnasio local desde el inicio del año actual aumentó el volumen de personas que usan las instalaciones a diario, en consecuencia, el gimnasio tiene problemáticas para:
- Llevar el manejo del inventario de los elementos del gimnasio (pesas, colchonetas, tapetes, etc)
- El manejo del personal para asistir a los usuarios
- Los turnos de limpieza de las instalaciones
- El seguimiento del mantenimiento de las máquinas por parte de contratistas
- Llevar el registro de las mensualidades de los afiliados
- Ayudar a los afiliados a llevar sus rutinas

#  Explicación del código
El código del proyecto se encuentra bajo la ruta [gym](./src/local/gym), dentro de esta se encuentran los paquetes `application`, `views`, `models`, y `controllers`, esto siguiendo con la arquitectura MVC para el manejo de los datos.

## Application
Dentro del paquete `application` se encuentra el punto de entrada de la aplicación donde se hace el llamado de la primera interfaz gráfica.

## Views
Dentro del paquete `views` se encuentran las definiciones de las clases de las interfaces gráficas que cargan los datos de los controladores.

## Models
Dentro del paquete `models` se encuentran las definiciones de las clases con los constructores de cada tipo de dato necesario para la aplicación.

## Controllers
Dentro del paquete `controllers` se encuentran las definiciones de las clases con las operaciones de `CREATE`, `READ`, `UPDATE` y `DELETE` de cada modelo.

# Diagrama de clases
ToDo
