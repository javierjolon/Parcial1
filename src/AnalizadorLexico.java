package Parcial1.src;
import java.util.ArrayList;
import java.util.Stack;

public class AnalizadorLexico {
    
    public static boolean AutomataPila(ArrayList<String> listadoDeTokens) throws Exception{
        //se agrega el simbolo inicial
        Stack<String> pilaInterna = new Stack<String>();
        pilaInterna.push("<if_stmt>");
        
        while (!pilaInterna.isEmpty()) {

            String lookAhead = "";
            if (listadoDeTokens.size() > 0) {
                lookAhead = listadoDeTokens.get(0);
            }

            String simboloPilaInterna = pilaInterna.peek();
            
            if (lookAhead.equals(simboloPilaInterna)) {
                listadoDeTokens.remove(0);
                pilaInterna.pop();
            }else{
                switch (simboloPilaInterna) {
                    case "<if_stmt>":{
                        if (lookAhead.equals("if")) {
                            pilaInterna.pop();
                            listadoDeTokens.remove(0);
                            pilaInterna.push("<else_part>");    
                            pilaInterna.push("<else_if_part>");
                            pilaInterna.push("<stmt>");
                            pilaInterna.push("then");
                            pilaInterna.push("<expr>");
                        }else{
                            return false;
                        }
                    } break;
                    case "<else_if_part>":{
                        if (lookAhead.equals("else")) {
                            pilaInterna.pop();
                            listadoDeTokens.remove(0);
                            pilaInterna.push("<else_if_part>");
                            pilaInterna.push("<stmt>");
                            pilaInterna.push("then");
                            pilaInterna.push("<expr>");
                            pilaInterna.push("if");
                        }else{
                            pilaInterna.pop();
                        }
                    }break;
                    case "<else_part>":{
                        if (lookAhead.equals("else")) {
                            pilaInterna.pop();
                            pilaInterna.push("<stmt>");
                        }else {
                            pilaInterna.pop();
                        }
                    }break;
                    case "<expr>": {
                        if (lookAhead.equals("ID") || lookAhead.equals("NUM")) {
                            pilaInterna.pop();
                            listadoDeTokens.remove(0);
                        }else {
                            return false;
                            //throw new Exception("Se esperaba: " + pilaInterna.peek() + " pero encontró: " + lookAhead);
                        }
                    }break;
                    case "<stmt>": {
                        if (lookAhead.equals("ID") || lookAhead.equals("NUM")) {
                            pilaInterna.pop();
                            listadoDeTokens.remove(0);
                        }else {
                            return false;
                            //throw new Exception("Se esperaba: " + pilaInterna.peek() + " pero encontró: " + lookAhead);
                        }
                    }break;
                    case "eof": {
                        if (listadoDeTokens.isEmpty()) {
                            return true;
                        }else{
                            return false;
                        }
                    }
                    default:
                        return false;
                        //throw new Exception("Simbolo no encontrado: " + pilaInterna.peek());
                }
            }
        }
        
        if (listadoDeTokens.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
}
