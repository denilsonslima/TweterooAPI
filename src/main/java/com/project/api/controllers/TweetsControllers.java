package com.project.api.controllers;

import java.util.List;

import com.project.api.dto.TweetsDTO;
import com.project.api.models.UserModels;
import com.project.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.api.models.TweetsModels;
import com.project.api.repository.TweetsRepository;

@RestController
@RequestMapping(value = "/api/tweets")
public class TweetsControllers {
  @Autowired
  private TweetsRepository tweets;
  @Autowired
  private UserRepository user;

  @GetMapping
  public ResponseEntity<List<TweetsModels>> getPagedTweets(@RequestParam(defaultValue = "0", value = "page") int page){
    Pageable pageable = PageRequest.of(page, 5);
    return ResponseEntity.ok(tweets.findAllByOrderByIdDesc(pageable));
  }

  @GetMapping(value = "/{username}")
  public List<TweetsModels> findTweetByUser(@PathVariable String username){
    return tweets.findAllByUsername(username);
  }

  @PostMapping
  public ResponseEntity<TweetsModels> createTweets(@RequestBody TweetsDTO tweet){
    String username = tweet.getUsername();
    String text = tweet.getTweet();
    String avatar = user.findByUsername(username).getAvatar();
    TweetsModels res = new TweetsModels(username, text, avatar);
    tweets.save(res);
    return ResponseEntity.ok(res);
  }

}
