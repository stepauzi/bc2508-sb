package com.bootcamp.demo.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.dto.FullDataDto;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;

@Component
public class CommentMapper {
  public FullDataDto.PostDto.CommentDto map(CommentDTO commentDTO) {
    return FullDataDto.PostDto.CommentDto.builder() //
        .id(commentDTO.getId()) //
        .body(commentDTO.getBody()) //
        .email(commentDTO.getEmail()) //
        .name(commentDTO.getName()) //
        .build();
  }
}
