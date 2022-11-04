package com.company;

import com.company.entities.Player;
import com.company.entities.Race;

public class Game {
    private final String name = "nic";
    public final double version = 0.1;
    private final String author = "Ja";
    private GameDialog gameDialog;
    private Player player;

    public Game() {
        gameDialog = new GameDialog();
        player = new Player();
    }

    public void start() {
        gameDialog.intro(name, version, author);
        introMenu();
        storyIntro();

    }
    private void introMenu(){
        gameDialog.say("Vitej v poklidnem. V mestecku bydli tisice lidi. Je cas na vyber postavy.");
        gameDialog.say("Zvol si svoji rasu:", "red");
        for (Race value : Race.values()) {
            gameDialog.say(value.toString(), "purple");
        }
        selectRace();

    }

    private void selectRace(){
        String userInput = gameDialog.userInput();
        boolean check = false;
        for (Race value : Race.values()) {
            if (userInput.trim().equalsIgnoreCase(value.toString())){
                check = true;
                player.setRace(value);
                break;
            }
        }
        if (!check) {
            System.out.println("Neplatny vstup");
            selectRace();
            return;
        }

    }
    private void storyIntro(){
        gameDialog.say("Zvolil si rasu " + player.getRace(), "red");
        gameDialog.say("--------------------------------", "white");
        gameDialog.say("            Hra zacina"          );
        gameDialog.say("--------------------------------", "white");
        gameDialog.say("Vitej v poklidnem mestecku, kde tisice lidi prezivaji tvoji existnci");

    }

}
