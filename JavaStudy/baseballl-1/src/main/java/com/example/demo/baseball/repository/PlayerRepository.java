package com.example.demo.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.baseball.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Long>  {

}