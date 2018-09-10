package com.xiaoshabao.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="demo实体")
@Entity
public class DemoEntity implements Serializable{
	private static final long serialVersionUID = 5966040809659102291L;
	
	@ApiModelProperty(value = "主键id", example = "1001")
	@Id
	private Integer id;
	@ApiModelProperty(value = "名字", example = "张三")
	private String name;
	
	public DemoEntity() {
		
	}
	public DemoEntity(Integer id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
