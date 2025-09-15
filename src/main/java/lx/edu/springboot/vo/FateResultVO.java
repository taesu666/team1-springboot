package lx.edu.springboot.vo;

public class FateResultVO {
	
	int resultFateId;
	String userName;
	String maxFive;
	int tree;
	int fire;
	int soil;
	int steel;
	int water;
	String total;
	String love;
	String money;
	@Override
	public String toString() {
		return "FateResultVO [resultFateId=" + resultFateId + ", userName=" + userName + ", maxFive=" + maxFive
				+ ", tree=" + tree + ", fire=" + fire + ", soil=" + soil + ", steel=" + steel + ", water=" + water
				+ ", total=" + total + ", love=" + love + ", money=" + money + ", health=" + health + ", job=" + job
				+ ", resultType=" + resultType + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	String health;
	String job;
	int resultType;
	
	public int getResultType() {
		return resultType;
	}
	public void setResultType(int resultType) {
		this.resultType = resultType;
	}
	
	public int getResultFateId() {
		return resultFateId;
	}
	public void setResultFateId(int resultFateId) {
		this.resultFateId = resultFateId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMaxFive() {
		return maxFive;
	}
	public void setMaxFive(String maxFive) {
		this.maxFive = maxFive;
	}
	public int getTree() {
		return tree;
	}
	public void setTree(int tree) {
		this.tree = tree;
	}
	public int getFire() {
		return fire;
	}
	public void setFire(int fire) {
		this.fire = fire;
	}
	public int getSoil() {
		return soil;
	}
	public void setSoil(int soil) {
		this.soil = soil;
	}
	public int getSteel() {
		return steel;
	}
	public void setSteel(int steel) {
		this.steel = steel;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	

	

	
	
}
