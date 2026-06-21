GreensQA Data Generator

Proyecto desarrollado en Java 17 para generar datos aleatorios utilizados en pruebas automatizadas.

Funcionalidades
Generación de personas y compañías.
Generación de documentos según estrategia.
Exportación a CSV.
Generación de ciudades origen y destino para vuelos nacionales.
Ejecución
mvn clean package
java -jar target/data-generator.jar
Salida

Archivo CSV:

output/passengers.csv

Ejemplo:

"name","lastname","age","document","city","country","language","type","origen","destino"
"Conchita","Montenegro","40","52757866079","Alcalá de Henares","Latvia","German","P
