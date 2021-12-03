package pl.camp.it.rant.a.game.model.view;

import pl.camp.it.rant.a.game.model.User;

public class RegisterUser extends User {
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    private String password2;
}
