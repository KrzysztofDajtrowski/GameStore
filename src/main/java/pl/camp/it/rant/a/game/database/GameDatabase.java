package pl.camp.it.rant.a.game.database;

import org.springframework.stereotype.Component;
import pl.camp.it.rant.a.game.model.Game;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDatabase {
    private final List<Game> games = new ArrayList<>();

    public List<Game> getGames(){
        return games;
    }

    public GameDatabase(){
        this.games.add(new Game("Wiedzmin 3","CD Project RED",6.20 ,
                "https://www.gry-online.pl/gry/the-witcher-3-wild-hunt/z83579", "/wiesiek.jpg"));
        this.games.add(new Game("Dark Souls: Remastered","Namco Bandai",10.20 ,
                "https://www.gry-online.pl/gry/dark-souls-remastered/ze50e4","/ds.jpg"));
        this.games.add(new Game("Dark Souls II: Scholar of the First Sin","Namco Bandai",5.20 ,
                "https://www.gry-online.pl/gry/dark-souls-ii-scholar-of-the-first-sin/zc3f12","/ds2.jpg"));
        this.games.add(new Game("Dark Souls III","Namco Bandai",5 ,
                "https://www.gry-online.pl/gry/dark-souls-iii/zf42b7","/ds3.jpg"));
    }
}
