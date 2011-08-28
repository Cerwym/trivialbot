/*
 * TrivialBot
 * 
 * http://code.google.com/p/trivialbot/
 * 
 * Copyright (C) 2011 - TrivialBot
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package trivialbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrivialBot {

    public static void main(String[] args) {

        try {
            Map<String, String> config = loadConfig();

            ArrayList<Question> questions = loadQuestions();


            if (!config.keySet().contains("hostname")) {
                System.err.println("No hostname parameter specified in the config file");
                return;
            }
            if (!config.keySet().contains("channelname")) {
                System.err.println("No channelname parameter specified in the config file");
                return;
            }
            if (!config.keySet().contains("botname")) {
                System.err.println("No botname parameter specified in the config file");
                return;
            }
            if (!config.keySet().contains("adminname")) {
                System.err.println("No adminname parameter specified in the config file");
                return;
            }
            if (!config.keySet().contains("questiontimeout")) {
                System.err.println("No questiontimeout parameter specified in the config file");
                return;
            }
            if (!config.keySet().contains("warningstep")) {
                System.err.println("No warningstep parameter specified in the config file");
                return;
            }

            String hostname = config.get("hostname");
            String channelname = config.get("channelname");
            String channelpassword = config.get("channelpassword");
            String botname = config.get("botname");
            String adminname = config.get("adminname");
            Double questiontimeout = Double.parseDouble(config.get("questiontimeout"));
            Double warningstep = Double.parseDouble(config.get("warningstep"));

            
            System.out.println("TrivialBot started !");
            
            if(questions.size() == 0)
            {
                System.out.println("Error: Empty question list !");
                return;
            }
            System.out.println("Loaded " + questions.size() + " questions");
            System.out.println("Connecting to: " + hostname);
            System.out.println("channel: "+ channelname);
            System.out.println("Bot name: " + botname);
            System.out.println("Admin name: " + adminname);
            
            MyTriviaBot trivialBot = new MyTriviaBot(
                    hostname,
                    channelname,
                    channelpassword,
                    botname,
                    adminname,
                    questions,
                    questiontimeout.intValue(),
                    warningstep.intValue());          

        } catch (Exception ex) {
            Logger.getLogger(TrivialBot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Question> loadQuestions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Scanner sc = new Scanner(new File("questions.csv"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                questions.add(new Question(line[0], line[1]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrivialBot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public static Map<String, String> loadConfig() {

        Map<String, String> config = new HashMap<String, String>();
        try {
            Scanner sc = new Scanner(new File("config.txt"));
            while (sc.hasNext()) {
                config.put(sc.next(), sc.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrivialBot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }
}
