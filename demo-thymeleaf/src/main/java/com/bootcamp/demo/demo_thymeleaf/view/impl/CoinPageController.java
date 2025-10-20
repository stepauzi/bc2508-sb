package com.bootcamp.demo.demo_thymeleaf.view.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;
import com.bootcamp.demo.demo_thymeleaf.view.CoinPageOperation;

@Controller
public class CoinPageController implements CoinPageOperation {
  @Autowired
  private CoinService coinService;

  @Override
  public String getCoins(Model model) {
    List<CoinDTO> coinList = coinService.getCoins();
    model.addAttribute("coinList", coinList);
    return "coinspage";
  }
}
