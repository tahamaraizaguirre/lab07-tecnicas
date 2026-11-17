
# Tarea: Mi prompt avanzado

## Tarea elegida

Registro de productos de **TiendaTec**, una aplicación de escritorio desarrollada en Java para gestionar los productos de una tienda.

---

## Versión 1: prompt básico

### Prompt utilizado

```text
Genera casos de prueba para el registro de productos de una aplicación de escritorio desarrollada en Java llamada TiendaTec.

Los productos tienen código, nombre, precio y stock.
```

### Técnica utilizada

**Zero-shot prompting:** se presenta una solicitud directa sin proporcionar ejemplos, roles específicos ni una estructura obligatoria de respuesta.

### ¿Por qué se utilizó?

Se utilizó como punto de partida para observar cómo la inteligencia artificial interpreta una solicitud general y qué información proporciona sin instrucciones adicionales.

### Resultado 

La IA genero pruebas generales:

1. Registrar un producto con datos correctos.
2. Registrar un producto con el nombre vacío.
3. Registrar un producto con un precio negativo.
4. Registrar un producto con stock negativo.
5. Registrar un producto con código duplicado.

### ¿Qué se observó?

La respuesta inicial permite identificar algunos escenarios importantes. Sin embargo, al no definir un formato de presentación ni las reglas completas del registro, los resultados pueden ser generales e incompletos.

**Limitación identificada:** No se establece una estructura uniforme, no se especifican los resultados esperadoa

---


## Versión 2: prompt mejorado

### Prompt utilizado

```text
Actúa como un analista de aseguramiento de calidad (QA) especializado en aplicaciones de escritorio desarrolladas en Java Swing.

Necesito diseñar casos de prueba funcionales para el módulo de registro de productos de TiendaTec.

El registro tiene los siguientes campos:
- Código: obligatorio y único.
- Nombre: obligatorio.
- Precio: numérico y mayor que cero.
- Stock: número entero igual o mayor que cero.

Desarrolla la tarea siguiendo estos pasos:

1. Identifica las validaciones necesarias para cada campo.
2. Determina escenarios de registro exitoso y fallido.
3. Genera ocho casos de prueba funcionales.
4. Organiza los resultados en una tabla Markdown.

La tabla debe tener exactamente cuatro columnas:
ID | Escenario | Datos de entrada | Resultado esperado

Utiliza lenguaje técnico claro y resultados verificables.
```

### Técnicas agregadas

**1. Role prompting:** Se asigna el rol de analista QA especializado en aplicaciones Java Swing.

**2. Descomposición de tareas:** Se divide la solicitud en etapas: identificar validaciones, determinar escenarios y elaborar casos de prueba.

**3. Formato de salida definido:** Se solicita una tabla Markdown con cuatro columnas específicas.

### ¿Por qué se agregaron?

El rol permite orientar la respuesta hacia el aseguramiento de calidad del software. La descomposición facilita organizar el trabajo y reduce la posibilidad de omitir validaciones. El formato definido mejora la presentación y comparación de los resultados.

### Resultado

| ID | Escenario | Datos de entrada | Resultado esperado |
|---|---|---|---|
| CP01 | Registro válido | P001, Teclado, 50.00, 10 | Producto registrado correctamente |
| CP02 | Código vacío | "", Mouse, 30.00, 5 | Mostrar error por código obligatorio |
| CP03 | Nombre vacío | P002, "", 40.00, 8 | Mostrar error por nombre obligatorio |
| CP04 | Precio negativo | P003, Monitor, -500.00, 3 | Rechazar el precio negativo |


### ¿Qué mejoró respecto a la versión 1?

La segunda versión establece reglas concretas, presenta resultados esperados y organiza los casos de prueba en una tabla uniforme.

También diferencia claramente entre registros válidos e inválidos. Esto facilita comprobar si el sistema cumple los requerimientos establecidos.

**Limitación identificada:** Aunque la respuesta está organizada, todavía pueden omitirse situaciones especiales, como ingresar letras en el precio, valores decimales en el stock o campos que contengan solamente espacios.

---