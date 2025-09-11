package lx.edu.springboot.vo;

public class CoupleResultVO {
  
	private int resultCoupleId;
    private String userName;
    private String partnerName;
    private int score;
    private String love;
    private String partner;
    private String total;
    private int inputCoupleId; // FK (INPUTCOUPLE 참조)

    // getter/setter
    public int getResultCoupleId() {
        return resultCoupleId;
    }
    public void setResultCoupleId(int resultCoupleId) {
        this.resultCoupleId = resultCoupleId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getLove() {
        return love;
    }
    public void setLove(String love) {
        this.love = love;
    }
    public String getPartner() {
        return partner;
    }
    public void setPartner(String partner) {
        this.partner = partner;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public int getInputCoupleId() {
        return inputCoupleId;
    }
    public void setInputCoupleId(int inputCoupleId) {
        this.inputCoupleId = inputCoupleId;
    }
    
    @Override
  	public String toString() {
  		return "CoupleResultVO [resultCoupleId=" + resultCoupleId + ", userName=" + userName + ", partnerName="
  				+ partnerName + ", score=" + score + ", love=" + love + ", partner=" + partner + ", total=" + total
  				+ ", inputCoupleId=" + inputCoupleId + "]";
  	}
}
