package pl.javastart.tj.exception1;

class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Employee not found in database");
    }
}
