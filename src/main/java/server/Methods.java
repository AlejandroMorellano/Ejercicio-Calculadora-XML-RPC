package server;

public class Methods {

    double firstNumber;
    double secondNumber;
    String r;

    String response;

    String opera;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String suma(double firstNumber, double secondNumber){
        String opera;
        opera = String.valueOf(firstNumber + secondNumber);
        return opera;
    }

    public String resta(double firstNumber, double secondNumber){
        String opera;
        opera = String.valueOf(firstNumber - secondNumber);
        return opera;
    }

    public  String multi(double firstNumber, double secondNumber){
        String opera;
        opera = String.valueOf(firstNumber * secondNumber);
        return opera;
    }
    
    public  String divi(double firstNumber, double secondNumber){
        String opera = null;
        
        if(secondNumber != 0){
            opera = String.valueOf(firstNumber/secondNumber);
        }else if(secondNumber == 0){
            opera = "Error";
        }
        return opera;
    }

    public String expo(double firstNumber, double secondNumber){
        String opera;

        opera = String.valueOf(Math.pow(firstNumber, secondNumber));

        return opera;
    }

    public String raiz(double firstNumber, double secondNumber){
        String opera;

        opera = String.valueOf(Math.pow(firstNumber, 1 / secondNumber));

        return opera;
    }

    public static boolean guardar(Methods operations){
        DaoCalculadora daocal = new DaoCalculadora();
        ResultAction result = new ResultAction();
        if (daocal.insertarOperacion(operations)){
            result.setResult(true);
            result.setMessage("Operacion resgistrada correctamente");
            result.setStatus(200);
            return true;
        }else {
            result.setResult(false);
            result.setMessage("Error al registrar operacion");
            result.setStatus(400);
            return false;
        }
    }

}
