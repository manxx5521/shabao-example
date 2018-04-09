package com.xiaoshabao.example.test;

public enum FormulaType {
	FIELD_FORMULA_0(0,"字段公式");
	private int type;
	private String name;
	
	private FormulaType(int type,String name){
		this.type=type;
		this.name=name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
