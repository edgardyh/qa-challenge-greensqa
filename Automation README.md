# LATAM UI Automation

Automatización web desarrollada con:

* Java 17
* Selenium
* Serenity BDD
* Screenplay
* Cucumber

## Casos automatizados

### CP1 - Búsqueda de vuelo

Consume datos generados desde el archivo CSV.

### CP2 - Origen igual a destino

Valida que el sistema no permita seleccionar la misma ciudad.

### CP3 - Destino vacío

Valida el mensaje de validación cuando no se selecciona destino.

## Datos de prueba

Los escenarios consumen el archivo:

```text
src/test/resources/passengers.csv
```

Generado por el proyecto Data Generator.

## Ejecución

```bash
mvn clean verify
```

## Reporte Serenity

```text
target/site/serenity/index.html
```
