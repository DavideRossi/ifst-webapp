# ifts-webapp
Scheletro di progetto per web application

Per sviluppare con Eclipse
* File/Import/Git/Projects from Git (nell'ultimo passo selezionare "Import as general project").
* Project/Properties: aggiungere "Java", "Maven Nature" e "Web Properties" in "Project Natures"
* Project/Update Maven Project

Workflow con Maven
* `mvn package` per generare il WAR file dell'applicazione
* `mvn test` per lanciare solo i test
* `mvn tomcat7:run` per lanciare Tomcat con l'applicazione installata (accessibile da `http://localhost:9999/ifts`) - per rilanciare dopo eventuali modifiche fermare Tomcat con "Terminate" dalla relativa Console e rilanciare il goal.

Workflow con Eclipe
* Menu contestuale del progetto/Run As/JUnit Test - per lanciare i test
* Menu contestuale del progetto/Run As/Run on Server - selezionare un Tomcat v7.0 se già presente o installarlo ex novo dalla stessia dialog
* View Server/selezionare Tomcat v7.0 e cliccare su "Restart the server" per riavviare il server ricaricando eventuali modifiche al codice
