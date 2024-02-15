## Tencnologías a usar:
- Java version: 17
- Maven: 4.0.0
- Spring Boot version: 3.2.2

## Problema de negocio
Problema de Negocio: Plataforma de Reservas de Clases Fitness

## Descripción:
Desarrollar una aplicación web para que usuarios puedan reservar clases de fitness en diferentes gimnasios y 
estudios de yoga de la ciudad. La plataforma debe gestionar las reservas, calcular tarifas según ciertas reglas 
de negocio y garantizar una experiencia intuitiva para los usuarios.

## Reglas de Negocio Principales:
* I) Gestión de Fechas y Disponibilidad:
   - Al solicitar una reserva, la plataforma debe calcular automáticamente la disponibilidad de la clase para la 
     fecha y hora seleccionadas. Si la clase ya está llena o se solapa con otra, se deben sugerir alternativas.
   - Las reservas solo pueden realizarse para fechas futuras. No se permiten reservas para clases pasadas.
   - Se debe asegurar que las reservas se realicen con al menos 6 horas de anticipación.
     
* II) Tarifas y Pagos:

   - El costo de la reserva varía según el tipo de clase, el horario y si la reserva cae en un día festivo.
   - Si la fecha de la reserva es un día festivo, se aplica un recargo del 50% sobre la tarifa estándar.
   - La plataforma debe calcular automáticamente el costo total de la reserva y ofrecer opciones de pago en línea.

* III) Usuarios y Roles:

**iscc**: identificador único de un libro (campo alfanumérico de máximo 10 dígitos)  
**identificacionUsuario**: número de la identificación del usuario (campo alfanumérico de maximo 10 digitos)  
**tipoUsuario**: determina la relación que tiene el usuario con la membresía, corresponde a un campo que puede tener solo alguno de los siguientes dígitos numérico


1. usuario premium
2. usuario regular
3. usuario clasico

## Objetivo
Crear una API tipo REST la cual permita llevar a cabo las siguientes funcionalidades
1. El Path debe ser `/reserva`  y el método HTTP tipo **POST**: permite crear una clase con las siguientes validaciones
  1. Un usuario clasico solo puede tener una clase en la semana, si un usuario clasico intenta reservar más de una clase debería retornar un error HTTP 400 con el siguiente json.  
     **Para verificar si un usuario ya tiene un préstamo se debe usar el campo _identificacionUsuario_**
      ```json
          {
           "mensaje" : "El usuario con identificación xxxxxx ya tiene una clase reservada por lo cual no se le puede realizar otra reserva"
          }
      ```       
     Donde **xxxxxx** corresponde a la identificación del usuario que intenta hacer la reserva
  2. Al momento de realizar la reserva se debe hacer el cálculo de la fecha para tomar clases, con la siguiente reglas de negocio
    1. Si la reserva lo hace un usuario tipo **premium** la fecha para tomar las clases debería ser la fecha actual más 7 días sin contar sábados y domingos
    2. Si el préstamo lo hace un usuario tipo **regular** la fecha para tomar las clases debería ser la fecha actual más 4 días sin contar sábados y domingos
    3. Si el préstamo lo hace un usuario tipo **clasico** la fecha para tomar las clases debería ser la fecha actual más 2 días sin contar sábados y domingos  
       **Esta fecha deberá ser almacenada en la base de datos junto con toda la información de la reserva**
  3. Si en el campo **tipoUsuario** llega un valor diferente a los permitidos, deberá retornar un un error HTTP 400 con el siguiente JSON
       ```json
           {
             "mensaje" : "Tipo de usuario no permitido en la biblioteca"
           }
       ```

## Servicios REST Transaccionales:

* Creación de Reservas: Permite a los usuarios crear nuevas reservas especificando la clase, fecha y hora.
* Cancelación de Reservas: Permite a los usuarios cancelar una reserva existente.

## Servicio REST de Consulta:

  - Listar Reservas Modificadas: Permite a los usuarios ver un historial de todas las reservas creadas o modificadas, incluyendo detalles como la fecha de la reserva, el usuario, la clase reservada y el costo total.

## Manipulación de Datos Persistentes:

La aplicación utilizará una base de datos para almacenar información sobre las clases disponibles, las reservas realizadas y los usuarios registrados.

## Interfaz Gráfica (Angular):

La interfaz de usuario permitirá a los usuarios interactuar con los servicios a través de un navegador web. Incluirá al menos dos vistas/rutas: una para la creación y gestión de reservas de clases, y otra para ver el historial de reservas. El enrutamiento será implementado con lazy loading para mejorar el rendimiento de la aplicación.