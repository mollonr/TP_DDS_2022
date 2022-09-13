package autenticacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidadorContrasenias {

    //region Atributos
    private List<String> peoresContrasenias = new ArrayList<>();
    private String regexNumero = ".*[0-9].*";
    private String regexLetraMayuscula =  ".*[A-Z].*";
    private String regexLetraMinuscula =  ".*[a-z].*";
    //endregion

    //region Getters & Setters
    public void setRegexLetraMinuscula(String regexLetraMinuscula) {
        this.regexLetraMinuscula = regexLetraMinuscula;
    }

    public String getRegexNumero() {
        return regexNumero;
    }

    public void setRegexNumero(String regexNumero) {
        this.regexNumero = regexNumero;
    }

    public String getRegexLetraMayuscula() {
        return regexLetraMayuscula;
    }

    public void setRegexLetraMayuscula(String regexLetraMayuscula) {
        this.regexLetraMayuscula = regexLetraMayuscula;
    }

    public String getRegexLetraMinuscula() {
        return regexLetraMinuscula;
    }
    //endregion

    //region Métodos Privados
    private boolean contieneUnNumero(String contrasenia){
        Pattern patronNumero = Pattern.compile(regexNumero);
        Matcher matcherNum = patronNumero.matcher(contrasenia);
        return matcherNum.find();
    }

    private boolean contieneLetraMinuscula(String contrasenia){
        Pattern patronLetraMinuscula = Pattern.compile(regexLetraMinuscula);
        Matcher matcherLetraMin = patronLetraMinuscula.matcher(contrasenia);
        return matcherLetraMin.find();
    }

    private boolean contieneLetraMayuscula(String contrasenia){
        Pattern patronLetraMayuscula= Pattern.compile(regexLetraMayuscula);
        Matcher matcherLetraMay = patronLetraMayuscula.matcher(contrasenia);
        return matcherLetraMay.find();
    }

    private boolean tieneLongitudValida(String contrasenia){
        return contrasenia.length()>=8;
    }

    private boolean esPeorContrasenia(String contrasenia){
        return peoresContrasenias.contains(contrasenia);
    }
    //endregion

    //region Métodos Públicos
    public void cargarPeoresContrasenias(String pathArchivo){
        try(Stream<String> lineas = Files.lines(Paths.get(pathArchivo))){
            peoresContrasenias = lineas.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error en apertura de archivo");
        }
    }

    public List<erroresDeContrasenia> erroresDeContrasenia(String contrasenia){
        List<erroresDeContrasenia> errores = new ArrayList<>();
        if(!contieneUnNumero(contrasenia))
            errores.add(erroresDeContrasenia.ERROR_NUMERO);
        if(!contieneLetraMayuscula(contrasenia))
            errores.add(erroresDeContrasenia.ERROR_LETRA_MAYUSCULA);
        if(!contieneLetraMinuscula(contrasenia))
            errores.add(erroresDeContrasenia.ERROR_LETRA_MINUSCULA);
        if (!tieneLongitudValida(contrasenia))
            errores.add(erroresDeContrasenia.ERROR_LONGITUD);
        if(esPeorContrasenia(contrasenia))
            errores.add(erroresDeContrasenia.ERROR_PEORES_CONTRASENIAS);
        return errores;
    }
    //endregion

}
