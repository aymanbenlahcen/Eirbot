/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import chatbot.HttpRequest;
import chatbot.UserInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DREAM-TECH
 */
public class Quiz implements ResponseBot {

    private String quiz;
    //private int amount;
    private String Question;
    private ArrayList<String> listAnswers = new ArrayList<String>();
    private String correctAnswer;

    @Override
    public String bot() {
        HttpRequest http = new HttpRequest("https://opentdb.com/api.php?amount=1");
        try {
            this.quiz = function(http.sendGet());
            return this.quiz;
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Not Found!";
    }

    private String function(StringBuffer response) {
        JSONObject json = new JSONObject(response.toString());
        
        
        JSONArray array = json.getJSONArray("results");
        //System.out.println(array);
        //System.out.println(((JSONObject) array.get(0)).getString("question"));
        //System.out.println(((JSONObject) array.get(0)).get("incorrect_answers").getClass().getName());
        
        Question = ((JSONObject) array.get(0)).getString("question");
        
        JSONArray jArray = (JSONArray) ((JSONObject) array.get(0)).get("incorrect_answers");
        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                listAnswers.add(jArray.getString(i));
            }
        }
        listAnswers.add(((JSONObject) array.get(0)).getString("correct_answer"));
        correctAnswer = ((JSONObject) array.get(0)).getString("correct_answer");
        
        //System.out.println(Question + listAnswers);
        String str = Question;
        //System.out.println(Question);
        int k = 0;
        for(int i = 0; i < listAnswers.size(); i++) {
            k = i + 1;
            str += "\n" + k +"/- " + listAnswers.get(i);
          //  System.out.println(i+1 +"/- " + listAnswers.get(i));
        }
        //System.out.println(str);
        return str;
    }

    public ArrayList<String> getAnswers() {
        return this.listAnswers;
    }
    
    public int getNumberAnswers() {
        return this.listAnswers.size();
    }
}
