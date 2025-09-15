package lx.edu.springboot.vo;

public class PartnerVO {
		int partnerID;
	    String partnerName;
	     String partnerBirth;
	     String partnerGender;
	     String partnerTime;
		public int getPartnerID() {
			return partnerID;
		}
		public void setPartnerID(int partnerID) {
			this.partnerID = partnerID;
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
			return "PartnerVO [partnerID=" + partnerID + ", partnerName=" + partnerName + ", partnerBirth="
					+ partnerBirth + ", partnerGender=" + partnerGender + ", partnerTime=" + partnerTime + "]";
		}


}
