package com.nt.view;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_report")
//this spring bean component for pdf_report bean id
public class PDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//get Model attributes data
		Iterable<Employee> empdata = (Iterable<Employee>) model.get("listofemp");
		//add paragraph
		Paragraph paragr = new Paragraph("Employee_Report",new Font(Font.BOLDITALIC));
		//add the paragraph  to the Document object
		document.add(paragr);
		//add Table content
		Table table = new Table(3,((ArrayList) empdata).size());
		table.addCell("Emp_Number");
		table.addCell("Emp_Name");
		table.addCell("Emp_salary");
		for(Employee e1:empdata) {
			table.addCell(String.valueOf(e1.getEmpno()));
			table.addCell(e1.getEname());
			if(e1.getSal()!=null)
        table.addCell(String.valueOf(e1.getSal()));
			else
				table.addCell("NA");
		}//end of the for each
		document.add(table);
	}


}
