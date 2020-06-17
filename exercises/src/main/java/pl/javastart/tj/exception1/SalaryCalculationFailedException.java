package pl.javastart.tj.exception1;

class SalaryCalculationFailedException extends RuntimeException {
    public SalaryCalculationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
