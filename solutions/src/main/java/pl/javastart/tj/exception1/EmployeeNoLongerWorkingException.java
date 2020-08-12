package pl.javastart.tj.exception1;

class EmployeeNoLongerWorkingException extends RuntimeException {
    public EmployeeNoLongerWorkingException() {
        super("Employee is not longer hired");
    }
}
