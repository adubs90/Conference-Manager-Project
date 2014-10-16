package Model;

import java.util.List;

public class ProgramChair extends User
{
	//will use this number and updated it as users are created and will update global count
	private int myConfId;
	
	private String myConfTitle;
	
	private String myConfDescription;
	/**
	 * @author Vladimir Gudzyuk
	 * creates a program chair
	 */
	
	DatabaseManager theData;
	
	public ProgramChair(String fName, String lName, String emailAd, 
			int theUserId, int theRoleId, int confId,
			String conferenceDescription, String confTitle) 
	{
		super(fName, lName, emailAd,
				theUserId);
		
		myConfId = confId;
		setRole("Program Chair", 1);
		setMyConfTitle(confTitle);
		setMyConfDescription(conferenceDescription);
		
		theData = new DatabaseManager();
	}
	
	/**
	 * @author Vladimir Gudzyuk
	 * returns list of papers in a specific conference
	 */
	public List<Paper> viewAllSubmittedPaperStatus(Conference conf) 
	{
		return conf.getPapers();
	}
	/**
	 * @author Vladimir Gudzyuk
	 * creates a SubProgramChair/ need to see subprogram chair class
	 */
	public void designateSubProgramChairs(Conference conf, User theUser) 
	{
		
		theUser.setRole("Subprogram Chair", 2);
		
		theData.registerToConference(conf, theUser);
	}
	/**
	 * @author Vladimir Gudzyuk
	 * finds the papers and sets its accept/decline status
	 */
	public void acceptDeclinePapers(Conference conf, 
			String title, boolean acceptStatus)
	{
		for (int i =0; i < conf.getPapers().size(); i++)
		{
			//if the title of the papers equals title in conference paper list
			if (conf.getPapers().get(i).title.equals(title)) 
					{
				conf.getPapers().get(i).acceptReject = acceptStatus;
			}
		}
		
	}
	/**
	 * @author Vladimir Gudzyuk
	 * 
	 */
	public void assignPapersToSubChairs(SubprogramChair SubChair, Paper thePaper) 
	{
		SubChair.addPaperToList(thePaper.paperId);
	}


	public String getMyConfTitle() {
		return myConfTitle;
	}

	public void setMyConfTitle(String myConfTitle) {
		this.myConfTitle = myConfTitle;
	}

	public String getMyConfDescription() {
		return myConfDescription;
	}

	public void setMyConfDescription(String myConfDescription) {
		this.myConfDescription = myConfDescription;
	}
	
	public int getConfId() {
		return myConfId;
	}
	@Override
	public String toString() 
	{
		StringBuilder ProgramChairInfo = new StringBuilder();
		
		ProgramChairInfo.append("Name: "+ this.getLastName()+ ","+ this.getLastName());
		ProgramChairInfo.append("\nEmail: "+ this.getEmail());
		ProgramChairInfo.append("\nRole Id: " + this.getRoleId());
		ProgramChairInfo.append("Role ;  Program Chair" );
		
		ProgramChairInfo.append("\nConference Title ;" + myConfTitle );
		ProgramChairInfo.append("\nConference Description ;" + myConfDescription );
		
		return ProgramChairInfo.toString();
	}

}
