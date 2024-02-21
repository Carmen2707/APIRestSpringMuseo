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
