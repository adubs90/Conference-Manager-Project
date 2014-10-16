package Model;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class ProgramChairTest {
	
	@Test
	public void testChair() {
		File file = null;
		ProgramChair chairTest = new ProgramChair("Vladimir", "Gudzyuk", "cooCooCachoo@poop.com",
				 9 ,666, 0, "HELL", "Hyper Elementary Lessons League");
		
		Paper tester = new Paper("Why Hell is cool", "Matt Dufalo", file, 665);
		
		Paper tester2 = new Paper("Why Hell is Lame", "Vladimir Gudzyuk", file, 667);
		
		Paper tester3 = new Paper("Hell is good for kids", "Matt Dufalo", file, 668);
		
		Paper tester4 = new Paper("What the Hell?", "Alex Stringham", file, 669);
		
		Conference conf = new Conference(1, "Useless Discussions and Stuff", 
				"All programmers, Location: UWT");
		
		conf.submitPaper(tester);
		conf.submitPaper(tester2);
		conf.submitPaper(tester3);
		conf.submitPaper(tester4);
		
		//test programchair tostring method
		System.out.println(chairTest.toString());
		
		chairTest.acceptDeclinePapers(conf, "Why Hell is cool", true);
		
		assertEquals("are not true", true, tester4.acceptReject);
		
		assertEquals("are not false", false, tester3.acceptReject);
	}

}
