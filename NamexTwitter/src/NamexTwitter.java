/**
 * @(#)NamexTwitter2.java
 *
 * NamexTwitter2 application
 *
 * @author 
 * @version 1.00 2018/5/15
 */
 

import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTwitter {
    private final static String CONSUMER_KEY = "4UZxFkeZBnvRis8SonaqUr30p";
    private final static String CONSUMER_KEY_SECRET = "7NuAaY0ooKADma49fpDnYmG4Ma2Z1L4rxSblPXQn88DnY2rOgP";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hia, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "YkkN1fB4Wc94DT19dL6qwTbnusrF3RKPjuaK4LwPN7BHr";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "2270016684-sf1TZvWnmpdPQXGvKweeScjNJz52BBjdqcnfVPx";
    }

    public static void main(String[] args) throws Exception {
	new NamexTwitter().start();
    }
}

