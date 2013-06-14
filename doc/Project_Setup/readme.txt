Applikation klinischer Apotheker einrichten
-------------------------------------------

Als Datenbank wird MySQL verwendet. Am einfachsten kann die Datenbank über
XAMPP installiert werden.

- Source auschecken
- Datenbankbenutzer und Datenbank erstellen: create_user_db.sql ausführen (über PHPMyAdmin von XAMPP)
- Daten-Dump in Datenbank einfügen --> database.zip ("import" in PHPMyAdmin)
- Application Server starten:
    - Mit RunJettyRun plugin oder
    - mvn jetty:run oder
    - Mit Tomcat deployen


