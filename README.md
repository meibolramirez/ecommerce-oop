# Aplicación de comercio electrónico basada en Java (CLI)
  
Este proyecto consiste en una aplicación de comercio electrónico desarrollado con Java y principios de programación orientada a objetos (POO). El sistema admite funciones básicas de comercio electrónico, como la creación de usuarios, la gestión de productos y la gestión del carrito de compra a ejecutarse a través de la consola.

*BIU-CSE641-Spring25*

## Tecnologías utilizadas
- Java
- Maven
- Eclipse IDE
- GitHub para control de versiones

## Funcionalidades implementadas

### Creación de clases
**SEM2**
- **Clase de producto**: Gestiona atributos como ID, nombre, descripción, precio y stock.
- **Clase de usuario**: Almacena datos del usuario, como ID, nombre, correo electrónico y contraseña.
- **Clase de carrito**: Gestiona una lista de productos seleccionados y calcula el total.

### Extensión de clases por herencia
**SEM3**
- **Clase Producto**
  - **Clase de producto digital:** Incluye atributos adicionales como fileFormat y fileSize para describir productos digitales.
  - **Clase de prodcuto físico:** Añade weight y dimensions para productos físicos.

Ambas clases extienden la clase base Product, reutilizando sus atributos y métodos, y añadiendo información específica para su tipo.

- **Clase Usuario**
  - **Clase de cliente:** Incluye atributos como purchaseHistory y preferences, simulando una experiencia personalizada para el usuario final.
  - **Clase de administrador:**  Añade métodos administrativos como manageInventory() y setPromotion(), permitiendo gestionar el inventario y aplicar promociones dentro del sistema.

Estas extensiones utilizan herencia para separar responsabilidades según el rol del usuario.

## Cómo ejecutar el proyecto
1. Clonar el repositorio:
```bash
git clone https://github.com/meibolramirez/ecommerce-oop.git
```
2. Importar el proyecto Maven a Eclipse:
```
Archivo > Importar > Proyectos Maven existentes
```
Seleccionar la carpeta raíz
Compilar y ejecutar:
Abrir Main.java
```
Clic derecho>Ejecutar como > Aplicación Java
```
# Autoría
Mabel Ramírez <br>
ramirezarias.mabel@gmail.com
