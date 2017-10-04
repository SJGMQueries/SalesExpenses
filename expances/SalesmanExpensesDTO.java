package com.salesmans.expances;

public class SalesmanExpensesDTO {
	public String empId;

	public String name;

	public String expenseType;

	public Double expenses;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public SalesmanExpensesDTO(String empId, String name, String expenseType, Double expenses) {
		super();
		this.empId = empId;
		this.name = name;
		this.expenseType = expenseType;
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "SalesmanExpensesDTO [empId=" + empId + ", name=" + name + ", expenseType=" + expenseType + ", expenses="
				+ expenses + "]";
	}

}
