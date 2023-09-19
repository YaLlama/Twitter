import java.util.ArrayList;
import java.util.List;

/**
 * Class handles all user interactions so that main twitter doc is streamlined and simple
 */
public class User {
    private final ArrayList<User> following;
    private final ArrayList<Tweet> tweets;
    private final int userID;

    public User(int userID) {
        //initializing defining components
        this.userID = userID;
        following = new ArrayList<>();
        tweets = new ArrayList<>();
    }

    public int getUserID(){
        return userID;
    }

    public void post(int tweetID, String content){
        Tweet newTweet = new Tweet(userID, tweetID, content);
        tweets.add(0, newTweet);
    }

    /**
     * Finds 10 most recent tweets made by those following
     * @return list of tweet IDs
     */
    public List<Integer> getNewsFeed(){
        final List<Integer> tweets = new ArrayList<>();
        //for any given tweet
        for(Tweet tweet : Tweet.getTweets()){
            int tweeterID = tweet.getTweeterID();
            //search through all following
            for(User followee : following){
                //if the poster is on the following list
                if(tweeterID == followee.getUserID()){
                    tweets.add(tweet.getTweetID());
                    //Max tweets to be returned
                    if(tweets.size() == 10){
                        return tweets;
                    }
                    //since only one person can post a tweet
                    break;
                }
            }
        }
        return tweets;
    }

    public void follow(User user){
        following.add(user);
    }

    public void unfollow(User user){
        following.remove(user);
    }

    public List<Tweet> getFeed(){
        return tweets;
    }
}
