package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;

public interface JPHService {
  List<UserDTO> getAllUsers();
  List<PostDTO> getAllPosts();
  List<CommentDTO> getAllComments();
}
