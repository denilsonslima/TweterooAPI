package com.project.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.api.models.TweetsModels;

public interface TweetsRepository extends JpaRepository<TweetsModels, Long> {
  @Query(value = "SELECT t FROM TweetsModels t ORDER BY t.id DESC")
  List<TweetsModels> getRecentTweets(Pageable pageable);
}

