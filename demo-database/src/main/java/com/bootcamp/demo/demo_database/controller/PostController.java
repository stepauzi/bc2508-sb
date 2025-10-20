package com.bootcamp.demo.demo_database.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_database.entity.PostEntity;
import com.bootcamp.demo.demo_database.entity.UserEntity;
import com.bootcamp.demo.demo_database.mapper.UserMapper;
import com.bootcamp.demo.demo_database.model.Post;
import com.bootcamp.demo.demo_database.model.User;
import com.bootcamp.demo.demo_database.repository.PostRepository;
import com.bootcamp.demo.demo_database.repository.UserRepository;

@RestController
public class PostController {
  private static final String postUrl =
      "https://jsonplaceholder.typicode.com/posts";
  private static final String userURL =
      "https://jsonplaceholder.typicode.com/users";

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserMapper userMapper;

  public static void main(String[] args) {
    String postUrl = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host("jsonplaceholder.typicode.com") //
        // .pathSegment("/v1") //
        .path("/posts") //
        .toUriString();

    // https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=tc
    String weatherUrl = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host("data.weather.gov.hk") //
        .pathSegment("weatherAPI/opendata") //
        .path("/weather.php") //
        .queryParam("dataType", "fnd") //
        .queryParam("lang", "tc") //
        .build()
        .toUriString();
    System.out.println(weatherUrl);
  }

  @PostMapping(value = "/posts")
  public List<PostEntity> createPosts() {
    // ! Clear all data in posts, users
    this.postRepository.deleteAll();
    this.userRepository.deleteAll();

    // ! Call API for the data
    List<User> users =
        Arrays.asList(this.restTemplate.getForObject(userURL, User[].class));
    List<Post> posts =
        Arrays.asList(this.restTemplate.getForObject(postUrl, Post[].class));

    // ! Convert to List<UserEntity>
    List<UserEntity> userEntities = users.stream() //
        .map(u -> this.userMapper.map(u)) //
        .collect(Collectors.toList());

    // ! Convert to List<PostEntity>
    List<PostEntity> postEntities = new ArrayList<>();
    for (Post post : posts) {
      Optional<UserEntity> oUserEntity = userEntities.stream() //
          .filter(e -> e.getOrigUserId().equals(post.getUserId())) //
          .findFirst();
      if (oUserEntity.isPresent()) {
        PostEntity postEntity = PostEntity.builder() //
            .title(post.getTitle()) //
            .body(post.getBody()) //
            .userEntity(oUserEntity.get()) // ! Important (FK)
            .build();
        postEntities.add(postEntity);
      }
    }
    // ! insert into table
    this.userRepository.saveAll(userEntities);
    return this.postRepository.saveAll(postEntities);

    // List<PostEntity> postEntities = posts.stream() //
    // .map(e -> {
    // Optional<UserEntity> oUserEntity =
    // this.userRepository.findById(e.getUserId());
    // if (oUserEntity.isPresent()) {
    // PostEntity postEntity = PostEntity.builder() //
    // .title(e.getTitle()) //
    // .body(e.getBody()) //
    // .userEntity(oUserEntity.get()).build();
    // return postEntity;
    // }
    // return null;
    // }).collect(Collectors.toList());

  }
}
