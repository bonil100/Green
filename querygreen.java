import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;
import java.util.List;

public class querygreen
{
	public static void main(String[] args)
	{
        //authentication keys and tokens
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
            .setOAuthConsumerKey("J4esNudphsCsCki7L3NNg3dxx")
            .setOAuthConsumerSecret("Z2UCKb3JWL3jRy1PGTPYuzPDFboF8jJnkQeTlXQLVg8DP7xPjq")
            .setOAuthAccessToken("775047840250732544-9F3LQWH9czrpVJzd9Ab3sXbSjXxDaBy")
            .setOAuthAccessTokenSecret("ByvhyeUj4bOED2YGh91F9ktQSr2EslrUL9fUxF1LZtL8i");
        
        //get new twitter instance    
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        //search queries related to climate change 
        //api allows search of 100 tweets at a time.
        System.out.println("Showing tweets related to the search: climate change.");
        System.out.println(" ");
        try
        {
            Query query = new Query("climatechange");
            QueryResult result;
            result = twitter.search(query);
            List<Status> status = result.getTweets();
            for (Status s : status)
            {
                System.out.println("@" + s.getUser().getName() + ":" + s.getText());
            }
        }
        
        catch (TwitterException te)
        {
            te.printStackTrace();
            System.out.println("Error: " + te.getMessage());
            System.exit(-1);
        }

        System.out.println(" ");
        System.out.println("The following are public tweets related to the search: globalwarming.");
        System.out.println(" ");
        try
        {
            Query query = new Query("globalwarming");
            QueryResult result;
            result = twitter.search(query);
            List<Status> status = result.getTweets();
            for (Status s : status)
            {
                System.out.println("@" + s.getUser().getName() + ":" + s.getText());
            }
        }
        
        catch (TwitterException te)
        {
            te.printStackTrace();
            System.out.println("Error: " + te.getMessage());
            System.exit(-1);
        }

	}

}