package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_forum.codelib.GResponse;
import com.bootcamp.demo.bc_forum.dto.FullDataDto;
import com.bootcamp.demo.bc_forum.dto.FullDataDto2;

public interface ForumAppOperation {
  // ! Exercise 2: Task 3a
  @GetMapping(value = "/fulldata")
  List<FullDataDto> getFullData();

  // ! Exercise 2: Task 3b
  @GetMapping(value = "/fulldata2")
  GResponse<FullDataDto2> getFullData2(@RequestParam(value = "userid") String uid);
}
