package com.bootcamp.demo.bc_forum.model.dto;

import lombok.Getter;

@Getter
public class PostDTO {
  private Long id;
  private String title;
  private String body;
  private Long userId;
}
