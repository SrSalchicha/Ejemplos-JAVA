package SegundoCuatrimestre.ArrayExpresion;


import SegundoCuatrimestre.estructurasDeDatos.SearchGenerica;

import java.util.ArrayList;

public final class Operaciones {
    // objeto para busqueda generica binaria y lineal
    SearchGenerica generica = new SearchGenerica();

    //variables de control

    int index, indexGenerica, indexGenerica2;
    double res;
    String res1;
    private ArrayList<String> subString = new ArrayList<>();
    String numerica = "";

    public Operaciones() {

    }
    public String Op(String s) {
        s += ":";
        char[] C = s.toCharArray();
        for (char cA : C) {
            if (cA != '+' && cA != '-' && cA != '/' && cA != '*' && cA != ':'){
                numerica += cA;
            }
            else if (cA != ':'){
                subString.add(numerica);
                subString.add(String.valueOf(cA));
                numerica = "";
            }
            else {
                subString.add(numerica);
                numerica = "";
            }
        }
        for (int i  = 0; i < subString.size(); i++){
            System.out.println(subString.get(i));
        }
        while (subString.size() > index){
            for (int i  = 0; i < subString.size(); i++){
                System.out.println(subString.get(i));
            }
            index++;
            indexGenerica = generica.lineal(subString, "*", "/", true);
            indexGenerica2 =  generica.lineal(subString, "+", "-", true);
            if(indexGenerica >= 0) {
                if (subString.get(indexGenerica).equals("*")) {
                    res = BReturns.ReturnMul(subString.get(indexGenerica - 1), subString.get(indexGenerica + 1));
                    subString.remove(indexGenerica - 1);
                    subString.remove(indexGenerica - 1);
                    subString.remove(indexGenerica - 1);
                    subString.add(indexGenerica - 1, String.valueOf(res));
                    res = 0;
                } else if (subString.get(indexGenerica).equals("/")) {
                    res = BReturns.ReturnDiv(subString.get(indexGenerica - 1), subString.get(indexGenerica + 1));
                    subString.remove(indexGenerica - 1);
                    subString.remove(indexGenerica - 1);
                    subString.remove(indexGenerica - 1);
                    subString.add(indexGenerica - 1, String.valueOf(res));
                    res = 0;
                }
            }
                else{
                    if(subString.get(indexGenerica2).equals("+")){
                        res = BReturns.ReturnSum(subString.get(indexGenerica2 - 1), subString.get(indexGenerica2 + 1));
                        subString.remove(indexGenerica2 - 1);
                        subString.remove(indexGenerica2 - 1);
                        subString.remove(indexGenerica2 -1);
                        subString.add(indexGenerica2 - 1, String.valueOf(res));
                        res = 0;
                    }
                    else if (subString.get(indexGenerica2).equals("-")){
                        res = BReturns.ReturnRes(subString.get(indexGenerica2 - 1), subString.get(indexGenerica2 + 1));
                        subString.remove(indexGenerica2 - 1);
                        subString.remove(indexGenerica2 - 1);
                        subString.remove(indexGenerica2 -1);
                        subString.add(indexGenerica2 - 1, String.valueOf(res));
                        res = 0;
                    }
                }
        }
        return subString.get(0);
    }
}