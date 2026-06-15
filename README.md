# 🛒 ShopConnect V2 - Arquitectura de Microservicios

**Estudiante:** johana manriquez 
**Repositorio:** https://github.com/johanamanriquez1994-tech/ShopConnect-V2

---

##  Pasos para ejecutar el proyecto (Guía para el Profesor)

Para que el proyecto funcione en su equipo, siga estas instrucciones:

1. **Clonar el proyecto:**
   `git clone https://github.com/johanamanriquez1994-tech/ShopConnect-V2.git`

2. **Levantar contenedores:**
   En la carpeta raíz, ejecute:  
   `docker-compose up --build`

3. **Base de Datos Oracle:**
   Se configuró el puerto **1522** para evitar conflictos. El sistema conectará automáticamente.

4. **Ver documentación Swagger:** Una vez que Docker esté en verde, entre aquí:  
   [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---


## Evidencias de Respaldo

(En caso de que no desee instalar Docker, aquí están las pruebas de que el sistema funciona)

###  Docker Desktop Operativo
![Docker General](evidencias/1-docker-general-ok.png)

###  Swagger de Microservicios

* **Microservicio de Inventario (Puerto 8082):**
![Inventario](evidencias/2-ms-inventario-puerto-8082.png)

* **Microservicio de Productos (Puerto 8081):**
![Productos](evidencias/3-ms-productos-puerto-8081.png)

* **Microservicio de Pedidos (Puerto 8083):**
![Pedidos](evidencias/4-ms-pedidos-puerto-8083.png)

* **Microservicio de Pagos (Puerto 8084):**
![Pagos](evidencias/5-ms-pagos-puerto-8084.png)

* **Microservicio de Usuarios (Puerto 8085):**
![Usuarios](evidencias/6-ms-usuarios-puerto-8085.png)