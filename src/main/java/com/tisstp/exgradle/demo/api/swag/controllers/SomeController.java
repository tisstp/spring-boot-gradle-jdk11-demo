package com.tisstp.exgradle.demo.api.swag.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tisstp.exgradle.demo.api.swag.models.SomeModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author sathaphorn.stp (Tis)
 * @since 19-12-2019, 1:00 AM
 */
@Api
@Controller
public class SomeController {

  @ApiOperation(value = "Find pet by Status", notes = "${SomeController.findPetsByStatus.notes}")
  @RequestMapping(value = "/findByStatus", method = RequestMethod.GET, params = {"status"})
  public String findPetsByStatus(
    @ApiParam(value = "${SomeController.findPetsByStatus.status}", required = true)
    @RequestParam(name = "status", defaultValue = "${SomeController.findPetsByStatus.status.default}") String status
  ) {

    return status;
  }

  @ApiOperation(notes = "Operation 2", value = "${SomeController.operation2.value}")
  @ApiImplicitParams(
    @ApiImplicitParam(name = "header1", value = "${SomeController.operation2.header1}")
  )
  @RequestMapping(value = "operation2", method = RequestMethod.POST)
  public ResponseEntity<SomeModel> operation2(@RequestBody() SomeModel someModel) {
    return ResponseEntity.ok(new SomeModel());
  }

}
