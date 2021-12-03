package pl.camp.it.rant.a.game.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.rant.a.game.database.UserDatabase;
import pl.camp.it.rant.a.game.model.User;
import pl.camp.it.rant.a.game.model.view.RegisterUser;
import pl.camp.it.rant.a.game.session.SessionObject;

import javax.annotation.Resource;

@Component
public class AuthenticationService {

    @Autowired
    UserDatabase userDatabase;

    @Resource
    SessionObject sessionObject;

    public void authenticate(String login, String password){
        User user = this.userDatabase.getUserByLogin(login);
        if(user != null && user.getPassword().equals(DigestUtils.md5Hex(password))){
            this.sessionObject.setLogged(true);
        }
    }
    public void logout(){
        sessionObject.setLogged(false);
    }
    public boolean register(RegisterUser registerUser){
        if(registerUser.getPassword().equals(registerUser.getPassword2()) &&
                this.userDatabase.getUserByLogin(registerUser.getLogin()) == null){
            registerUser.setPassword(DigestUtils.md5Hex(registerUser.getPassword()));
            this.userDatabase.addUser(registerUser);
            return true;
        }else{
            return false;
        }
    }
}
