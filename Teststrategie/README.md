# Grundlagen Testen

<hr>

## Table
Ist Resultat ist bei uns leer da wir keine wirklichen Tests haben.

<table>
  <tr>
    <th>Testfall</th>
    <th>Erwartetes Resultat</th>
    <th>Ist Resultat</th>
  </tr>
  <tr>
    <td>< 15'000</td>
    <td>Kein Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>≥ 15'000 && < 20'000</td>
    <td>5% Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>≥ 20'000 && < 25'000</td>
    <td>7% Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>≥ 25'000</td>
    <td>8.5% Rabatt</td>
    <td>-</td>
  </tr>
</table>

<table>
  <tr>
    <th>Testfall</th>
    <th>Erwartetes Resultat</th>
    <th>Ist Resultat</th>
  </tr>
  <tr>
    <td>998</td>
    <td>Kein Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>23'747</td>
    <td>7% Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>-999'999</td>
    <td>Input Error</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>kdajfk</td>
    <td>Input Error</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>0</td>
    <td>Kein Rabatt</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>Select FROM * ...</td>
    <td>Input Error</td>
    <td>-</td>
  </tr>
  <tr>  
    <td>15'000</td>
    <td>5% Rabatt</td>
    <td>-</td>
  </tr>
</table>

<hr>

## Blackboxtesting Autovermietung
https://www.sixt.ch/


<table>
  <tr>
    <th colspan="2">Tester:</th>
    <td colspan="3">Jan/Luk </td>
  </tr>
  <tr>
    <th colspan="2">Datum:</th>
    <td colspan="3">29.08.2023 </td>
  </tr>
  <tr>
    <th colspan="2">Was:</th>
    <td colspan="3">https://www.sixt.ch/</td>
  </tr>
  <tr>
    <th>Nr.</th>
    <th>Testfall</th>
    <th>Erwartetes Resultat</th>
    <th>Ist Resultat</th>
    <th>Erfüllt</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Datum muss in <br>der Zukunft sein</td>
    <td>Datum kann nicht<br>in der Vergangenheit<br>sein</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>2</td>
    <td>E-Mail muss<br> korrekt sein</td>
    <td>Email muss einem<br>pattern entsprechen</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>3</td>
    <td>Passwort muss<br> Mindestanforderung<br> entsprechen</td>
    <td>Passwort muss min<br>8 Zeichen haben</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>4</td>
    <td>Validierung mit drei<br> Buchstaben</td>
    <td>Bei allen Suchoptionen<br> muss es min 3 <br> Buchstaben haben</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>5</td>
    <td>Übersetzung stimmt</td>
    <td>Korrekte übersetzung</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>6</td>
    <td>Verlinkungen<br> funktionieren</td>
    <td>Links führen an die <br> richtigen Orte</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>7</td>
    <td>Telefonnummer<br>klickbar</td>
    <td>Mann kann auf die <br> Telefonnummer klicken</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>8</td>
    <td>Nutzer kann sein<br>Profil bearbeiten</td>
    <td>Der Nutzer hat die <br> freie Verwaltung über<br> sein Konto</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>9</td>
    <td>Buchung<br>Storniernar</td>
    <td>Man kann eine <br> Buchung abbrechen</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
  <tr>  
    <td>10</td>
    <td>Währung kann<br>angepasst werden</td>
    <td>Die Währung kann <br> angepasst werden <br> nach Beliben des <br> Nutzers</td>
    <td>Siehe erwartetes<br> Resultat</td>
    <td>Ja</td>
  </tr>
</table>


### Blackbox
<b>grosse imputs >1000</b>
-	Errorcode 
-	program down

<b>zwei buchstaben</b>
-	zweiter wird ignoriert
umlaute
-	werden falsch dargestellt
Zahlen
-	Message ungültiger imput
Konto angeschaut
- Nach Eingabe der Kontonumemr erscheint kein Menü mehr



<b>Whitebox</b>
- Auskommentierter Code



<b>Code Quality</b>
- Keine var verwenden
- Printmetthoden auslagern und zusammenfügen
- Auskommentierter Code
- Variabllen Namen besser wählen