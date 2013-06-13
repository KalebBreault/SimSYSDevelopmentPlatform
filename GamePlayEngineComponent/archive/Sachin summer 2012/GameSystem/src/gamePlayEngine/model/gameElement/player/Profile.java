/**
 * Profile Model for Player. Player contains a profile
 */
package gamePlayEngine.model.gameElement.player;

import java.util.Date;
import java.util.List;
import java.util.Observable;

public class Profile extends Observable {

	private Date availability;
	private String communication;
	private List<String> degrees;
	private String demographics;
	private int experienceYears;
	private String leadership;
	private String resumePhotoLink;
	private List<String> skills;
	private String teamwork;
	private String title;

	public Date getAvailability() {
		return availability;
	}

	public String getCommunication() {
		return communication;
	}

	public List<String> getDegrees() {
		return degrees;
	}

	public String getDemographics() {
		return demographics;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public String getLeadership() {
		return leadership;
	}

	public String getResumePhotoLink() {
		return resumePhotoLink;
	}

	public List<String> getSkills() {
		return skills;
	}

	public String getTeamwork() {
		return teamwork;
	}

	public String getTitle() {
		return title;
	}

	public void setAvailability(Date availability) {
		this.availability = availability;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public void setLeadership(String leadership) {
		this.leadership = leadership;
	}

	public void setResumePhotoLink(String resumePhotoLink) {
		this.resumePhotoLink = resumePhotoLink;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void setTeamwork(String teamwork) {
		this.teamwork = teamwork;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
