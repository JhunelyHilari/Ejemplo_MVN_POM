package util;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriver {
    public ArrayList<String> getData(String testcaseName) throws IOException {
        // TODO Auto-generated method stub
        FileInputStream fis = new FileInputStream("D:\\Personal\\Curso_Automatización_Selenium\\DataUsuario.xlsx");
                //Agregar arraylist
        ArrayList <String> a = new ArrayList<String>();
        XSSFWorkbook workbook = null;
        workbook = new XSSFWorkbook(fis);
        //Número de hojas
        int sheets = workbook.getNumberOfSheets();
        for (int i=0; i<sheets; i++)
        {
            if(workbook.getSheetName(i).equalsIgnoreCase("testData2"))//nombre de la hoja
            {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int k=0;
                int column=0;
                while (ce.hasNext())
                {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases"))
                    {
                        column =k;
                    }
                    k++;
                }
                System.out.println(column);


                while(rows.hasNext())
                {
                    Row r = rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
                    {
                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext())
                        {
                            Cell c= cv.next();
                            if(c.getCellType()== CellType.STRING){
                                a.add(c.getStringCellValue());
                                //System.out.println(cv.next().getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }

            }

        }
        return a;
    }

}
