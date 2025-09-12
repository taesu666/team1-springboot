package lx.edu.springboot.vo;

public class ConversationVO {

    int resultfateID;
    String userName;
    int resultcoupleID;

    public int getResultfateID() {
        return resultfateID;
    }
    public void setResultfateID(int resultfateID) {
        this.resultfateID = resultfateID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getResultcoupleID() {
        return resultfateID;
    }
    public void setResultcoupleID(int resultcoupleID) {
        this.resultcoupleID = resultcoupleID;
    }
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "ConversationVO [resultfateID=" + resultfateID + ", userName=" + userName + "]";
    }
}
