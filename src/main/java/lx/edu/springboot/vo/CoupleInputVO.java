package lx.edu.springboot.vo;

public class CoupleInputVO {
    private int inputCoupleId;
    private String userName;
    private String userBirth;
    private String userGender;
    private String userTime;
    private String partnerName;
    private String partnerBirth;
    private String partnerGender;
    private String partnerTime;

    // getter/setter
    public int getInputCoupleId() {
        return inputCoupleId;
    }
    public void setInputCoupleId(int inputCoupleId) {
        this.inputCoupleId = inputCoupleId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserBirth() {
        return userBirth;
    }
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }
    public String getUserGender() {
        return userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public String getUserTime() {
        return userTime;
    }
    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }
    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public String getPartnerBirth() {
        return partnerBirth;
    }
    public void setPartnerBirth(String partnerBirth) {
        this.partnerBirth = partnerBirth;
    }
    public String getPartnerGender() {
        return partnerGender;
    }
    public void setPartnerGender(String partnerGender) {
        this.partnerGender = partnerGender;
    }
    public String getPartnerTime() {
        return partnerTime;
    }
    public void setPartnerTime(String partnerTime) {
        this.partnerTime = partnerTime;
    }
	@Override
	public String toString() {
		return "CoupleInputVO [inputCoupleId=" + inputCoupleId + ", userName=" + userName + ", userBirth=" + userBirth
				+ ", userGender=" + userGender + ", userTime=" + userTime + ", partnerName=" + partnerName
				+ ", partnerBirth=" + partnerBirth + ", partnerGender=" + partnerGender + ", partnerTime=" + partnerTime
				+ "]";
	}
}
