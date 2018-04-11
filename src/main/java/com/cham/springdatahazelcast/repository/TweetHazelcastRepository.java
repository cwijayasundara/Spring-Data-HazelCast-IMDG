package com.cham.springdatahazelcast.repository;

import domain.Tweet;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface TweetHazelcastRepository extends HazelcastRepository<Tweet, Long> {
}
