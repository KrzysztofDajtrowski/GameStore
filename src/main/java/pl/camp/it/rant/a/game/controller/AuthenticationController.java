package pl.camp.it.rant.a.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.rant.a.game.model.view.RegisterUser;
import pl.camp.it.rant.a.game.services.AuthenticationService;
import pl.camp.it.rant.a.game.session.SessionObject;
import pl.camp.it.rant.a.game.validators.Validator;

@Controller
public class AuthenticationController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";

    }


    @Autowired
    SessionObject sessionObject;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password){
        if(!Validator.validateLogin(login)|| !Validator.validatePassword(password)) {
            System.out.println("walidacja nieudana");
            return "redirect:/login";
        }
        this.authenticationService.authenticate(login, password);

        if(this.sessionObject.isLogged()){
            sessionObject.setLogged(true);
            return "redirect:/main";
        }
        else{
            sessionObject.setLogged(false);
            return "redirect:/login";
        }


    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.authenticationService.logout();
        return "redirect:main";
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("registerUser", new RegisterUser());
        return "register";
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterUser registerUser){
        if(!Validator.validateLogin(registerUser.getLogin())||
                !Validator.validatePassword(registerUser.getPassword()) ||
                !registerUser.getPassword().equals(registerUser.getPassword2()) ||
                !Validator.validateName(registerUser.getName()) ||
                !Validator.validateSurname(registerUser.getSurname()) ||
                !Validator.validateMail(registerUser.getMail())) {
            System.out.println("walidacja nieudana");
            return "redirect:/register";
        }
        if(this.authenticationService.register(registerUser)){
            return "redirect:/login";
        }
        return "redirect:/register";
    }
}