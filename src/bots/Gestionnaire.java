/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import chatbot.UserInterface;
import static chatbot.UserInterface.getPseudo;
import static chatbot.UserInterface.pseudo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DREAM-TECH
 */
public class Gestionnaire {

    private Map<String, String> botsList = new HashMap<String, String>();

    public Gestionnaire() {
        this.botsList.put("@help", new Help().bot());
        this.botsList.put("@hello", new Hello().bot());
        this.botsList.put("@time", new Time().bot());
        this.botsList.put("@icndb", updateIcndb());
        this.botsList.put("@quiz", updateQuiz());
        this.botsList.put("@breakingbad", updateBreakingBad());
        this.botsList.put("@bored", updateBored());
        this.botsList.put("@ip", new Ip().bot());
    }

    public void print() {
        for (String key : this.botsList.keySet()) {
            System.out.println(this.botsList.get(key));
        }
    }

    public String getBot(String botName) {
        //botName = stringCleaner(botName);
        return this.botsList.get(botName);
    }

    public HashMap getMap() {
        return (HashMap) this.botsList;
    }

    public String updateIcndb() {
        this.botsList.put("@icndb", new Icndb().bot());
        return this.botsList.get("@icndb");
    }

    public String updateQuiz() {
        this.botsList.put("@quiz", new Quiz().bot());
        return this.botsList.get("@quiz");
    }

    public String updateBreakingBad() {
        this.botsList.put("@breakingbad", new BreakingBad().bot());
        return this.botsList.get("@breakingbad");
    }

    public String updateBored() {
        this.botsList.put("@bored", new Bored().bot());
        return this.botsList.get("@bored");
    }

    public String updateAdvice() {
        this.botsList.put("@advice", new Advice().bot());
        return this.botsList.get("@advice");
    }
    
}
