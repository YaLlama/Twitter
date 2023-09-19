import java.util.ArrayList;
import java.util.List;

public class Twitter {
    //All users contained in arraylist
    private final ArrayList<User> users;

    public Twitter(){
        //initialize arraylists
        users = new ArrayList<>();
    }

    //External handler for posting tweets
    public void postTweet(int userID, String content){
        User user = getUser(userID);
        user.post(Tweet.getNewTweetID(), content);
    }

    /**
     * Handles retrieving user object ensuring there are never null object references
     * @param userID - userID (integer)
     * @return user object
     */
    private User getUser(int userID){
        for (User user : users){
            if(user.getUserID() == userID){
                return user;
            }
        }
        //if user not found, create
        User newUser = new User(userID);
        users.add(0, newUser);
        return newUser;
    }

    public void follow(int followerId, int followeeId){
        getUser(followerId).follow(getUser(followeeId));
    }
    public void unfollow(int followerId, int followeeId){
        getUser(followerId).unfollow(getUser(followeeId));
    }
    public List<Integer> getNewsFeed(int userID){
        return getUser(userID).getNewsFeed();
    }

}
