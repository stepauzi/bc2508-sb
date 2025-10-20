package com.bootcamp.demo.demo_thymeleaf.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface CoinPageOperation {
  @GetMapping("/coinpage")
  String getCoins(Model model);
}
