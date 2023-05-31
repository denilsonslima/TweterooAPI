package com.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.project.api.models.TweetsModels;
import com.project.api.repository.TweetsRepository;

@RestController
@RequestMapping(value = "/tweets")
public class TweetsControllers {
  @Autowired
  private TweetsRepository tweets;

  @GetMapping
  public List<TweetsModels> getPagedTweets(@RequestParam(defaultValue = "0") int page){
    Pageable pageable = PageRequest.of(page, 5);
    return tweets.getRecentTweets(pageable);
  }

  @GetMapping(value = "/{username}")
  public List<TweetsModels> findTweetByUser(@PathVariable String username){
    return tweets.findAllByUsername(username);
  }

}
