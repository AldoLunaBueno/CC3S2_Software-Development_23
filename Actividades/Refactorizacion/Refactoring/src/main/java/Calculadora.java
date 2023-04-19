public class Calculadora {
    private boolean status;
    public Calculadora() {
        this.status = true;
    }
    public boolean getStatus() {
        return status;
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(
                    "No se puede dividir por cero");
        } else {
            return a / b;
        }
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int squareRoot(int a) {
        if (a >= 0) {
            return (int) Math.sqrt(a);
        } else {
            throw new IllegalArgumentException(
                    "No se puede calcular la raíz cuadrada"
                            + " de un argumento negativo"
            );
        }
    }
}


