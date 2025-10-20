package com.bootcamp.demo.bc_forum.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
  private Long id;
  private String name;
  private String email;
  private String body;
  private Long postId;
}
