package com.xiaoshabao.example.test;

import java.io.Serializable;

public class FormulaEntity implements Serializable{
	
	private static final long serialVersionUID = -1786291467986258779L;
	
	private Long formulaId;
	private String formulaName;
	private Integer formulaType;
	private String expression;
	public Long getFormulaId() {
		return formulaId;
	}
	public void setFormulaId(Long formulaId) {
		this.formulaId = formulaId;
	}
	public String getFormulaName() {
		return formulaName;
	}
	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}
	public Integer getFormulaType() {
		return formulaType;
	}
	public void setFormulaType(Integer formulaType) {
		this.formulaType = formulaType;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
