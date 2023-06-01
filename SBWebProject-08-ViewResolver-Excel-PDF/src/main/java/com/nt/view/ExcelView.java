package com.nt.view;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excel_report")
public class ExcelView extends AbstractXlsView {

	private static int i = 0;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Iterable<Employee> empdata = (Iterable<Employee>) model.get("listofemp");
		// create a workbook
		Sheet sheet1 = workbook.createSheet("sheet1");
		Row row = sheet1.createRow(i);
		row.createCell(0).setCellValue("Emp_No");
		row.createCell(1).setCellValue("Emp_Name");
		row.createCell(2).setCellValue("Emp_Sal");
		for (Employee e1 : empdata) {
			// create row
			Row row1 = sheet1.createRow(i + 1);
			row1.createCell(0).setCellValue(String.valueOf(e1.getEmpno()));
			row1.createCell(1).setCellValue(e1.getEname());
			if (e1.getSal() != null)
				row1.createCell(2).setCellValue(String.valueOf(e1.getSal()));
			else
				row1.createCell(2).setCellValue("N/A");
			i++;
		}//for

	}//buildExcelDocument()

}//class
