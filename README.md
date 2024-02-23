# APIRestSpringBootMuseo
## Recursos 📂
Para crear está API me he basado en una base de datos sobre museos. Hay dos tablas, la tabla museos y la tabla cuadros ya que un museo puede tener varios cuadros.
### La tabla de museos tiene los siguientes atributos:
- Id (Long)
- Nombre (String)
- Ubicación (String)
- Horario (String)
- Precio (Double)
- Código (Integer)
- Web (String)
- Descripción (String)
- Cuadros (List<Cuadro>)
### La tabla de cuadros tiene los siguientes atributos:
- Id (Long)
- Nombre (String)
- Fecha (Integer)
- Autor (String)
- Museo (Museo)

## Endpoints 📌
### Endpoints para museos:
Parten de la raíz @RequestMapping("/api/museo"):

- @GetMapping("/") -> Devuelve todos los museos.
- @GetMapping("/id/{id}") -> Devuelve el museo con el id pasado como parámetro.
- @GetMapping("/nombre/{nombre}") -> Devuelve el museo con el nombre pasado como parámetro.
- @GetMapping("/ubicacion/{ubicacion}") -> Devuelve el museo con la ubicación pasada como parámetro.
- @GetMapping("/horario/{horario}") -> Devuelve el museo con el horario pasado como parámetro.
- @GetMapping("/precio/{precio}") -> Devuelve el museo con el precio de entrada pasado como parámetro.
- @GetMapping("/codigo/{codigo}") -> Devuelve el museo con el código postal pasado como parámetro.
- @GetMapping("/web/{web}") -> Devuelve el museo con la web pasada como parámetro.
- @GetMapping("/descripcion/{descripcion}") -> Devuelve el museo con la descripcion pasada como parámetro.
- @GetMapping("/gratis") -> Devuelve una lista con los museos que tienen la entrada gratis.
- @GetMapping("/nombres") -> Devuelve una lista con todos los nombres de los museos.
- @GetMapping("/count") -> Devuelve el total de museos que hay en la base de datos.
- @GetMapping("/precios") -> Devuelve el nombre de los museos junto su precio de entrada.
- @GetMapping("/siempreAbierto") -> Devuelve los museos que abren todos los días.
- @GetMapping("/listaWebs") -> Devuelve el nombre de los museos junto con su página web.
- @PostMapping("/post") -> Crea un museo nuevo, pero solo si el token es válido.
- @PutMapping("/{id}") -> Actualiza un museo que ya exista, o lo guarda si no existe (solo si el token es correcto).
- @DeleteMapping("/{id}") -> Si el token es válido, elimina el museo con el id pasado por parámetro.

### Endpoints para cuadros:
Parten de la raíz @RequestMapping("/api/cuadro"):

- @GetMapping("/id/{id}") -> Devuelve el cuadro con el id pasado como parámetro.
- @GetMapping("/nombre/{nombre}") -> Devuelve el cuadro con el nombre pasado como parámetro.
- @GetMapping("/fecha/{fecha}") -> Devuelve el cuadro con la fecha pasada como parámetro.
- @GetMapping("/autor/{autor}") -> Devuelve el cuadro con el autor pasado como parámetro.
- @GetMapping("/museo/{nombre}") -> Devuelve el cuadro con el nombre del museo en el que se encuentra pasado como parámetro.
- @GetMapping("/totalCuadros") -> Devuelve el número total de cuadros que hay en la base de datos.
- @GetMapping("/listaAutores") -> Devuelve una lista con el nombre de todos los autores que hay en la base de datos.
- @GetMapping("/ubicacionCuadro") -> Devuelve una lista con todos los cuadros junto con el nombre del museo en el que se encuentran.
- @GetMapping("/detallesCuadros") -> Devuelve una lista con todos los cuadros y su información.
- @PostMapping("/post") -> Crea un nuevo cuadro, sólo si el token es válido.
- @PutMapping("/{id}") -> Actualiza un cuadro que ya exista, o lo guarda si no existe (solo si el token es correcto).
- @DeleteMapping("/{id}") -> Si el token es válido, elimina el cuadro con el id pasado por parámetro.

## Algunos ejemplos 📑
![image](https://github.com/Carmen2707/APIRestSpringMuseo/assets/116809224/1300e8fb-7692-47ea-ad21-3530db738663)
![image](https://github.com/Carmen2707/APIRestSpringMuseo/assets/116809224/80acc3a3-4c41-428c-bff3-ddf01095df46)
![image](https://github.com/Carmen2707/APIRestSpringMuseo/assets/116809224/96c7b25d-d72a-40df-9226-bf38545f20fe)
![image](https://github.com/Carmen2707/APIRestSpringMuseo/assets/116809224/90b4aa27-cbfa-430c-acc6-dfb5c7724302)
![image](https://github.com/Carmen2707/APIRestSpringMuseo/assets/116809224/09829dd7-639d-4a56-923c-c0fab7f84d06)



