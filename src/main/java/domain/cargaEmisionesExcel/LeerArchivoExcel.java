package domain.cargaEmisionesExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;


import domain.cargaEmisionesExcel.Unidades.RelacionesUnidadTipoConsumo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LeerArchivoExcel {
    public static List<Actividad> EjecutarLectura(File nombreArchivo) {
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
        ArrayList<Actividad> Actividades = new ArrayList();

        Actividades.addAll(obtener(cellData));
        return Actividades;
    }
    private static List<Actividad> obtener(List cellDataList){
        List<Actividad> datosLeidos = new ArrayList();
        for (int i =2; i < cellDataList.size(); i++){ // parte de i=2 para evitar los headers del archivo
            List cellTempList = (List) cellDataList.get(i);

            Actividad datoLeido = new Actividad();
            XSSFCell nombreActividadCell = (XSSFCell) cellTempList.get(0);
            switch(nombreActividadCell.toString()){
                case "Combustión fija":
                    datoLeido.setTipoActividad(TipoActividad.COMBUSTION_FIJA);
                    datoLeido.setAlcance(Alcance.EMISIONES_DIRECTAS);
                    break;
                case "Combustión móvil":
                    datoLeido.setTipoActividad(TipoActividad.COMBUSTION_MOVIL);
                    datoLeido.setAlcance(Alcance.EMISIONES_DIRECTAS);
                    break;
                case "Electricidad adquirida y consumida":
                    datoLeido.setTipoActividad(TipoActividad.ELECTRICIDAD_ADQUIRIDA_CONSUMIDA);
                    datoLeido.setAlcance(Alcance.EMISIONES_INDIRECTAS_ASOCIADAS_ELECTRICIDAD);
                    break;
                case "Logística de productos y residuos":
                    datoLeido.setTipoActividad(TipoActividad.COMBUSTION_MOVIL.LOGISTICA_PRODUCTOS_RESIDUOS);
                    datoLeido.setAlcance(Alcance.OTRAS_EMISIONES_INDIRECTAS);
                    break;
            }

            XSSFCell tipoConsumoCell = (XSSFCell) cellTempList.get(1);
            String tipoConsumo = tipoConsumoCell.toString();
            datoLeido.setUnidadPorTipoConsumo(RelacionesUnidadTipoConsumo.relacionesUnidadTipoConsumo
                    .stream()
                    .filter(relacion -> relacion.getTipoConsumo().toLowerCase().equals(tipoConsumo.toLowerCase()))
                    .findFirst()
                    .get());

            XSSFCell valorCell = (XSSFCell) cellTempList.get(2);
            datoLeido.setValor(valorCell.getNumericCellValue());

            XSSFCell periodicidadCell = (XSSFCell) cellTempList.get(3);
            datoLeido.setPeriodicidad(Periodicidad.valueOf(periodicidadCell.toString().toUpperCase()));

            XSSFCell periodoImputacionCell = (XSSFCell) cellTempList.get(4);
            datoLeido.setPeriodoImputacion(periodoImputacionCell.toString());

            datosLeidos.add(datoLeido);
        }

        return datosLeidos;
    }
}