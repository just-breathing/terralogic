package assessment.terralogic.authentication.entity;

public class UserUpdate {
    private String newUserName;
    private String oldUserName;

    public String getNewUserName() {
        return newUserName;
    }
    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }
    public String getOldUserName() {
        return oldUserName;
    }
}
