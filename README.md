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

### Polimorfismo, Sobrecarga & Sobreescritura 
**SEM 4**

**Sobrecarga de la clase Cart**
- La clase Cart se actualizó para gestionar la adición de productos con diferentes firmas de constructor.
- Sobrecarga de métodos: El método addProduct() se sobrecargó para permitir la adición de productos de varias maneras:
  - Pasando un objeto Product.
  - Pasando detalles individuales del producto (id, nombre, descripción, precio, stock).
  - Pasando el nombre y el precio de un producto, con los demás atributos predeterminados.

Estos métodos sobrecargados ofrecen flexibilidad al añadir productos al carrito de compra.

**Actualizaciones del constructor en el carrito**
 - El método `addProduct(int id, String name, String description, double price, int stock, String fileFormat, double fileSize)` ahora crea correctamente instancias de `DigitalProduct`.
 - El método `addProduct(int id, String name, String description, double price, int stock, double weight, String dimensions)` crea instancias de `PhysicalProduct`.

**Polimorfismo**
- La clase Cart ahora puede gestionar diversos objetos Producto, lo que permite almacenar tanto el ProductoFísico como el ProductoDigital en la misma lista de tipo Producto.
- El método displayDetails(), que es polimórfico, se llama para cada producto del carrito, mostrando un comportamiento polimórfico donde el tipo de producto determina cómo se muestran sus detalles.

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
