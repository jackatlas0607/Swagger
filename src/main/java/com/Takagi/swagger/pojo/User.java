package com.Takagi.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用戶實體")
public class User {
    @ApiModelProperty("用戶名")
    public String username;
    @ApiModelProperty("密碼")
    public String password;
}
