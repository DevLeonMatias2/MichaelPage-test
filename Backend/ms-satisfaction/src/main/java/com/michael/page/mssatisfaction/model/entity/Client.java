package com.michael.page.mssatisfaction.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@ApiModel("Model Client")
@Document(collection = "client")
@Data
public class Client {

    @ApiModelProperty(value = "Id de Cliente", required = true)
    private String id;

    private String email;

    @ApiModelProperty(value = "Nombre de Cliente", required = true)
    private String name;

    private Date createDate;

    private int score;

    private String msj;

}
