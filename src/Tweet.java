import java.util.ArrayList;

/**
 * Tweet object storing all information for any given tweet
 */
public class Tweet {
    private static int currentTweetID = -1;
    private final String content;
    private final int tweetID;
    //poster ID
    private final int userID;

    //All tweets contained in static arraylist, getter method used so all levels can view
    private static final ArrayList<Tweet> tweets = new ArrayList<>();

    public Tweet(int userID, int tweetID, String content){
        //describe all attributes of tweet
        this.content = content;
        this.tweetID = tweetID;
        this.userID = userID;
        //add self to full list of tweets
        tweets.add(this);
    }

    public String getContent(){
        return content;
    }

    public int getTweetID(){
        return tweetID;
    }

    public int getTweeterID(){
        return userID;
    }

    /**
     * Creates new tweet ID sequentially
     * @return - new tweet ID
     */
    public static int getNewTweetID(){
        currentTweetID++;
        return currentTweetID;
    }

    public static ArrayList<Tweet> getTweets(){
        return tweets;
    }

}
