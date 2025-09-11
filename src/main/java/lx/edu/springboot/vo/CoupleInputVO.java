package lx.edu.springboot.vo;

public class CoupleInputVO {
    private int inputCoupleId;
    private String userName;
    private java.sql.Date userBirth;
    private String userGender;
    private java.sql.Date userTime;
    private String partnerName;
    private java.sql.Date partnerBirth;
    private String partnerGender;
    private java.sql.Date partnerTime;

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
    public java.sql.Date getUserBirth() {
        return userBirth;
    }
    public void setUserBirth(java.sql.Date userBirth) {
        this.userBirth = userBirth;
    }
    public String getUserGender() {
        return userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public java.sql.Date getUserTime() {
        return userTime;
    }
    public void setUserTime(java.sql.Date userTime) {
        this.userTime = userTime;
    }
    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public java.sql.Date getPartnerBirth() {
        return partnerBirth;
    }
    public void setPartnerBirth(java.sql.Date partnerBirth) {
        this.partnerBirth = partnerBirth;
    }
    public String getPartnerGender() {
        return partnerGender;
    }
    public void setPartnerGender(String partnerGender) {
        this.partnerGender = partnerGender;
    }
    public java.sql.Date getPartnerTime() {
        return partnerTime;
    }
    public void setPartnerTime(java.sql.Date partnerTime) {
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
