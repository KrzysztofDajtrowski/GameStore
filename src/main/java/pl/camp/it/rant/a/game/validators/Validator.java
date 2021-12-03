package pl.camp.it.rant.a.game.validators;

public class Validator {
    public static boolean validateLogin(String login) {
        return (login.length() >= 3);
    }
    public static boolean validatePassword(String password) {
        return (password.length() >= 3);
    }
    public static boolean validateName(String name){
        return basicValidation(name);
    }
    public static boolean validateSurname(String surname){
        return basicValidation(surname);
    }
    public static boolean basicValidation(String value){
        if(value.length()<3){
            return false;
        }

        if(!Character.isUpperCase(value.charAt(0))){
            return false;
        }
        for(char c: value.toCharArray()){
            if(Character.isDigit(c)){
                return false;
            }
        }
        char[] temp = value.toCharArray();
        for(int i =1; i<temp.length; i++){
            if(Character.isUpperCase(temp[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean validateMail(String mail){
        if(mail.charAt(0) == '@'){
            return false;
        }
        if(mail.charAt(mail.length()-1)== '@'){
            return false;
        }
        if(!mail.contains("@"))
        {
            return false;
        }
        return true;
    }
}

