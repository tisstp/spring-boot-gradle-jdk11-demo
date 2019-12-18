package com.tisstp.exgradle.demo.api.swag.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sathaphorn.stp (Tis)
 * @since 19-12-2019, 1:55 AM
 */
@Setter
@Getter
public class SomeModel {

  @ApiModelProperty(value = "${SomeModel.longProperty}")
  private Long longProperty;

  @ApiModelProperty(value = "${SomeModel.fristName}")
  private String fristName;

  @ApiModelProperty(value = "${SomeModel.lastName}")
  private String lastName;

}
