package Model;

import java.io.File;

import javax.swing.JOptionPane;



/***
 * 
 * @author Matt Dufalo
 * Last Edited 2/24/2014
 * 
 * This Class represents a paper object.
 *
 */

public class Paper implements java.io.Serializable {
	
	String title;
	String authorName;
	File file;
	File[] reviews = new File[3];
	boolean reviewStatus;
	boolean acceptReject;
	int paperId;
	User[] Reviewers = new User[4];
	/**
	 * @author Matt
	 * This class constructs the paper object.
	 * 
	 * title - The title of a paper
	 * authorName - the author of the papers name.
	 * fileName - the filename of the paper.
	 *
	 */
	public Paper(String title, String authorName, File fileName, int id)
	{
		this.title = title;
		this.authorName = authorName;
		this.file = fileName;
		this.paperId = id;
	}
	/**
	 * 
	 *@author Matt Dufalo
	 * @return the file associated with the paper in this object.
	 */
	public File getFile()
	{
		return file;
	}
	
	/**
	 * @author Matt Dufalo
	 * returns name of author on this paper object.
	 */
	public String getAuthor()
	{
		return this.authorName;
	}
	
	/**
	 * Author: Matt
	 * 
	 * @return The title of this paper.
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Author: Matt
	 * @return A string representing whether or not a paper has been reviewed
	 */
	public String getReviewStatus()
	{
		if(reviewStatus == true)
		{
			return "Reviewed.";
		} else {
			return "Not yet reviewed.";
		}
		
	}
	
	/**
	 * Author: Matt
	 * Sets review status to true once paper has received review.
	 */
	public void setReviewStatus()
	{
		reviewStatus = true;
	}
	
	/**
	 * Author: Matt
	 * @return whether or not a paper has been accepted
	 */
	public String getAcceptRejectStatus()
	{
		String status;
		if (acceptReject == true)
		{
			return "Accepted.";
		} else {
			return "This paper has not been accepted.";
		}
	}
	/**
	 * Author: Matt
	 * @param status True if paper is accpted, false otherwise
	 */
	public void setAcceptRejectStatus(boolean status)
	{
		acceptReject = status;
	}
	
	/**
	 * Author: Matt
	 * 
	 * Assigns name of reviewer to this paper object
	 * @param name The name of the reviewer
	 */
	public void setReviewer(Reviewer person)
	{
		if(Reviewers[2] != null)
		{
			JOptionPane.showMessageDialog(null, "Too many reviewers assigned,cannot make assignment.");
		} else {
		 int i = 0;
		 while(Reviewers[i] != null)
		 {
			 i++;
		 }
		 Reviewers[i] = person;
		}
	}
	
	/**
	 * Author: Matt Dufalo
	 * @return The name of all the reviewers assigned to this paper.
	 */
	public String getReviewer()
	{
		if (Reviewers[0] == null)
		{
			return "No reviewer assigned yet.";
		} else {
			String reviewers = "\n";
			int i = 0;
			while (Reviewers[i] != null && i < 3)
			{
				reviewers +=  Reviewers[i].getFirstName() + " " + Reviewers[i].getLastName();
				if(i < 3)
				{
					i++;
				}
				if(i < 3 && Reviewers[i] != null)
				{
					reviewers += "\n ";
				}
				
			}
			return reviewers;
		}
	}
	/**
	 * @author Matt Dufalo
	 * 
	 * Get a specific review
	 * @param n the index for requested reviewer
	 * @return reviewers name
	 */
	public String getTheReviewer(int n)
	{
		if(Reviewers[n] != null)
		{
			return Reviewers[n].getFirstName() + " " + Reviewers[n].getLastName();
		}
		else {
			return "";
		}
	}
	/**
	 * Author: Matt Dufalo
	 * 
	 * Sets the review to this paper.
	 */
	public void setReview(File theReview)
	{
		int i = 0;
		 while(reviews[i] != null)
		 {
			 i++;
		 }
		 reviews[i] = theReview;
	}
	
	/**
	 * Author: Matt Dufalo
	 * @return The reviews attached to this paper.
	 */
	public File getReview(int n)
	{
		return reviews[n];
	}
	
	
	
	@Override
	public String toString()
	{
	
		return title;
	}
	public String getFullStatus()
	{
		StringBuilder paperInfo = new StringBuilder();
		paperInfo.append("Title: "+ title + "\n");
		paperInfo.append("Author: " + authorName + "\n");
		paperInfo.append("Paper ID #: " + paperId + "\n");
		paperInfo.append("Reviewers: " + getReviewer() + "\n");
		paperInfo.append(getReviewStatus()+ "\n");
		paperInfo.append(getAcceptRejectStatus()+ "\n");
		return paperInfo.toString();
	}

}
