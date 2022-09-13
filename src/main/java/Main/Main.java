package Main;

import domain.cargaEmisionesExcel.Actividad;
import domain.cargaEmisionesExcel.DatoActividad;
import domain.cargaEmisionesExcel.LeerArchivoExcel;
import domain.organizacion.Sector;

import notificaciones.InvocadorNotificaciones;
import notificaciones.EnviadorDeMail;
import notificaciones.EnviadorDeWpp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
       String path_archivo_excel = "C:\\Users\\Juani Mosmann\\Desktop\\Libro1.xlsx";

        File archivo = new File(path_archivo_excel);
        List<Actividad> datosActividad = LeerArchivoExcel.EjecutarLectura(archivo);
        System.out.println(datosActividad.get(0).getTipoActividad().toString());
        InvocadorNotificaciones notificaciones = new InvocadorNotificaciones();
        notificaciones.invocar();
    }

}
