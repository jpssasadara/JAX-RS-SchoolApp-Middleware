package org.jps.sasadara.schoolApp.models;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Subject {
	
	
	public Subject() {
    	
    }
    

	
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_id() {
		return sub_id;
	}
	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Subject( String sub_id,String sub_name, String credit, String duration) {
		super();
		
		this.sub_id = sub_id;
		this.sub_name = sub_name;
		this.credit = credit;
		this.duration = duration;
	}


	
	private String sub_id;
	private String sub_name;
	private String credit;
	private String duration;
	
	
	

   
    
	
	
	
}
