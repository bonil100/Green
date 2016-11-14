import facebook4j.*;
import java.util.List;

public class facebookgreen
{

	publilc static void main(String[] args)
	{
		Facebook fbFactory = new FacebookFactory();
		Facebook fb = fbFactory.getInstance();

		fb.setOAuthAppID("J4esNudphsCsCki7L3NNg3dxx");
		fb.setOAuthAppSecret("");
		fb.setOAuthPermissions("");
		fb.setOAuthAccessToken("775047840250732544-9F3LQWH9czrpVJzd9Ab3sXbSjXxDaBy")

	
		// get page tokens
		ResponseList<Account> accounts = fb.getAccounts();
		Account account1 = accounts.get("index of page"); // fill in index of page with the page account
		String pageToken = account1.getAccessToken();

		//get public posts

		ResponseList<Post> post = facebook.searchPosts("climate change");

		System.out.println("These are facebook posts related to climate change " + post);

		//get events 

		ResponseList<Event> event = facebook.searchEvents("climate change");
		System.out.println("These are events related to climate change " + event);

		//get Groups

		ResponseList<Group> group = facebook.searchGroups("climate change");
		System.out.println("These are groups that are related to climate change" + group);













	}
}