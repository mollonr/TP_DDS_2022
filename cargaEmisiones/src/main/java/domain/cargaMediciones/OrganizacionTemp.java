package domain.cargaMediciones;

import java.io.File;
import java.util.Scanner;

public class OrganizacionTemp {
    public static void main(String[] args){
        String archivo = "";
        System.out.println("Ingrese el PATH completo del archivo:");
        Scanner archivoScanner = new Scanner (System.in); //Creación de un objeto Scanner
        archivo = archivoScanner.nextLine(); //Invocamos un método sobre un objeto Scanner
        File f=new File(archivo);
        if (f.exists()){
            LeerArchivoExcel objetoTemp = new LeerArchivoExcel(f);
        }
    }
}
