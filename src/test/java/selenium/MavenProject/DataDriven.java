package selenium.MavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
		
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\Nilima\\selenium\\data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//identify testcase coloum by scanning entire 1st row
				Iterator<Row> rows=sheet.iterator();  //collection of row
				Row firstrow=rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();  //collection of cell
				int k=0;
				int coloum=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						//desired coloum
						coloum=k;
					}
					k++;
				}
				System.out.println(coloum);
				//once coloum is identified then scan entire testcases coloum to identify testcases row
				while(rows.hasNext())
				{
					Row r=rows.next();
					
					if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase("AddProfile"))
					{
						//after you grab testcases row pull all data of row
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext())
						{
							
							System.out.println(cv.next().getStringCellValue());
							
							
							
						}
					}
					
				}
				
			}
		}
		
	}

	}


