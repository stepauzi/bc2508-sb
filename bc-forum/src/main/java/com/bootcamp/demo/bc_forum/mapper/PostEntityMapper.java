package com.bootcamp.demo.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;

@Component
public class PostEntityMapper {
  public PostEntity map(PostDTO dto) {
    return PostEntity.builder() //
      .origPostId(dto.getId())
      .title(dto.getTitle()) //
      .body(dto.getBody()) //
      .build();
  }
}
