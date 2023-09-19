import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Twitter twitter = new Twitter();
        twitter.postTweet(1, "5"); // User 1 posts a new tweet (id = 0).
        twitter.postTweet(2, "hello"); // User 2 posts a new tweet (id = 1).
        twitter.follow(1,2); // User 1 follows user 2.
        printList(twitter.getNewsFeed(1), 1);  // User 1's news feed should return a list with 1 tweet id -> [1].
        twitter.postTweet(3,"new"); // User 3 posts a new tweet (id = 2).
        twitter.postTweet(2, "6"); // User 2 posts a new tweet (id = 3).
        printList(twitter.getNewsFeed(1), 1);  // User 1's news feed should return a list with 2 tweet ids -> [1, 3]. Tweet number should be sequential as that was the order they were posted in.
        twitter.follow(1,3); // User 1 follows user 3.
        printList(twitter.getNewsFeed(1), 1);  // User 1's news feed should return a list with 3 tweet ids -> [1, 2, 3]. Tweet number should be sequential as that was the order they were posted in.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        printList(twitter.getNewsFeed(1), 1);  // User 1's news feed should return a list with 1 tweet id -> [2], since user 1 is no longer following user 2.
    }

    //viewing function to see whats happening
    private static void printList(List<Integer> tweetIDs, int user){
        System.out.print("User " + user + "'s news feed IDs: ");
        for(int tweetID : tweetIDs){
            System.out.print(tweetID + " ");
        }
        System.out.println();
    }
}