package Parcial1.test;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import java.util.ArrayList;
import org.junit.Test;
import Parcial1.src.AnalizadorLexico;

public class AnalizadorLexicoTest {
    @Test
    public void test1() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("if");
        listado.add("ID");
        listado.add("then");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test2() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("if");
        listado.add("ID");
        listado.add("then");
        listado.add("NUM");
        listado.add("else");
        listado.add("if");
        listado.add("ID");
        listado.add("then");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test3() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("if");
        listado.add("ID");
        listado.add("then");
        listado.add("NUM");
        listado.add("else");
        listado.add("if");
        listado.add("ID");
        listado.add("then");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test4() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("if");
        listado.add("ID");
        listado.add("==");
        listado.add("0");
        listado.add("then");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeFalse(respuesta);
    }

    @Test
    public void test5() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("if");
        listado.add("ID");
        listado.add("if");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeFalse(respuesta);
    }

    @Test
    public void test6() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("else");
        listado.add("ID");
        listado.add("if");
        listado.add("NUM");

        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeFalse(respuesta);
    }
}
