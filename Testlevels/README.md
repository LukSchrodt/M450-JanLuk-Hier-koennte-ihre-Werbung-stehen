# Testinglevels

<hr>

## Tests in unserer Firma
Im generellen wird in unserer Firma fast alles getestet. Da wir in einer eher grossen Firma arbeiten werden selbst die Nutzer getestet durch Sicherheitstests welche versuchen die Leute zu finden, welche eine Sicherheits lücke darstellen.

### Mit welchen Testleveln hatten wir zu tuhen?
Wir hatten schon mit allen Testleveln zu tuhn. Wir haben selbsts getestet und Tests geschrieben. Auch haben wir die Rolle eines Testers eingenommen und diverse Systemtests ausgeführt. Und auf ein paar unserer Projekte wurden auch vorzu von unseren Kunden getestet.

### Wann wird getestet?
Im Normalfall wird immer dann getestet, wenn ein Pullrequest ausgeführt wird. Auch werden bei manchen Repositories die Tests ausgeführ sobald ein Push gemacht wird. Dies ist jedoch seltener.

### Haben Sie dedizierte Testing oder QA Teams?
Wir haben eigentlich immer QA Teams die das testing übernehmen. Alternativ haben wir ein paar developer welche es als spezialisierung haben zu testen und das Program zu prüfen.

### Wie sieht unser Testing life Cycle aus?
Unser Testing life Cycle entspricht ziemlich dem Standart:
1. Anforderungsanalyse
2. Testplanung
3. Testfallentwicklung
4. Einrichtung der Testumgebung
5. Test Ausführung
6. Abschluss des Testzyklus

Wir verwenden diese da sie uns am Sinnvollsten vorkommt und es am praktischsten ist. Es ist an manchen stellen wie zwar nicht ganz so ausgeprägt, z.B. Testplanung.

<hr>

### Versuchen Sie folgende Begriffe einzuordnen und Abhängigkeiten untereinander zu erkennen:

Diese drei testing Teile hängen relativ stark zusammen. Z.B. der Testing approach kann sehr vareiren, entsprechend der desting Types. Auch können die levels sich ändern wenn man einen adneren approach verwendet. <b>edit!!!</b>
s
<hr>

### JUnit :

- Einige wichtige Prinzipien des Unit Testings sind das Schreiben unabhängiger Tests, die Erreichung einer hohen Code-Abdeckung, die Verwendung von Mock-Objekten für Drittanbieterabhängigkeiten und die Minimierung der Ausführungszeit.
- JUnit ist ein beliebtes und effizientes Unit-Testing-Framework für Java und wurde in JUnit 5 mit Verbesserungen aktualisiert. Es besteht aus drei Hauptkomponenten: der JUnit-Plattform, der JUnit-Jupiter-Engine und der JUnit-Vintage-Engine.
- Unit Testing ist der Prozess, bei dem die Funktionalität einer Anwendung überprüft wird, um sicherzustellen, dass sie den Anforderungen entspricht. 
- Es kann manuell oder automatisiert durchgeführt werden, wobei die automatisierte Methode aufgrund ihrer Geschwindigkeit und Zuverlässigkeit bevorzugt wird.
- JUnit ist ein Framework für automatisiertes Unit Testing in der Java-Programmierung und fördert die Idee des "erst testen, dann codieren", um die Qualität und Stabilität des Codes zu erhöhen.
- Features von JUnit umfassen Annotations zur Identifizierung von Testmethoden, Assertions zur Überprüfung erwarteter Ergebnisse, Test Runner zur Ausführung von Tests und die Möglichkeit, Testfortschritt anzuzeigen.

#### Quellen:
- https://www.tutorialspoint.com/junit/junit_overview.htm
- https://www.codecentric.de/wissens-hub/blog/junit5-junit-5
- https://medium.com/testvagrant/unit-testing-with-junit-5-a13b0afae84c