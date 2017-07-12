/**
 * Created by Dell-SSD on 05.07.2017.
 */
public enum ERROR {


    LOGIN_ERROR("FAILED TRY TO LOGIN",1), INVALID_EMAIL_ERROR("USER USED NOT VALID EMAIL",2)
    , SEND_MESSAGE_ERROR("FAIL TO SEND MESSAGE",4), MISSING_LINK("MISSED LINK",3);



    private String message;
    private int errorId;


    public String getMessage() {
        return message;
    }
    public int getErrorId() {
        return errorId;
    }



    ERROR(String message, int errorId){
        this.message = message;
        this.errorId = errorId;
    }

}
