package domain.cargaMediciones;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LeerArchivoExcel {
    public LeerArchivoExcel(File nombreArchivo) {
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet hssfsheet = workbook.getSheetAt(0);
            Iterator rowIterator = hssfsheet.rowIterator();

            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList();
                    while(iterator.hasNext()){
                        XSSFCell hsssfCell = (XSSFCell) iterator.next();
                        cellTemp.add(hsssfCell);
                    }
                    cellData.add(cellTemp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        obtener(cellData);
    }
    private void obtener(List cellDataList){
        for (int i =2; i < cellDataList.size(); i++){ // parte de i=2 para evitar los headers del archivo
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();
                System.out.print(stringCellValue+" ");
            }
            System.out.println();
        }

    }/*
    public static void main(String[] args){
        String archivo = "";
        System.out.println("Ingrese el PATH completo del archivo:");
        Scanner archivoScanner = new Scanner (System.in); //Creación de un objeto Scanner
        archivo = archivoScanner.nextLine(); //Invocamos un método sobre un objeto Scanner
        File f=new File(archivo);
        if (f.exists()){
            LeerArchivoExcel objetoTemp = new LeerArchivoExcel(f);
        }
    }*/
}

