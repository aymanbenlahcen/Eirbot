/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

/**
 *
 * @author DREAM-TECH
 */
public class Help implements ResponseBot{
    private String help;
    
    public String bot() {
        this.help = "Existing bots are : \n @hello \n @time \n @icndb : Chuck Norris Quotes \n @icndb number : returns number of Chuck Norris Quotes"
                + "Quiz : Play a quiz game \n @ advice : gives advice \n @bored : suggests activity to do \n @breakingbad : Breaking Bad quotes \n"
                + " \n @ip : returns ip address";
        return this.help;
    }
}
