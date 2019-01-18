package chatbot;

import bots.Gestionnaire;
import java.awt.BorderLayout;
import java.time.ZonedDateTime;
import java.util.Scanner;
import bots.Gestionnaire;
import bots.ResponseBot;
import bots.Quiz;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DREAM-TECH
 */
public class UserInterface {

    public static String pseudo;
    private String message;
    private int counter;
    private Gestionnaire gst;

    public UserInterface(String pseudo) {
        this.pseudo = pseudo;
        this.gst = new Gestionnaire();
    }

    public void start(String parameter1, String parameter2, Scanner reader) {
        System.out.println("Welcome to EirBot");
        try {
            if (parameter1.equals("-p") && !parameter2.isEmpty()) {
                handleBots(reader);
            }
        } catch (Exception e) {
            System.out.println("Command line arguments are not correct");
        }
    }

    private void handleBots(Scanner reader) {

        do {
            this.gst.updateBored();
            this.gst.updateBreakingBad();
            this.gst.updateAdvice();
            System.out.print("[" + this.pseudo + "]");
            message = reader.nextLine();
            String[] arrOfStr = this.message.split(" ", 2);
            int amount;
            if (this.gst.getMap().containsKey(arrOfStr[0])) {
                if (arrOfStr[0].equals("@icndb")) {
                    if (!arrOfStr[1].isEmpty()) {
                        amount = Integer.parseInt(arrOfStr[1]);
                        repeatIcndb(amount);
                    } else {
                        repeatIcndb(1);
                    }
                }
                if (arrOfStr[0].equals("@quiz")) {
                    if (!arrOfStr[1].isEmpty()) {
                        resetCounter();
                        amount = Integer.parseInt(arrOfStr[1]);
                        ArrayList<String> questions = repeatQuiz(amount);
                        for (String question : questions) {
                            System.out.println(question);
                            do {
                                System.out.println("[" + this.pseudo + "]" + "You should write a number");
                                message = reader.nextLine();
                            } while (!isNumeric(message));
                            if (isNumeric(message)) {
                                handleQuiz();
                            }
                        }
                        System.out.println("Score final: " + this.counter + "/" + amount);
                    } else {
                        ArrayList<String> questions = repeatQuiz(1);
                        for (String question : questions) {
                            System.out.println(question);
                            while (!isNumeric(message)) {
                                System.out.println("[" + this.pseudo + "]" + "You should write a number");
                                message = reader.nextLine();
                            }
                            if (isNumeric(message)) {
                                handleQuiz();
                            }
                        }
                    }
                } else {
                    this.gst.getMap().keySet().stream().filter((key) -> (this.message.equals(key))).forEachOrdered((key) -> {
                        System.out.println((String) gst.getMap().get(key));
                    });
                }
            } else {
                System.out.println("[System] Je ne connais pas le chatbot " + this.message + "!");
            }
        } while (!message.equals("++"));
    }

    private void repeatIcndb(int amount) {
        for (int i = 0; i < amount; i++) {
            this.gst.updateIcndb();
            this.gst.getMap().keySet().stream().filter((key) -> ("@icndb".equals(key))).forEachOrdered((key) -> {
                System.out.println(((String) gst.getMap().get("@icndb")));
            });
        }
    }

    private ArrayList<String> repeatQuiz(int amount) {
        ArrayList<String> qu = new ArrayList<String>();
        for (int i = 0; i < amount; i++) {
            this.gst.updateQuiz();
            this.gst.getMap().keySet().stream().filter((key) -> ("@quiz".equals(key))).forEachOrdered((key) -> {
                qu.add((String) gst.getMap().get(key));
            });
        }
        return qu;
    }

    private void handleQuiz() {
        if (Integer.parseInt(message) == 4) {
            System.out.println("[" + this.pseudo + "]" + "Bonne réponse!");
            increase();
        } else {
            System.out.println("[" + this.pseudo + "]" + "Mauvaise réponse!");
        }
    }

    private boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public int increase() {
        return this.counter++;
    }

    public static String getPseudo() {
        return pseudo;
    }

    private void resetCounter() {
        this.counter = 0;
    }

}
