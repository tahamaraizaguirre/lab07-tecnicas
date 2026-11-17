
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




## Versión 3: prompt final

### Prompt utilizado

```text
Actúa como un analista QA funcional especializado en pruebas de aplicaciones de escritorio desarrolladas en Java Swing.
Tu responsabilidad es diseñar casos de prueba verificables para el registro de productos.

TiendaTec es una aplicación de escritorio desarrollada en Java Swing para gestionar productos de una tienda.

El formulario de registro contiene:
- Código: obligatorio, único y sin espacios en blanco como único contenido.
- Nombre: obligatorio y no puede contener solamente espacios.
- Precio: numérico y estrictamente mayor que cero.
- Stock: número entero igual o mayor que cero.

Para esta actividad, considera que el sistema debe rechazar registros que incumplan estas reglas.

Genera casos de prueba funcionales para verificar el registro de productos de TiendaTec.

Utiliza estos ejemplos como referencia:

Ejemplo 1:
ID: CP01
Escenario: Registro válido
Datos de entrada: P001, Teclado, 50.00, 10
Resultado esperado: El producto se registra correctamente.

Desarrolla la tarea en las siguientes etapas:

1. Identifica las reglas de validación de cada campo.
2. Clasifica los escenarios en válidos, inválidos y casos límite.
3. Genera al menos diez casos de prueba diferentes.
4. Incluye situaciones de campos vacíos, códigos duplicados, precios inválidos, stock negativo y valores límite.
5. Organiza todos los casos en una tabla Markdown.
6. Revisa críticamente los casos generados e identifica posibles validaciones omitidas.
7. Incorpora los casos faltantes que sean relevantes y señala cuáles fueron agregados.
8. Verifica que no existan pruebas duplicadas ni contradicciones con las reglas.

Presenta la respuesta en este orden:

1. Una breve descripción del objetivo de las pruebas.
2. Una tabla Markdown con exactamente cuatro columnas:
   ID | Escenario | Datos de entrada | Resultado esperado
3. Una sección titulada "Autocrítica y mejoras", donde indiques:
   - Qué validaciones podrían haberse omitido.
   - Qué casos adicionales se incorporaron.
   - Si existen limitaciones o supuestos.

Evita explicaciones extensas.
No inventes funcionalidades adicionales del sistema.
</formato>
```

### Técnicas agregadas

**1. Few-shot prompting:** Se incorporan tres ejemplos concretos de casos de prueba para mostrar el estilo y nivel de detalle esperado.

**2. Prompt estructurado:** Se organiza la solicitud mediante etiquetas que separan el rol, contexto, tarea, ejemplos, procedimiento y formato.

**3. Autocrítica:** Se solicita que la IA revise sus propios resultados, identifique posibles omisiones e incorpore casos faltantes.


### ¿Por qué se agregaron estas técnicas?

Few-shot permite mostrar ejemplos para orientar la respuesta hacia un formato consistente. El prompt estructurado evita mezclar instrucciones y facilita diferenciar el contexto de las reglas de trabajo. La autocrítica permite realizar una revisión adicional y mejorar la cobertura de las pruebas.

### Autocrítica y mejoras

Al revisar los casos iniciales, se identificaron posibles omisiones relacionadas con los tipos de datos y los campos obligatorios.

Como mejora, se incorporaron los casos **CP09, CP10, CP11 y CP12**, que permiten comprobar el ingreso de texto en un campo numérico, un stock decimal y campos completados únicamente con espacios.

Estos casos amplían la cobertura respecto a las versiones anteriores.


### ¿Qué mejoró respecto a la versión 2?

La versión final proporciona instrucciones más completas, ejemplos claros y una revisión crítica de las pruebas generadas.

Además, incorpora situaciones que no estaban contempladas en la segunda versión, aumentando la cobertura de validaciones y mejorando la utilidad del resultado para el proceso de pruebas de software.

---

## Técnicas usadas en el prompt final

| Técnica | Parte del prompt final | Finalidad |
|---|---|---|
| Role prompting | Etiqueta `<rol>` | Establecer el perfil de analista QA funcional especializado en Java Swing |
| Few-shot prompting | Etiqueta `<ejemplos>` | Mostrar tres ejemplos del formato y contenido esperado |
| Descomposición | Etiqueta `<procedimiento>`, pasos 1 al 5 | Dividir la generación de pruebas en actividades ordenadas |
| Prompt estructurado | Etiquetas `<rol>`, `<contexto>`, `<tarea>`, `<ejemplos>`, `<procedimiento>` y `<formato>` | Separar las instrucciones y facilitar su interpretación |
| Autocrítica | Etiqueta `<procedimiento>`, pasos 6 al 8 | Revisar la calidad de las pruebas e identificar omisiones |

El prompt final combina cinco técnicas de prompting, superando el mínimo de tres técnicas solicitado en el laboratorio.

---

## Evaluación del resultado

Se realizó una evaluación de referencia del conjunto final de casos de prueba.

| Criterio de evaluación | Cumple (Sí / No) |
|---|---|
| ¿La respuesta presenta una tabla con las cuatro columnas solicitadas? | Sí |
| ¿Se incluyen al menos diez casos de prueba? | Sí |
| ¿Se contemplan registros válidos e inválidos? | Sí |
| ¿Se verifica que no existan códigos duplicados? | Sí |
| ¿Se incluyen validaciones para precios y stock? | Sí |
| ¿Se consideran casos límite como stock igual a cero? | Sí |
| ¿Se realiza una revisión crítica de los resultados? | Sí |
| ¿Se incorporan casos adicionales para mejorar la cobertura? | Sí |

### Comparación de las tres versiones

| Aspecto evaluado | Versión 1 | Versión 2 | Versión 3 |
|---|---|---|---|
| Rol específico | No | Sí | Sí |
| Reglas de validación detalladas | No | Sí | Sí |
| Formato de tabla definido | No | Sí | Sí |
| Ejemplos de referencia | No | No | Sí |
| Descomposición de tareas | No | Sí | Sí |
| Autocrítica | No | No | Sí |
| Cobertura esperada | Básica | Intermedia | Ampliada |

### Observaciones

La primera versión deja mayor libertad a la IA, mientras que la segunda establece reglas y un formato específico. La tercera incorpora ejemplos y una etapa de revisión que ayuda a detectar casos omitidos.

También se observa que un prompt más detallado no garantiza por sí solo que el sistema funcione correctamente. Los casos generados deben contrastarse con los requerimientos y ejecutarse en la aplicación.

---

## Por qué elegí estas técnicas

Elegí las técnicas de role prompting, few-shot, descomposición, prompt estructurado y autocrítica porque se complementan para desarrollar casos de prueba de software. El rol permite obtener respuestas orientadas al aseguramiento de calidad, mientras que los ejemplos ayudan a mantener un formato consistente. La descomposición organiza el trabajo en etapas y el prompt estructurado separa claramente las instrucciones. Finalmente, la autocrítica permite identificar omisiones y ampliar la cobertura de las pruebas. 

---