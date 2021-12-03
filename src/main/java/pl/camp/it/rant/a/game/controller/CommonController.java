package pl.camp.it.rant.a.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.rant.a.game.database.GameDatabase;
import pl.camp.it.rant.a.game.services.GameService;
import pl.camp.it.rant.a.game.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    GameDatabase gameDatabase;

    @Autowired
    GameService gameService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("games", this.gameService.getAllGames());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }

}
