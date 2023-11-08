package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static final int TOTAL_CASES = 26; // Gesamtanzahl der Koffer
    private static ArrayList<Double> cases; // Liste aller Kofferbeträge
    private static ArrayList<Double> remainingAmounts; // Verbleibende Kofferbeträge
    private static double playerCaseAmount; // Betrag im ausgewählten Koffer des Spielers
    private static Scanner scanner = new Scanner(System.in); // Eingabescanner

    public static void main(String[] args) {
        initializeCases(); // Startet das Spiel, indem alle Koffer mit zufälligen Geldbeträgen gefüllt werden
        int playerCaseIndex = choosePlayerCase(); // Der Spieler wählt seinen persönlichen Koffer aus den verfügbaren aus
        playerCaseAmount = remainingAmounts.remove(playerCaseIndex - 1); // Speichert und entfernt den Betrag im gewählten Koffer des Spielers aus der Liste der verbleibenden Koffer

        // Beginnt die Runden des Spiels, in denen der Spieler Koffer öffnet und Bankangebote erhält
        for (int round = 1; round <= 9; round++) {
            int casesToOpen = casesToOpen(round); // Entscheidet, wie viele Koffer in dieser Runde geöffnet werden müssen
            System.out.println("Runde " + round + ". Wähle " + casesToOpen + " Koffer zum Öffnen aus."); // Fordert den Spieler auf, Koffer auszuwählen
            for (int i = 0; i < casesToOpen; i++) {
                openCase(); // Führt die Aktion aus, um einen Koffer zu öffnen und den Betrag anzuzeigen.
            }

            double offer = calculateBankOffer(remainingAmounts, round); // Die Bank macht ein Angebot basierend auf den verbleibenden Koffern und der Rundenzahl
            System.out.printf("Das Angebot der Bank beträgt: $%.2f\n", offer); // Zeigt das Bankangebot an // % = Platzhalter für Variable // .2f = double mit 2 Nachkommastellen
            System.out.print("Deal oder kein Deal? Tippe 'deal', um das Angebot anzunehmen, oder 'no deal', um fortzufahren: "); // Fragt den Spieler, ob er das Angebot annehmen möchte
            String dealResponse = scanner.nextLine(); // Liest die Antwort des Spielers ein
            if ("deal".equalsIgnoreCase(dealResponse)) {
                System.out.printf("Herzlichen Glückwunsch! Du hast $%.2f gewonnen\n", offer); // Gratuliert dem Spieler, wenn er das Angebot annimmt
                return; // Beendet das Spiel, da der Spieler sich für den Deal entschieden hat
            }

            System.out.println("Kein Deal! Es geht weiter..."); // Das Spiel geht weiter, wenn der Spieler kein Deal wählt
        }

        finalChoice(playerCaseIndex); // Startet die letzte Runde, in der der Spieler sich entscheiden kann, ob er seinen Koffer behalten oder tauschen möchte

        scanner.close(); // Schließt den Scanner am Ende des Spiels, um Ressourcen zu sparen (clean code)
    }


    private static void initializeCases() {
        cases = new ArrayList<>(Arrays.asList(CaseAmounts.AMOUNTS)); // Koffer mit Beträgen initialisieren
        remainingAmounts = new ArrayList<>(cases); // Kopie der Kofferliste für das Spiel
        Collections.shuffle(remainingAmounts); // Mischen der verbleibenden Beträge
    }


    private static int choosePlayerCase() {
        int caseNumber = 0;
        do {
            System.out.println("Wähle deinen Koffer (1-26):");
            while (!scanner.hasNextInt()) {
                System.out.println("Das ist keine gültige Koffernummer. Bitte gib eine Zahl zwischen 1 und 26 ein.");
                scanner.next(); // Ignoriere ungültige Eingabe
            }
            caseNumber = scanner.nextInt();
            scanner.nextLine(); // Überlese das Zeilenumbruchzeichen
            if (caseNumber < 1 || caseNumber > TOTAL_CASES) {
                System.out.println("Bitte wähle eine Zahl zwischen 1 und 26.");
            }
        } while (caseNumber < 1 || caseNumber > TOTAL_CASES);

        System.out.printf("Du hast Koffernummer %d gewählt.\n", caseNumber);
        return caseNumber;
    }

    private static void openCase() {
        int caseNumber = 0;
        boolean validChoice;
        do {
            validChoice = true;
            System.out.println("Wähle einen Koffer zum Öffnen (1-26): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Das ist keine gültige Koffernummer. Bitte gib eine Zahl zwischen 1 und 26 ein.");
                scanner.next(); // Ignoriere ungültige Eingabe
            }
            caseNumber = scanner.nextInt();
            scanner.nextLine(); // Überlese das Zeilenumbruchzeichen
            if (caseNumber < 1 || caseNumber > TOTAL_CASES || !remainingAmounts.contains(cases.get(caseNumber - 1))) {
                System.out.println("Ungültige Koffernummer oder Koffer bereits geöffnet. Bitte wähle einen anderen Koffer.");
                validChoice = false;
            }
        } while (!validChoice);

        Double caseAmount = remainingAmounts.remove(remainingAmounts.indexOf(cases.get(caseNumber - 1)));
        System.out.printf("Koffernummer %d enthielt: $%.2f\n", caseNumber, caseAmount);
    }

    private static int casesToOpen(int round) {
        // Bestimmt die Anzahl zu öffnender Koffer basierend auf der Rundennummer
        switch (round) {
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            case 7:
                return 1;
            case 8:
                return 1;
            case 9:
                return 1;
            default:
                return 0; // Fehlerfall, sollte nie eintreten
        }
    }


    // Methode für die letzte Entscheidung im Spiel.
    private static void finalChoice(int playerCaseIndex) {
        System.out.println("Es sind nur noch zwei Koffer übrig.");
        // Informiert den Spieler über seine Koffernummer und die Nummer des letzten verbleibenden Koffers
        System.out.printf("Deine Koffernummer: %d und die andere Koffernummer: %d\n", playerCaseIndex, findRemainingCaseIndex());
        System.out.println("Möchtest du die Koffer tauschen? (ja/nein)");

        // Liest die Entscheidung des Spielers, ob die Koffer getauscht werden sollen
        String input = scanner.next().trim().toLowerCase();
        boolean swap = input.equals("ja");

        // Ermittelt den Index des verbleibenden Koffers basierend auf der Entscheidung des Spielers
        int remainingCaseIndex = swap ? playerCaseIndex : findRemainingCaseIndex();

        // Holt die Beträge aus den beiden Koffern
        Double playerCaseAmount = cases.get(playerCaseIndex - 1);
        Double remainingCaseAmount = cases.get(remainingCaseIndex - 1);

        // Falls der Spieler sich entscheidet zu tauschen, aktualisiert diese den Betrag im Koffer des Spielers
        if (swap) {
            System.out.println("Du hast dich entschieden, die Koffer zu tauschen.");
            playerCaseAmount = remainingCaseAmount;
        } else {
            System.out.println("Du hast dich entschieden, deinen ursprünglichen Koffer zu behalten.");
        }

        // Zeigt dem Spieler den Betrag in seinem Koffer an.
        System.out.printf("Dein Koffer enthält: $%.2f\n", playerCaseAmount);
        System.out.println("Danke, dass Sie Deal oder No Deal gespielt haben!");
    }

    // Hilfsmethode, um den Index des letzten verbleibenden Koffers zu finden
    private static int findRemainingCaseIndex() {
        // Durchsucht die Liste der Koffer und gibt den Index des letzten verbleibenden Koffers zurück
        for (int i = 0; i < cases.size(); i++) {
            if (remainingAmounts.contains(cases.get(i))) {
                return i + 1; // Koffernummern beginnen bei 1, nicht bei 0
            }
        }
        return -1; // Dies sollte niemals passieren, wenn die Spiellogik korrekt ist
    }

    // Methode zur Berechnung des Angebots der Bank in jeder Runde.
    private static double calculateBankOffer(ArrayList<Double> remainingAmounts, int round) {
        double total = 0.0;
        // Addiert alle verbleibenden Beträge, um die Gesamtsumme zu erhalten
        for (double amount : remainingAmounts) {
            total += amount;
        }
        // Berechnet den erwarteten Wert der verbleibenden Koffer.
        double expectedValue = total / remainingAmounts.size();
        // Das Angebot der Bank ist ein Bruchteil des erwarteten Werts, abhängig von der Runde
        return (expectedValue * round) / 10.0;
    }
}
