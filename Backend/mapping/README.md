# Backend Coding Challenge: Mapping Challenge

### acceptance criteria:
 - `Article` is correctly mapped to `ArticleDTO` (see `ArticleController#list` and `ArticleController#details`) and is emitted as a JSON from the Controllers
 - the collection of `ArticleBlockDto` in `ArticleDTO` is sorted after `sortIndex` in `ArticleBlockDTO`
 - in case an `Article` cannot be found via ID, a 404 shall be shown (see `ArticleController#details`)
 - optional: in case a new implementation of `ArticleBlock` is created and no mapping is implemented, the user shall get an info

### general conditions:
 - DB Models and DTO Models can be extended with Interfaces/Properties
 - An Existing field of Models and DTOs shall not be modified
 - the package structure shall not be modified
 - Any other gradle dependencies can be added


--- German -----------------------------------------------

### Akzeptanzkritieren:
 - `Article` wird korrekt zu `ArticleDTO` gemapped (Siehe `ArticleController#list` und `ArticleController#details`) und als JSON von den Controllern ausgegeben
 - Die Collection von `ArticleBlockDto` in `ArticleDTO` ist nach dem `sortIndex` in `ArticleBlockDTO` sortiert
 - Falls ein `Article` per ID nicht gefunden werden kann, soll eine 404 Repsonse ausgeliefert werden (Siehe `ArticleController#details`)
 - Optional: Falls eine neue Implementierung/Ableitung von `ArticleBlock` implementiert wird und noch kein Mapping implementiert ist,
   soll mann darauf hingewiesen werden. Wie ist frei überlassen

### Rahmenbedingungen:
 - DB Models und DTO Models können mit Interfaces/Properties erweitert werden
 - Bestehende Felder von Models und DTOs können nicht modifiziert werden
 - Die Packagestruktur darf nicht modifiziert werden
 - Es können beliebig gradle dependencies hinzugefügt werden

