package com.company;

import com.company.entities.Player;

public class Game {
    private final String name = "Kindergarten - SPSMB DLC";
    public final double version = 0.2;
    private final String author = "Ja";
    private GameDif gameDif;
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
        gameDialog.say("Vítejte v kůži Tomáše Ďurána, který chodí na Střední průmyslovou školu do Mladé Boleslavi, kde se ztratila Kája společně s virtuální realitou." +
                "\nNaposledy byla viděna včera ve škole na poslední hodině programovaní. I přesto jste nedostali reditelské volno a tak se vydávate do školy.");
        gameDialog.say("Zvol si míru postižení", "red");
        for (GameDif value : GameDif.values()) {
            gameDialog.say(value.toString(), "purple");
        }
        selectDif();

    }

    private void selectDif(){
        String userInput = gameDialog.userInput();
        boolean check = false;
        for (GameDif value : GameDif.values()) {
            if (userInput.trim().equalsIgnoreCase(value.toString())){
                check = true;
                gameDif = value;
                break;
            }
        }
        if (!check) {
            System.out.println("Neplatny vstup");
            selectDif();
        }

    }
    private void storyIntro(){
        gameDialog.say("Zvolil jsi mírů postižení: " + gameDif, "red");
        gameDialog.say("--------------------------------", "green");
        gameDialog.say("            Hra zacina"          , "red");
        gameDialog.say("--------------------------------", "green");
        gameDialog.say("Vitej v poklidnem mestecku, kde tisice lidi prezivaji tvoji existnci");

    }

}
