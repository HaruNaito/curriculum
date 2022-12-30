package com.example.demo.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<User> searchAll() {
    return userRepository.findAll();
  }
}