# Deal or No Deal

## Übersicht
Dieses Java-Programm ist eine einfache Nachbildung des bekannten TV-Spiels "Deal or No Deal". Spieler wählen einen von 26 möglichen Koffern, die jeweils unterschiedliche Geldbeträge beinhalten. Das Ziel des Spiels ist es, entweder ein Angebot der "Bank" anzunehmen oder bis zum Schluss durchzuhalten und den Betrag im ursprünglich gewählten Koffer zu enthüllen.

## Hauptkomponenten

### Variablen
- `TOTAL_CASES`: Eine Konstante, die die Gesamtzahl der Koffer im Spiel angibt (26).
- `cases`: Eine ArrayList, die die Geldbeträge aller Koffer speichert.
- `remainingAmounts`: Eine ArrayList, die die Beträge der noch nicht geöffneten Koffer enthält.
- `playerCaseAmount`: Der Geldbetrag im ausgewählten Koffer des Spielers.
- `scanner`: Ein Scanner-Objekt, das für die Eingabeaufforderungen des Spielers verwendet wird.

## Hauptmethoden

### `main`
Die Hauptmethode initialisiert das Spiel und steuert die Spielrunden. Sie orchestriert den Spielablauf, indem sie die Initialisierung der Koffer durchführt, die Spielerinteraktionen verwaltet, Bankangebote präsentiert und die Entscheidungen des Spielers entgegennimmt.

### `initializeCases`
Diese Methode wird zu Beginn des Spiels aufgerufen, um die `ArrayList` `cases` mit Geldbeträgen zu füllen. Die Beträge werden aus einem statischen Array geholt, in eine Liste umgewandelt und gemischt, um die Zufälligkeit der Kofferverteilung zu gewährleisten.

### `choosePlayerCase`
Hier wählt der Spieler seinen persönlichen Koffer aus. Die Methode fordert den Spieler zur Eingabe auf, überprüft die Gültigkeit der Auswahl und entfernt den gewählten Kofferbetrag aus der Liste der verbleibenden Beträge.

### `openCase`
Diese Methode wird während des Spiels aufgerufen, wenn der Spieler Koffer öffnet. Sie sorgt dafür, dass die Nummer des zu öffnenden Koffers eingegeben, validiert und der entsprechende Betrag entfernt und angezeigt wird.

### `casesToOpen`
Basierend auf der aktuellen Rundenzahl bestimmt diese Methode die Anzahl der in der Runde zu öffnenden Koffer. In den Anfangsrunden werden mehr Koffer geöffnet, was sich mit jeder Runde verringert.

### `finalChoice`
In der letzten Runde des Spiels gibt diese Methode dem Spieler die Möglichkeit, seinen ursprünglichen Koffer zu behalten oder gegen den letzten verbleibenden Koffer zu tauschen. Der Inhalt des endgültig vom Spieler behaltenen Koffers wird dann enthüllt.

### `calculateBankOffer`
Diese Methode berechnet das Angebot der Bank. Das Angebot basiert auf den verbleibenden Beträgen in den Koffern und der aktuellen Rundenzahl und dient dazu, den Spieler zu einem Deal zu bewegen.

# Janschi's Reminder:

```Java
private static void initializeCases() {
        cases = new ArrayList<>(Arrays.asList(CaseAmounts.AMOUNTS));
// ...
```
In der Zeile `cases = new ArrayList<>(Arrays.asList(CaseAmounts.AMOUNTS));` wird eine neue Instanz von `ArrayList<Double>` erstellt und mit den Werten aus dem Array `CaseAmounts.AMOUNTS` initialisiert. Dies umfasst die folgenden Schritte:

- `Arrays.asList(CaseAmounts.AMOUNTS)`: Konvertiert das Array `CaseAmounts.AMOUNTS` in eine Liste (`List`). Dieses statische Array enthält wahrscheinlich die festgelegten Geldbeträge, die in den Koffern des "Deal or No Deal" Spiels zu finden sind.

- `new ArrayList<>(...)`: Ruft den Konstruktor von `ArrayList` auf und übergibt die neu erstellte Liste als Argument. Somit wird die `ArrayList` mit den Elementen der Liste initialisiert, die aus dem Array `CaseAmounts.AMOUNTS` erstellt wurde.

- `cases = ...`: Weist die neu erstellte und initialisierte `ArrayList` der Variablen `cases` zu. `cases` wird dadurch zu einer veränderbaren Liste, die alle zu Spielbeginn in den Koffern vorhandenen Geldbeträge speichert.

Diese Programmzeile ist ein entscheidender Bestandteil, um das Spiel einzurichten. Sie gewährleistet, dass alle Koffer ihre spezifischen Geldbeträge enthalten, welche im Verlauf des Spiels den Spielern zugeteilt werden.
