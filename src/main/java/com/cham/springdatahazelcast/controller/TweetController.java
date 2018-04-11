package com.cham.springdatahazelcast.controller;

import com.cham.springdatahazelcast.repository.TweetHazelcastRepository;
import domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;

@Controller
@RequestMapping(path = "/api")
public class TweetController {

    @Autowired
    private TweetHazelcastRepository  tweetHazelcastRepository;

    @GetMapping("/tweet")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> tweets(@RequestParam("message") String message) {

        System.out.println("Inside TweetController.tweets..");

        Instant start = Instant.now();

        for(Long count=1L;count<100000;count++) {
            Tweet tweet = new Tweet();
            tweet.setTweetid(count);
            tweet.setUser("Chaminda");
            tweet.setMessage(message);
            tweetHazelcastRepository.save(tweet);
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken to save 100,000 messages is " + timeElapsed.toMillis() + " milliseconds");

        return new ResponseEntity<Object>("OK", HttpStatus.OK);
    }

    @GetMapping("/tweets/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Tweet> getTweetById(@PathVariable("id") String id){

        Instant start = Instant.now();

        Tweet tweet = tweetHazelcastRepository.findOne(Long.parseLong(id));

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("Time taken to retreave a tweet by id is " + timeElapsed.toMillis() + " milliseconds");
        return new ResponseEntity<Tweet>(tweet,  HttpStatus.OK);
    }

    @GetMapping("/tweets")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> getAllTweets(){

        Instant start = Instant.now();
        Iterable<Tweet> tweet = tweetHazelcastRepository.findAll();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken to retreave 100,000 messages is " + timeElapsed.toMillis() + " milliseconds");

        return new ResponseEntity<Object>(tweet, HttpStatus.OK);
    }
}
