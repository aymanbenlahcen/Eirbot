/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static chatbot.UserInterface.getPseudo;
import static chatbot.UserInterface.pseudo;

/**
 *
 * @author DREAM-TECH
 */
public class Hello implements ResponseBot{
    private String hello;
    
    public Hello() {
        this.hello = "Salut " + getPseudo();
    }
    
    @Override
    public String bot() {
        return this.hello;
    }

}
