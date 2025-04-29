package no.oslomet.klatrestudy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/test")
  public String TestHandler() {
    return "This is a test";
  }
}