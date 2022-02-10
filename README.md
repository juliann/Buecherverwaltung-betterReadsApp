#betterReadsApp 

Dieses Projekt dient dazu den Umgang mit einer Cassandra Datenbank mit riesigen Datenmengen (in diesem Beispiel: alle Bücher die über https://openlibrary.org/ verfügbar sind, ~20 Millionen) zu erlenen. Die Inspiration dieses Projekts kommt von https://www.goodreads.com/.

Ein Nutzer soll sich auf unserer Seite, wenn er nicht eingeloggt ist Bücher aus dem Katalog von openlibrary suchen können und Infos zu Autor, Release Datum, Bild dargestellt bekommen. Falls der Nutzer eingeloggt ist, kann er seinen Lesestatus, Start und Enddatum des Lesens sowie eine Bewertung und ein Rating für das Buch abgeben und abspeichern.

Technologien:
-	Webseite mit Thymeleaf und Bootstrap
-	Userlogin mit Spring Security und Oauth
-	Cassandra (via Astra DB https://www.datastax.com) und Spring Boot Data Cassandra zur Speicherung und Verwaltung aller Daten
-	Die Daten von openlibary als 10+GB Große .txt Dateien mit vielen für uns sinnlose Informationen wurden davor in einem separaten Projekt in zum ausgesuchten Cassandra Datenmodel nutzbare Datensätze umgewandelt und in Cassandra importiert. (https://github.com/juliann/spring-cassandra-betterreads-data)

Zukünftig mögliche Verbesserungen:
-	Die Suchanfragen direkt auf unsere eigene Datenbank legen und mit Apache Lucene schnelle queries ermöglichen
-	Ein soziales Verknüpfen von Nutzern ermöglichen (Freundschaften, Bewertungen ansehen, Nachrichten schicken)
-	Basierend auf bewerteten Büchern neue Vorschläge zu möglich interessanten Büchern bekommen.
