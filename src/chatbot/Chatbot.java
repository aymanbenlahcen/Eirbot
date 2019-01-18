/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.Scanner;

/**
 *
 * @author DREAM-TECH
 */
public class Chatbot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        UserInterface ui;

        try {
           ui = new UserInterface(args[1]);
            ui.start(args[0], args[1], reader);
        } catch (Exception e) {
            System.out.println("Command line arguments are not correct");
        }
    }
}
