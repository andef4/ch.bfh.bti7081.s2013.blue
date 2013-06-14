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

Damit das Scannen korrekt funktioniert, muss in der Datei src/main/resources/settings.properties die IP-Adresse und Port des Servers angegeben
sein. Eine Beispiel-Konfigurationsdatei ist unter src/main/resources/settings.properties.example gespeichert.

Als Scanner App wird "Barcode Scanner" für Android verwendet: https://play.google.com/store/apps/details?id=com.google.zxing.client.android
