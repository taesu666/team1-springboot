package lx.edu.springboot.vo;

public class TravelVO {

	/**
	 *     TRAVERID           INT  NOT NULL , 
     MAXFIVE            VARCHAR (1) , 
     TRAVEL_NAME        VARCHAR (50) , 
     TRAVEL_LOCATION    VARCHAR (50) , 
     TRAVEL_DESCRIPTION VARCHAR (50) , 
     TRAVEL_IMAGE       VARCHAR (255) , 
     RESULTFATE_ID      INT  NOT NULL , 
     BAD                VARCHAR (1) 
	 */
	
	int travelId;
	int resultFateId;
	String maxFive;
	String travelName;
	String travelLocation;
	String travelDescription;
	String travelImage;
	String bad;
	
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public int getResultFateId() {
		return resultFateId;
	}
	public void setResultFateId(int resultFateId) {
		this.resultFateId = resultFateId;
	}
	public String getMaxFive() {
		return maxFive;
	}
	public void setMaxFive(String maxFive) {
		this.maxFive = maxFive;
	}
	public String getTravelName() {
		return travelName;
	}
	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}
	public String getTravelLocation() {
		return travelLocation;
	}
	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
	}
	public String getTravelDescription() {
		return travelDescription;
	}
	public void setTravelDescription(String travelDescription) {
		this.travelDescription = travelDescription;
	}
	public String getTravelImage() {
		return travelImage;
	}
	public void setTravelImage(String travelImage) {
		this.travelImage = travelImage;
	}
	public String getBad() {
		return bad;
	}
	public void setBad(String bad) {
		this.bad = bad;
	}
	
	@Override
	public String toString() {
		return "TravelVO [travelId=" + travelId + ", resultFateId=" + resultFateId + ", maxFive=" + maxFive
				+ ", travelName=" + travelName + ", travelLocation=" + travelLocation + ", travelDescription="
				+ travelDescription + ", travelImage=" + travelImage + ", bad=" + bad + "]";
	}
	
}
