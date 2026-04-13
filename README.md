# prueba-hdi-olmos

La base de datos esta en Mysql 8.4 hay que crear la base de datos  y ahi ejecutar el script de 
"/DB/Dump20260412.sql"

El backend esta con Java SpringBoot, para ejecutarlo hay que correr la clase main "DemoAplication.java"
esto levanta el server por el puerto 8080, para configurar la conexion a la base
hay que mover el archivo "application.properties" en "src/main/resources" con las credenciales a la base nombrada 
y el servidor donde se encuentre

El frontend esta en Angular 20+ se levanta con "npm run start" y el puerto que levanta es el default 4200

