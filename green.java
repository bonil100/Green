import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;
import java.util.List;
import java.util.Scanner;

public class green
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

        Scanner input = new Scanner(System.in);
        System.out.println("How do you want to search for climate change news?" + "\n");
        System.out.println("Enter 'user' to search popular environmental users." + "\n");
        System.out.println("Enter 'search' to search by environmental related queries" + "\n");

        String response = input.nextLine();


        //get home timeline
        //my account follows only environmental accounts--> showing environmental news posted by popular environmental accounts
        //this shows tweets by popular environmental users on my home timeline
        if (response.equals("user"))
        {
            try
            {
                List<Status> status = twitter.getHomeTimeline();
                System.out.println("Showing home timeline.");
                for (Status s : status)
                {
                    System.out.println(s.getUser().getName() + ":" + s.getText() + "\n");
                }
            }
        
            catch (TwitterException te)
            {
                te.printStackTrace();
                System.out.println("Error: " + te.getMessage());
                System.exit(-1);
            }
    
        }
        
        //search queries related to climate change 
        //twitter api allows search of 100 tweets at a time.
        else if (response.equals("search"))
        {
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
                System.out.println("@" + s.getUser().getName() + ":" + s.getText() + "\n");
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
                    System.out.println("@" + s.getUser().getName() + ":" + s.getText() + "\n");
                }
            }
        
            catch (TwitterException te)
            {
                te.printStackTrace();
                System.out.println("Error: " + te.getMessage());
                System.exit(-1);
            }

            System.out.println("\n" + "The following are public tweets related to the search: environmental rallies." + "\n");
            
            try
            {
                Query query = new Query("environmental rallies");
                QueryResult result;
                result = twitter.search(query);
                List<Status> status = result.getTweets();
                for (Status s : status)
                {
                    System.out.println("@" + s.getUser().getName() + ":" + s.getText() + "\n");
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

}