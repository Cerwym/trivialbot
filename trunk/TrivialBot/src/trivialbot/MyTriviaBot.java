/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trivialbot;

import org.jibble.pircbot.PircBot;

/**
 *
 * @author hussein
 */
public class MyTriviaBot extends PircBot{
    
    String channel;

    public MyTriviaBot(String name) {       
        setName(name);        
    }

    @Override
    protected void onConnect() {
        super.onConnect();
        sendMessage(channel, "Hello World !");
    }

    @Override
    protected void onDisconnect() {
        super.onDisconnect();
        sendMessage(channel, "sorry gtg, bye !");
    }
    
    
    
    
                
}
