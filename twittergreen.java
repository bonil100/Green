import twitter4j.*;
import twitter4j.auth.AccessToken;


import java.util.List;


public class twittergreen
{

	public static void main(String[] args)
	{
		Twitter twitterFactory = new TwitterFactory();
		Twitter twitter = twitterFactory.getInstance();

		twitter.setOAuthConsumerKey("J4esNudphsCsCki7L3NNg3dxx");
		twitter.setOAuthConsumerSecret("Z2UCKb3JWL3jRy1PGTPYuzPDFboF8jJnkQeTlXQLVg8DP7xPjq");
		twitter.setOAuthAccessToken("775047840250732544-9F3LQWH9czrpVJzd9Ab3sXbSjXxDaBy");
		twitter.setOAuthAccessTokenSecret("ByvhyeUj4bOED2YGh91F9ktQSr2EslrUL9fUxF1LZtL8i");

		//search related to "climatechange"
		Query search1 = new Query("climatechange");

		//only 100 tweets per page allowed
		query.count(100);

		QueryResult result = twitter.search(search1);

		//***NEED TO LOOP IN ORDER TO SEARCH MORE THAN 100 TWEETS***

		//print out result of query
		System.out.println("These are the tweets related to your search.");

		//GETTING TWEETS FROM A SPECIFIC USER
		//WANT TO DO IT FOR SPECIFIC USER, SO NEED TO SET USERNAME TO SPECIFIC USER
		try{
			List<Status> status;
			String username;
			if (args.length == 1)
			{
				username = args[0];
				status = twitter.getUserTimeline(user);

			}
			else
			{
				username = twitter.verifyCredentials().getScreenName();
				status = twitter.getUserTimeline();
			}
			System.out.println("This is @" + username + " 's timeline.");
			for (Status status : statuses)
			{
				System.out.println("@" + status.getUser().getScreenName + ":" + status.getText());
			}
		}
		catch (TwitterException exception)
		{
			exception.printStackTrace();
			System.out.println("Failed to get timeline.");
			System.exit(-1);
		}


	}
}


