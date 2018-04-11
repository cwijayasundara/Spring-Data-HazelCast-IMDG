package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;

@KeySpace("tweet")
public class Tweet implements Comparable<Tweet>, Serializable {

    @Id
    private Long tweetid;
    private String user;
    private String message;

    @Override
    public int compareTo(Tweet that){
        return getTweetid().compareTo(that.getTweetid());
    }

    public Long getTweetid() {
        return tweetid;
    }

    public void setTweetid(Long tweetid) {
        this.tweetid = tweetid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetid=" + tweetid +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
