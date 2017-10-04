package com.salesmans.expances;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SalesmanExpensesServices {

	public static void processExpenses(String filePath, String type) throws Exception {
		List<SalesmanExpensesDTO> expanses = CsvtoModelMapper.csvMapper(filePath);
		Set<String> names = expanses.stream().map(SalesmanExpensesDTO::getName).collect(Collectors.toSet());
		if (type.equalsIgnoreCase("Total")) {
			names.stream().forEach(name -> System.out.println(name + " : " + findSum(expanses, name)));
		}
		if (type.equalsIgnoreCase("Table")) {
			Set<TableDTO> tableDTOList = assignAmount(expanses);
			System.out.println("| Name | Food | Travel | Taxi | Misc |");
			System.out.println("---------------------------------------");
			for (TableDTO tableDTO : tableDTOList) {
				System.out.println("  " + tableDTO.getName() + "  " + tableDTO.getFoodEx() + "  "
						+ tableDTO.getTravelEx() + "  " + tableDTO.getTaxiEx() + "  " + tableDTO.getMiscEx());
			}
		}
	}

	private static Set<TableDTO> assignAmount(List<SalesmanExpensesDTO> expanses) {
		TableDTO tableDTO = null;
		Set<TableDTO> tableDTOList = new HashSet<>();
		Map<String, TableDTO> tableMap = new HashMap<>();
		for (SalesmanExpensesDTO salesmanExpensesDTO : expanses) {
			tableDTO = getInstance(salesmanExpensesDTO.getName(), tableMap);

			double exAmount = salesmanExpensesDTO.getExpenses();

			switch (salesmanExpensesDTO.getExpenseType()) {
			case "TRAV":
				tableDTO.setTravelEx(exAmount);
				break;
			case "FOOD":
				tableDTO.setFoodEx(exAmount);
				break;
			case "TAXI":
				tableDTO.setTaxiEx(exAmount);
				break;
			case "MISC":
				tableDTO.setMiscEx(exAmount);
				break;
			default:
				break;
			}
			tableMap.put(tableDTO.getName(), tableDTO);
			tableDTOList.add(tableDTO);
		}
		return tableDTOList.stream().distinct().collect(Collectors.toSet());

	}

	private static double findSum(List<SalesmanExpensesDTO> expanses, String name) {
		return expanses.stream().filter(user -> user.getName().equalsIgnoreCase(name)).mapToDouble(u -> u.getExpenses())
				.sum();
	}

	// factory for Table DTO

	public static TableDTO getInstance(String name, Map<String, TableDTO> tableMap) {
		TableDTO tableDTO = null;
		tableDTO = (!tableMap.containsKey(name)) ? new TableDTO() : tableMap.get(name);
		tableDTO.setName(name);
		return tableDTO;
	}

	public static void main(String[] args) throws Exception {
		processExpenses("expancess.txt", "Table");
	}
}
