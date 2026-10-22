# Proyecto UT3: Reloj Podómetro

Enunciado del proyecto individual para modelar un podómetro que registra los
pasos, la distancia recorrida y el tiempo caminado durante una semana.

## Objetivos

Practicar cómo:

- Definir y utilizar constantes y atributos (variables de instancia) en una clase.
- Definir constructores y utilizar parámetros en constructores y métodos.
- Definir métodos accesores y mutadores.
- Utilizar sentencias de asignación y escritura.
- Construir sentencias `if` y `switch`.
- Expresar el algoritmo correspondiente a un método.
- Usar operadores aritméticos y relacionales.
- Usar métodos de la clase `Math`.

## Antes de empezar

El ejercicio se realiza individualmente. El proyecto de partida está en
[UD3-PROY-Reloj-pasos](https://github.com/marce-profe/UD3-PROY-Reloj-pasos).

1. Clona el proyecto en tu PC desde BlueJ. La rama principal se llama `main`.
3. Completa el proyecto guardando tu trabajo con commits paulatinamente.
4. Comprime la carpeta completa del proyecto, (con la carpeta git oculta incluida) y súbela al aula virtual para hacer la entrega.

Se valorará que el programa esté probado (que compile y se ejecute correctamente)
y que esté claramente escrito y organizado: respeta las reglas de estilo de Java,
utiliza nombres descriptivos y evita duplicar código.

**La fecha límitede entrega es el lunes 2 de noviembre a las 23:30.**

La corrección se anulará y el ejercicio se evaluará con un 0 si se detecta que
se ha copiado o se ha dejado copiar a otro compañero. También se penalizará no
seguir las normas de entrega.

El profesorado podrá convocar al alumno o alumna para defender oralmente el
proyecto.

## Especificaciones

Completa únicamente la clase `Podometro`. No modifiques `DemoPodometro`: sirve
para probar la clase. Escribe tu nombre después de la etiqueta `@author`.

### Constantes y atributos

Define en `Podometro` las siguientes constantes, deduciendo los tipos de datos
adecuados:

| Nombre | Valor | Descripción |
| --- | --- | --- |
| `HOMBRE` | `'H'` | Sexo hombre |
| `MUJER` | `'M'` | Sexo mujer |
| `RAZON_ZANCADA_HOMBRE` | `0.45` | Porcentaje de la altura usado para calcular la zancada de un hombre (45%)|
| `RAZON_ZANCADA_MUJER` | `0.41` | Porcentaje de la altura usado para calcular la zancada de una mujer (41%)|
| `SABADO` | `6` | Número del día sábado |
| `DOMINGO` | `7` | Número del día domingo |

Define también **solo** estos atributos, respetando sus nombres:

| Atributo | Información almacenada |
| --- | --- |
| `marca` | Marca del podómetro |
| `altura` | Altura de la persona, en centímetros, sin decimales |
| `sexo` | Sexo de la persona, representado por un carácter (ver constantes) |
| `longitudZancada` | Longitud de la zancada, en centímetros, sin decimales |
| `totalPasosLaborables` | Pasos dados de lunes a viernes |
| `totalPasosSabado` | Pasos dados el sábado |
| `totalPasosDomingo` | Pasos dados el domingo |
| `totalDistanciaSemana` | Distancia recorrida durante toda la semana (de lunes a domingo), en kilómetros (con decimales) |
| `totalDistanciaFinSemana` | Distancia recorrida durante el fin de semana (sábado o domingo), en kilómetros (con decimales) |
| `tiempo` | Tiempo total caminado durante la semana, en minutos |
| `caminatasNoche` | Caminatas realizadas a partir de las 21 h a lo largo de toda la semana |

No incluyas otros atributos.

### Métodos
Completa los siguientes métodos:

#### Constructor y accesor del atributo marca

- El constructor recibe como parámetro el nombre de la marca del podómetro.
  Inicializa el resto de atributos a `0`, excepto `sexo`, que comienza con el
  valor `MUJER`.
- Implementa el accesor `getMarca()` para obtener la marca.

---
#### Método `void configurar(double queAltura, char queSexo)`

Simula la configuración del podómetro: asigna la altura y el sexo recibidos y
calcula `longitudZancada` en centímetros.

- Para hombres, la zancada es el 45 % de la altura, **redondeado siempre hacia
  arriba**.
- Para mujeres, es el 41 % de la altura, **redondeado siempre hacia abajo**.
- Busca en la clase `Math` los métodos adecuados para redondear.
---
#### Método `void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin)`

Recibe cuatro parámetros que supondremos correctos (no es necesario validarlos):

- `pasos`: número de pasos caminados.
- `dia`: número del día de la semana (1 para lunes, 2 para martes, ..., 6 para
  sábado y 7 para domingo).
- `horaInicio` y `horaFin`: hora de inicio y de fin, expresadas como un entero
  de HASTA cuatro dígitos. Los dígitos más significativos indican la hora y los
  dos menos significativos, los minutos. Por ejemplo, `1425` representa las
  14:25, `654` las 06:54 y `1005` las 10:05.

Por simplicidad, cada caminata empieza y acaba el mismo día (no puede empezar un dia dado y acabar al día siguiente). 

Por ejemplo:

- `registrarCaminata(2000, 3, 1730, 1815)` representa 2000 pasos el miércoles,
  de 17:30 a 18:15.
- `registrarCaminata(8500, 6, 715, 950)` representa 8500 pasos el sábado,
  de 7:15 a 9:50.

A partir de estos parámetros el método debe hacer cálculos para actualizar el estado del podómetro adecuadamente: 

 - Qué atributos debe actualizar? `totalDistanciaSemana`, `tiempo`, `caminatasNoche`, etc... 
 - La distancia recorrida en una caminata son los pasos dados por la longitud de la zancada. 
 - Utiliza una sentencia
`switch` para analizar el día
- evita repetir código.
---
#### Método `printConfiguración()`

Muestra la configuración del podómetro (altura, sexo y longitud de la zancada). **Ojo a las unidades**.

El formato de referencia es:

```text
Configuración del podómetro
*********************************
Altura: 1.57 metros
Sexo: MUJER
Longitud zancada: 0.64 metros
```
---
#### Método `printEstadísticas()`

Muestra información sobre distancias, pasos, caminatas y tiempo total caminado... 

Formato de referencia:

```text
Estadísticas
*********************************
Distancia recorrida toda la semana: 48.1152 Km
Distancia recorrida fin de semana: 20.48 Km

Nº pasos días laborables: 43180
Nº pasos SÁBADO: 17000
Nº pasos DOMINGO: 15000

Nº caminatas realizadas a partir de las 21h.: 3

Tiempo total caminado en la semana: 11h y 48m
Día/s con más pasos caminados: LABORABLES
```
---
#### Método `diaMayorNumeroPasos()`
Devuelve el nombre del día o periodo en el que se han caminado más pasos con una cadena de entre las siguientes:
`"SÁBADO"`, `"DOMINGO"` o `"LABORABLES"`. Puede haber coincidencias (separad con un espacio en ese caso los textos).

---
#### Método `reset()`

Restablece los valores iniciales del podómetro: todos los atributos vuelven a
cero, excepto `sexo`, que vuelve a `MUJER`. La marca no cambia.

## Prueba del proyecto

Para probar que `Podometro` funciona correctamente, crea un objeto de la clase
`DemoPodometro` y llama al método `iniciar()`. 

Deberías obtener los resultados siguientes.

```text
********************************************
*******     Podómetro SMARTWALK     *******
********************************************

Configuración del podómetro
********************************
Altura: 1.57 mtos
Sexo: MUJER
Longitud zancada: 0.64 mtos

Estadísticas
********************************
Distancia recorrida toda la semana: 48.1152 Km
Distancia recorrida fin de semana: 20.48 Km

Nº pasos días laborables: 43180
Nº pasos SÁBADO: 17000
Nº pasos DOMINGO: 15000

Nº caminatas realizadas a partir de las 21h.: 3

Tiempo total caminado en la semana: 11h y 48m
Día/s con más pasos caminados: LABORABLES

Pulse <Intro> para continuar
```

```text
********************************************
*******     Podómetro SMARTWALK     *******
********************************************

Configuración del podómetro
********************************
Altura: 1.85 mtos
Sexo: HOMBRE
Longitud zancada: 0.84 mtos

Estadísticas
********************************
Distancia recorrida toda la semana: 16.665599999999998 Km
Distancia recorrida fin de semana: 5.04 Km

Nº pasos días laborables: 13840
Nº pasos SÁBADO: 0
Nº pasos DOMINGO: 6000

Nº caminatas realizadas a partir de las 21h.: 2

Tiempo total caminado en la semana: 6h. y 35m.
Día/s con más pasos caminados: LABORABLES
```

```text
********************************************
*******     Podómetro SMARTWALK     *******
********************************************

Configuración del podómetro
********************************
Altura: 1.65 mtos
Sexo: MUJER
Longitud zancada: 0.67 mtos

Estadísticas
********************************
Distancia recorrida toda la semana: 5.1255 Km
Distancia recorrida fin de semana: 3.1155 Km

Nº pasos días laborables: 3000
Nº pasos SÁBADO: 1650
Nº pasos DOMINGO: 3000

Nº caminatas realizadas a partir de las 21h.: 2

Tiempo total caminado en la semana: 5h. y 30m.
Día/s con más pasos caminados: LABORABLES DOMINGO
```
```text
********************************************
*******     Podómetro SMARTWALK     *******
********************************************

Configuración del podómetro
********************************
Altura: 1.9 mtos
Sexo: HOMBRE
Longitud zancada: 0.86 mtos

Estadísticas
********************************
Distancia recorrida toda la semana: 5.16 Km
Distancia recorrida fin de semana: 3.44 Km

Nº pasos días laborables: 2000
Nº pasos SÁBADO: 2000
Nº pasos DOMINGO: 2000

Nº caminatas realizadas a partir de las 21h.: 0

Tiempo total caminado en la semana: 4h. y 45m.
Día/s con más pasos caminados: LABORABLES  SABADO  DOMINGO
```

## Rúbrica de evaluación

| Criterio | Puntuación |
| --- | ---: |
| Constantes y atributos | 5,10 |
| Constructor | 4,00 |
| Accesor | 4,00 |
| `configurar` | 8,00 |
| `registrarCaminata` | 40,00 |
| `printConfiguracion` | 6,00 |
| `printEstadisticas` | 8,9 |
| `diaMayorNumeroPasos` | 15,00 |
| `reset` | 3,00 |
| Buen estilo de programación | 6 |
| **Total** | **100** |

Si el programa no compila, se aplica una penalización de **-0,5 sobre 10**.

