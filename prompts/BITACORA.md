# Bitacora de tecnicas avanzadas

Laboratorio 07: Tecnicas Avanzadas de Prompting. Herramienta de IA usada: (escribe aqui cual usaste)

##	Ejercicio	2:	Zero-shot, one-shot y few-shot

| Criterio | Zero-shot | One-shot | Few-shot |
|---|---|---|---|
| Cantidad de ejemplos | 0 | 1 | 3 |
| Clasificaciones correctas | Positivo, Negativo, Neutral, Negativo, Positivo | Positivo, Negativo, Neutral, Negativo, Positivo | Positivo, Negativo, Neutral, Negativo, Positivo |
| Formato esperado | Lista de respuestas, posiblemente con explicaciones | Texto, flecha y clasificación | Texto, flecha y clasificación |
| Precisión esperada | 5 de 5 | 5 de 5 | 5 de 5 |
| Diferencia principal | La IA interpreta la tarea sin ejemplos. | La IA dispone de un modelo de respuesta. | La IA dispone de varios ejemplos para mantener el formato. |


##	Ejercicio	3:	Chain of Thought

### Tabla de resultados

| Aspecto | Pedido directo | Pedido paso a paso |
|---|---|---|
| Respuesta obtenida | S/ 318,60 | S/ 318,60 |
| ¿La respuesta fue correcta? | Sí | Sí |
| ¿Mostró los cálculos? | No | Sí |
| ¿Se pudo verificar el procedimiento? | No directamente | Sí |
| Observación | Presentó únicamente el resultado final. | Mostró las operaciones que permiten comprobar el resultado. |

### Comprobación de los cálculos

| Paso | Cálculo | Resultado |
|---|---|---|
| Precio con descuento | 120 × 0,75 | S/ 90,00 |
| Precio con IGV | 90 × 1,18 | S/ 106,20 |
| Total por 3 unidades | 106,20 × 3 | S/ 318,60 |

### Reflexión

Ver el procedimiento paso a paso permite comprobar que los cálculos sean correctos e identificar posibles errores en cada operación.

Aunque la respuesta directa sea correcta, mostrar los pasos facilita la comprensión del problema y genera mayor confianza en el resultado.

##	Ejercicio	4:	Role prompting

| Versión | Lenguaje utilizado | Nivel de detalle | Diferencias observadas |
|---|---|---|---|
| A. Sin rol | General y directo | Básico | Explica qué es una variable sin ejemplos específicos. |
| B. Rol docente | Sencillo y educativo | Intermedio | Utiliza una comparación con una caja para facilitar la comprensión. |
| C. Rol senior | Técnico y especializado | Avanzado | Emplea términos de programación e incluye un ejemplo en Java. |


##	Ejercicio	5:	Descomposicion


| Paso | ¿Qué entregó la IA? |
|---|---|
| Paso 1: Requisitos | Identificó cinco requisitos principales: registrar productos, modificar información, buscar productos, controlar entradas y salidas y generar alertas de stock mínimo. |
| Paso 2: Diseño de clases | Propuso tres clases: Producto, Inventario y MovimientoInventario, indicando sus atributos y tipos de datos. |
| Paso 3: Código Java | Generó el código de la clase Producto con atributos privados, constructor y métodos getters y setters. |
| Paso 4: Mejoras | Propuso tres mejoras: validar los datos, utilizar BigDecimal para los precios e implementar métodos para controlar el stock. |

### Comparación con el pedido de una sola vez

| Criterio | Pedido de una sola vez | Pedido por pasos |
|---|---|---|
| Resultado obtenido | La IA presentó una propuesta general de un sistema de inventario. | La IA desarrolló cada parte del sistema de forma organizada. |
| Requisitos | Mencionó funcionalidades básicas sin profundizar demasiado. | Identificó cinco requisitos específicos. |
| Diseño de clases | No detalló suficientemente las clases ni sus atributos. | Definió tres clases con sus atributos y tipos de datos. |
| Código Java | No presentó una implementación detallada de cada componente. | Generó el código completo de la clase Producto. |
| Mejoras | No incluyó una revisión específica del código. | Identificó tres mejoras concretas para el sistema. |
| Claridad | La respuesta fue general y menos estructurada. | Las respuestas fueron claras, específicas y fáciles de revisar. |


##	Ejercicio	6:	Prompt estructurado y autocritica

| Qué revisar | Cumple (Sí / No) |
|---|---|
| ¿Tiene las 4 columnas pedidas? | Sí |
| ¿Incluye el bloqueo después de 3 intentos? | Sí |
| ¿Incluye casos con campos vacíos? | Sí |
| ¿Indica qué casos agregó en la autocrítica? | Sí |
| ¿Hay algún caso repetido o que no tenga sentido? | No |

```text
Revisa críticamente la tabla de casos de prueba que acabas de generar. Identifica casos importantes que hayas omitido, especialmente validaciones de campos vacíos y formatos incorrectos. Agrega los casos que falten, conserva las 4 columnas originales e indica cuáles son nuevos. Evita casos repetidos o innecesarios.
```