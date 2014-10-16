package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager 
{
	/**
	 * List of users in the SQL database
	 */
	List<User> users;
	/**
	 * List of conferences in the SQL database
	 */
	List<Conference> conferences;
	/**
	 * List of papers.
	 */
	List<Paper> papers;
	/**
	 * A connection line to the database.
	 */
	Connection connection;
	/**
	 * @author Melaku Mehiretu
	 * Create a database manager that connects to the SQL database,
	 * and initializes the list of users, conferences, and papers. 
	 */
	public DatabaseManager()
	{
		conncetToDatabase();
	}
	


	/**
	 * @author Melaku Mehiretu
	 * @return List of user objects.
	 */
	public List<User> getUsers()
	{
		return users;
	}
	/**
	 * Import all users(user who have a role and who don't) from 
	 * the data base and create an object for each user
	 */
	public void initializeUsers() 
	{
		Statement stmt;
		users = new ArrayList<User>();
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM DATATABLE;" );
			while(rs.next())
			{

				
				String fName = rs.getString("firstname");
				String lName = rs.getString("lastname");
				String emailAd = rs.getString("email");
				String confTitle = rs.getString("conferencetitle");
				String confDescrip = rs.getString("conferencedescription");
				int confId = rs.getInt("ConferenceID");
				int userId = rs.getInt("userid");
				int roleid = rs.getInt("roleid");
				
				switch(roleid)
				{
				//role id = 0 or null--> author, role id= 1 --> PChair
				//role id = 2 --> SubChair, 4 = reviewer
				case 1: 
					users.add(new ProgramChair(fName, lName, 
							emailAd, userId, roleid, confId, confDescrip, confTitle));
					break;
				case 2: 
					users.add(new SubprogramChair(fName, lName,
							emailAd, userId, roleid, confId, confDescrip, confTitle));
					break;
				case 4: 
					users.add(new Reviewer(fName, lName, 
							emailAd, userId, roleid, confId, confDescrip, confTitle));
					break;
				default:
					users.add(new Author(fName, lName, emailAd, userId, roleid));
					break;
				}

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     


	}
	/**
	 * @author Melaku Mehiretu
	 * @return list of conference objects
	 */
	public List<Conference> getConferences() 
	{
		return conferences;
	}
	/**
	 * @author Melaku Mehiretu
	 * import all conferences from the database and create an object for each conference
	 */
	public void initializeConferences()
	{
		Statement stmt;
		conferences = new ArrayList<Conference>();
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM DATATABLE WHERE conferenceid IS NOT NULL;" );
			while(rs.next())
			{
				conferences.add(new Conference(rs.getInt("conferenceid"), rs.getString("conferencetitle"),
						rs.getString("conferencedescription")));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers)
	{
		this.papers = papers;
	}
	/**
	 * Connect to the database to get access to the data. 
	 */
	private final void conncetToDatabase() 
	{

		try 
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:conferenceDatabase.db.sqlite");
			//System.out.println("Opened database successfully");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

	}
	/**
	 * @author Melaku Mehiretu
	 * Create an account for a user.
	 */
	public User signUp(String fName, String lName, String email)
	{
		//get the next available user id from the data base
		System.out.println("Users size" + users.size());
		int[] userid = new int [users.size()];

		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM DATATABLE;" );
			int i = 0;
			while(rs.next())
			{
				userid[i] = rs.getInt("userid");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//find the largest user id in the data base
		int largestId = userid[0];
		for(int i = 1; i < userid.length; i++)
		{
			if(userid[i] > largestId)
			{
				largestId = userid[i];
			}
		}
		//the next avaialabe user id is largestId + 1
		//author doesn's have a role id, so the constructor needs to be changed.
		User user = new Author(fName, lName, email, largestId + 1, 0);

		//add user to users list and to the database
		addTodatabase(user);
		return user;
	}
	/**
	 * @author Melaku Mehiretu
	 * Add this user to the sql database
	 * @param user The user to be added to the database. 
	 */
	private void addTodatabase(User user) 
	{
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			String sql = "INSERT INTO DATATABLE (userid,firstname,lastname,email) " +
					"VALUES ("+user.getUserId()+", '"+ user.getFirstName()+"', '" +
					user.getLastName()+ "', '"+ user.getEmail()+"' );"; 
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * Once a user has an account, the user can register to a conference.
	 */
	public void registerToConference(Conference conference, User user)
	{
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			String sql = "UPDATE DATATABLE SET conferenceid = "+ conference.getConfId()+
					", conferencetitle = '"+ conference.getConfTitle() +"', conferencedescription = '" +
					conference.getConfDescription() + "', roleid = "+user.getRoleId()+ 
					", role = '" + user.role()+"' WHERE user id = "+ user.getUserId()+";"; 
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
