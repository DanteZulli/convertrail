## Explicación sobre el template para configurar el API Client de CONVERTRAIL
Convertrail configura su cliente de API vía un archivo "Config.json".
Este debe ser definido antes de comenzar. Sinó Convertrail no funcionará.<br>
Se detalla a continuación las características que debe poseer cada parámetro, por si poseen dudas.
### Parámetros
- <i>url</i><br>
En el parámetro "url" se debe ingresar el EndPoint de la API a consumir. <b>Debe ser un String (Cadena de caracteres delimitada por "")</b><br>
Ejemplo: ".../api.convertrail/api/v2/"
- <i>method</i><br>
En el parámetro method se debe ingresar el método a ejecutar.<b>Debe ser un String (Cadena de caracteres delimitada por "")</b>
<br>Solo se aceptan 4 opciones: "GET", "POST", "PUT", "DELETE"
- <i>timer</i><br>
El parámetro "timer" actúa como temporizador, definiendo el retardo entre ejecución y ejecucón de la consulta a la API. Se define en segundos<b>Debe ser un Int (Entero) positivo</b><br>
Ejemplo: 5 --> 5 Segundos<br>
Nota: Si deseas desactivar el "timer", deberás ingresar el número 0 (cero).
- <i>result</i> <br>
Es un parámetro de SI/NO. Define si se desea guardar el archivo de resultado convertido en formato JSON luego de enviar la consulta.<b>Debe ser un Boolean (Booleano true/false)</b>
- <i>log</i> <br>
Es un parámetro de SI/NO. Define si se desea una salida en consola a modo de "log" de la petición realizada.
<b>Debe ser un Boolean (Booleano true/false)</b>
