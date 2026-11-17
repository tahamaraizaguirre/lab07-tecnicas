
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
