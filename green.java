/**
*	Uses Twitter API to gather tweets about climate change
*	Uses preset search queries and personal home timeline
*
*	@author: Courtney Bonilla
*/


import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;
import java.util.List;
import java.util.Scanner;

public class green
{
    public static void main(String[] args)
    { 
        int count = 0;

        //authentication keys and tokens from my twitterdevelopers account
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("J4esNudphsCsCki7L3NNg3dxx")
            .setOAuthConsumerSecret("Z2UCKb3JWL3jRy1PGTPYuzPDFboF8jJnkQeTlXQLVg8DP7xPjq")
            .setOAuthAccessToken("775047840250732544-9F3LQWH9czrpVJzd9Ab3sXbSjXxDaBy")
            .setOAuthAccessTokenSecret("ByvhyeUj4bOED2YGh91F9ktQSr2EslrUL9fUxF1LZtL8i");
        
        //get new twitter instance    
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        while(count == 0)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("\n" + "How do you want to search for climate change news?" + "\n");
            System.out.println("Enter 'user' to search popular environmental users." + "\n");
            System.out.println("Enter 'search' to search by environmental related queries" + "\n");

            String response = input.nextLine();

            System.out.println(" ");

            //get home timeline
            //my account follows only environmental accounts--> showing environmental news posted by popular environmental accounts
            //this shows tweets by popular environmental users on my home timeline
            if (response.equals("user"))
            {
                try
                {
                	//get tweets from home timeline
                    List<Status> status = twitter.getHomeTimeline();
                    System.out.println("Showing home timeline of environmental users. \n");

             		//print the list of tweets gathered in this format: user: tweet
                    for (Status s : status)
                    {
                        System.out.println(s.getUser().getName() + ":" + s.getText() + "\n");
                    }
                }
            
                catch (TwitterException te) //throws twitterexception
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
                System.out.println("\n The following are public tweets related to the search: climatechange. \n");
                
                try
                {   
                	//set new search query 
                    Query query = new Query("climatechange");
                    QueryResult result;
                    result = twitter.search(query);
                    List<Status> status = result.getTweets();  //get the results and list them 
                    for (Status s : status)
                    {
                    System.out.println("@" + s.getUser().getName() + ":" + s.getText() + "\n"); //format for result tweets-> user: tweet
                    }																			//with \n new line in between for readability
                }
            
                catch (TwitterException te)
                {
                    te.printStackTrace();
                    System.out.println("Error: " + te.getMessage());
                    System.exit(-1);
                }

                System.out.println("--------------------------------------------------------------------------------- ");
                System.out.println("The following are public tweets related to the search: globalwarming. \n");
               
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

                System.out.println("------------------------------------------------------------------------------------");
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

            else
            {
                System.out.println("Invalid input. Please try again.");
                count = 0;
            }

            //continued user input, allows for new search
            Scanner input2 = new Scanner(System.in);
            System.out.println("Do you want to search again? Enter 'yes' or 'no' . ");
            String response2 = input2.nextLine();

            if (response2.equals("yes"))
            {
                count = 0;
            }
            else if (response2.equals("no"))
            {
                System.out.println("Done searching.");
                count = 1;
            }
            else
            {
                System.out.println("Invalid input. Exiting program.");
                count = 1;
            }

        }

    }
}