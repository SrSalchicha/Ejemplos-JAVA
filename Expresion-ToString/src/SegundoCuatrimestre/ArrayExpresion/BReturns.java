package SegundoCuatrimestre.ArrayExpresion;

public class BReturns {

    public static double ReturnSum(String type1, String type2){
        return Double.parseDouble(type1) + Double.parseDouble(type2);
    }

    public static double ReturnRes(String type1, String type2){
        return Double.parseDouble(type1) - Double.parseDouble(type2);
    }

    public static double ReturnMul(String type1, String type2){
        return Double.parseDouble(type1) * Double.parseDouble(type2);
    }

    public static double ReturnDiv(String type1, String type2){
        return Double.parseDouble(type1) / Double.parseDouble(type2);
    }
}
