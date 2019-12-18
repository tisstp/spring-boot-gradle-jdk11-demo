package com.tisstp.exgradle.demo.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sathaphorn.stp (Tis)
 * @since 18-12-2019, 4:48 PM
 */
@Controller
public class HomeController {

  @RequestMapping("/")
  public String home() {
    return "redirect:swagger-ui.html";
  }

}
