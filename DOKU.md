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

### Hauptmethoden
- `main`: Die Hauptmethode, die das Spiel initialisiert und durch die verschiedenen Spielrunden führt.
- `initializeCases`: Initialisiert die Koffer mit zufällig zugewiesenen Geldbeträgen.
- `choosePlayerCase`: Lässt den Spieler einen Koffer als seinen persönlichen Koffer auswählen.
- `openCase`: Öffnet einen der verbleibenden Koffer und zeigt den Betrag, der darin enthalten ist.
- `casesToOpen`: Bestimmt die Anzahl der in jeder Runde zu öffnenden Koffer basierend auf der aktuellen Rundenzahl.
