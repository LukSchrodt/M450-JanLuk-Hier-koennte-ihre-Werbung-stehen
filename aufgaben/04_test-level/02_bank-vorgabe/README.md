# Aufgabe 3 - Banken Simulation
#### Erklärung von Klassen

**Account (Konto)**
* Eine abstrakte Klasse, die die gemeinsamen Eigenschaften und Methoden für verschiedene Arten von Konten definiert.
*  Enthält die Kontonummer (id), den Kontostand (balance) und eine Liste von Buchungen (bookings).

**AccountBalanceComparator**
* Ein Vergleichsobjekt, das verwendet wird, um Konten nach ihrem Kontostand in absteigender Reihenfolge zu sortieren.
* Implementiert das Comparator-Interface.
  **AccountInverseBalanceComparator**
* Ein Vergleichsobjekt, das verwendet wird, um Konten nach ihrem Kontostand in aufsteigender Reihenfolge zu sortieren.
* Implementiert ebenfalls das Comparator-Interface.


**Bank (Bank)**
* Die Hauptklasse, die Bankfunktionen und -operationen verwaltet.
* Enthält eine Liste von Bankkonten (accounts) und eine nächste verfügbare Kontonummer (nextAccountId).


**Booking (Buchung)**
* Eine Klasse, die Buchungsinformationen speichert, einschließlich Datum (date) und Betrag (amount).
* Hat eine Methode print(), die die Buchungsdetails druckt.


**PromoYouthSavingsAccount**
* Eine spezielle Art von Sparkonto, die einen Bonus von 1% auf jede Einzahlung gewährt.
* Erbt von SavingsAccount und überschreibt die deposit-Methode, um den Bonus hinzuzufügen.


**SalaryAccount (Lohnkonto)**
* Eine Art von Konto, bei dem ein Kreditlimit angegeben werden kann.
* Erbt von Account und überschreibt die withdraw-Methode, um sicherzustellen, dass das Kreditlimit eingehalten wird.


**SavingsAccount (Sparkonto)**
* Eine Art von Konto, bei dem das Abheben von Geldern nur möglich ist, wenn ausreichend Guthaben vorhanden ist.
* Erbt von Account und überschreibt die withdraw-Methode, um den Saldo zu überprüfen.


**BankUtils (Bankhilfsprogramme)**
* Eine Hilfsklasse mit verschiedenen statischen Methoden zur Formatierung von Daten, wie z.B. Datumsformatierung und Betragformatierung.


**Main (Hauptklasse)**
* Die Hauptklasse, die die main-Methode enthält.
* Zeigt, wie eine Instanz der Bank-Klasse erstellt wird.
***

#### Projekt Funktionen
**Kontoerstellung**: Die Bank-Klasse ermöglicht die Erstellung verschiedener Arten von Konten, darunter Sparkonten, Jugend-Sparkonten und Lohnkonten.

**Einzahlungen und Abhebungen:**
Die Konten (z.B. SavingsAccount, SalaryAccount) im Projekt unterstützen Einzahlungen und Abhebungen. Kunden können Geld auf ihre Konten einzahlen oder davon abheben.

**Buchungen:** Die Account-Klasse speichert Buchungen, die alle Transaktionen auf dem Konto verfolgen. Diese Buchungen enthalten das Transaktionsdatum und den Betrag.

**Kontostandsabfrage:** Kunden können ihren aktuellen Kontostand abfragen, um herauszufinden, wie viel Geld sich auf ihrem Konto befindet.

**Kontoauszug drucken:** Die print-Methode ermöglicht es Kunden, ihren Kontoauszug anzuzeigen, der alle Transaktionen und den aktuellen Saldo auflistet.

**Sortieren von Konten:** Die Bank-Klasse bietet Funktionen zum Sortieren der Konten nach verschiedenen Kriterien, z.B. nach Kontostand.

**Bonus für Jugendliche:** Das PromoYouthSavingsAccount gewährt einen Bonus von 1% auf jede Einzahlung. Dies ist ein Anreiz für Jugendliche, Geld zu sparen.

**Kreditlimite für Lohnkonten:** Das SalaryAccount-Konto kann eine Kreditlimite haben, die sicherstellt, dass das Konto nicht über einen bestimmten Betrag hinaus überzogen wird.
***
#### Zusammenhänge
1. Bank (Bank):
   Die Bank-Klasse ist der zentrale Punkt des Projekts und verwaltet alle Konten.
2. Konten (Account, SavingsAccount, SalaryAccount, PromoYouthSavingsAccount):
   Verschiedene Arten von Konten werden von Klassen wie SavingsAccount, SalaryAccount und PromoYouthSavingsAccount abgeleitet
3. Buchungen (Booking):
   Die Booking-Klasse repräsentiert einzelne Buchungen auf einem Konto.
4. BankUtils:
   Die BankUtils-Klasse enthält Hilfsfunktionen zur Formatierung von Datums- und Betragsangaben..

**Die Zusammenhänge sind wie folgt:**
* Die Bank-Klasse verwaltet eine Liste von Konten.
* Verschiedene Arten von Konten werden durch abgeleitete Klassen repräsentiert.
* Konten verwalten ihre Buchungen und den aktuellen Saldo.
* Die Bank kann Konten erstellen, Kontostände abfragen, Einzahlungen und Abhebungen verarbeiten und Kontoauszüge drucken.
* Die Sortierungs-Comparator-Klassen werden verwendet, um Konten nach verschiedenen Kriterien zu sortieren.