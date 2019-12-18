package com.tisstp.exgradle.demo.api.controller;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tisstp.exgradle.demo.api.type.Category;
import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author sathaphorn.stp (Tis)
 * @since 18-12-2019, 4:49 PM
 */
@Api
@RestController
public class CategoryController {

  @RequestMapping(value = "/category/Resource", method = RequestMethod.GET)
  public ResponseEntity<String> search(@RequestParam(value = "someEnum") Category someEnum) {
    return ResponseEntity.ok(someEnum.name());
  }

  @RequestMapping(value = "/category/map", method = RequestMethod.GET)
  public Map<String, Map<String, Object>> map() {
    return newHashMap();
  }

  @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
  public ResponseEntity<Void> someOperation(@PathVariable long id, @RequestBody int userId) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/category/{id}/{userId}", method = RequestMethod.POST)
  public ResponseEntity<Void> ignoredParam(@PathVariable long id, @PathVariable @ApiIgnore int userId) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/category/{id}/map", method = RequestMethod.POST)
  public ResponseEntity<Void> map(@PathVariable String id, @RequestParam Map<String, String> test) {
    return ResponseEntity.ok(null);
  }

  @RequestMapping(value = "/categories", method = RequestMethod.POST)
  public ResponseEntity<List<Category>> map(String [] categories) {
    return ResponseEntity.ok(null);
  }

}
