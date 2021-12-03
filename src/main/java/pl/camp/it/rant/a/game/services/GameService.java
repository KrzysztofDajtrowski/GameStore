package pl.camp.it.rant.a.game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.rant.a.game.database.GameDatabase;
import pl.camp.it.rant.a.game.model.Game;

import java.util.List;

@Component
public class GameService {
    @Autowired
    GameDatabase gameDatabase;
    public List<Game> getAllGames(){
        return this.gameDatabase.getGames();
    }

}
