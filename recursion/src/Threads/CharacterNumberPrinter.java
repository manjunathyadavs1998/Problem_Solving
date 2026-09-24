package Threads;

public class CharacterNumberPrinter {

    private int number = 1;
    private final int limit = 26;
    private boolean characterTurn = true;

    public synchronized void printCharacters() throws InterruptedException {

        while (number <= limit) {

            while (!characterTurn) {
                wait();
            }

            char ch = (char) ('a' + number - 1);

            System.out.print(ch);

            characterTurn = false;

            notifyAll();
        }
    }

    public synchronized void printNumbers() throws InterruptedException {

        while (number <= limit) {

            while (characterTurn) {
                wait();
            }

            System.out.println(number);

            number++;

            characterTurn = true;

            notifyAll();
        }
    }

    public static void main(String[] args) {

        CharacterNumberPrinter printer = new CharacterNumberPrinter();

        Thread characterThread = new Thread(() -> {
            try {
                printer.printCharacters();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                printer.printNumbers();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        characterThread.start();
        numberThread.start();
    }
}