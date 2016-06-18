package com.voteitup.BEAN;

public class PollBean {

	
	String polloption,polltitle,timestamp,email,name,totalvotes,IP;
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getTotalvotes() {
		return totalvotes;
	}

	public void setTotalvotes(String totalvotes) {
		this.totalvotes = totalvotes;
	}

	int votes;

	public int getVotes() {
		return votes;
	}

	public void setVotes(int i) {
		this.votes = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolltitle() {
		return polltitle;
	}

	public void setPolltitle(String polltitle) {
		this.polltitle = polltitle;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPolloption() {
		return polloption;
	}

	public void setPolloption(String polloption) {
		this.polloption = polloption;
	}
}
