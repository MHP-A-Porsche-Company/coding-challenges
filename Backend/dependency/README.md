# Backend Coding Challenge: Module Dependency Challenge

### ProjectStructure
This Spring-Boot-Project consists of three Submodules (`inquiry`, `notification` and `application`).
The `notification`-Module depends on the `inquiry`-Module. The `application` depends on both and serves as Spring boot main module.

The `InquiryTest` calls `InquiryService#create(Inquiry)` and checks wether the methods `EmailHandler#sendEmail(Inquiry)`
and `PushNotificationHandler#sendNotification` have been called with the same parameters.

### Acceptance Criteria: 
- After an Inquiry has been created, `EmailHandler#sendEmail(Inquiry)` and `PushNotificationHandler#sendNotification` have to be executed
- the `InquiryTest` has to be successful
 
### general conditions:
- the classes `Inquiry`, `InquiryTest` and `Application` shall not be modified
- the existing classes shall not be moved between the modules
- the dependencies between the modules shall not be customized
- Any other gradle dependencies can be added


--- German -----------------------------------------------

### Projektaufbau:
Dieses Spring-Boot-Projekt besteht aus drei Submodulen (`inquiry`, `notification` und `application`).
Das `notification`-Modul ist vom `inquiry`-Modul abhängig. Das `application` ist von beiden abhängig und dient als Spring boot Hauptmodul.

Der `InquiryTest` ruft `InquiryService#create(Inquiry)` auf und prüft, ob die Methoden `EmailHandler#sendEmail(Inquiry)`
und `PushNotificationHandler#sendNotification` mit dem gleichen Parameter aufgerufen wurden.

### Akzeptanzkritieren: 
 - Nach dem eine Inquiry erstellt wird, muss `EmailHandler#sendEmail(Inquiry)` und `PushNotificationHandler#sendNotification` ausgeführt werden
 - Der `InquiryTest` muss erfolgreich sein
 
### Rahmenbedingungen:
 - Die Klassen `Inquiry`, `InquiryTest` und `Application` dürfen nicht modifiziert werden
 - Die bestehenden Klassen dürfen nicht zwischen den Modulen verschoben werden
 - Die Abhängigkeiten zwischen den Modulen dürfen nicht angepasst werden
 - Ansonsten können beliebige gradle dependencies hinzugefügt werden

