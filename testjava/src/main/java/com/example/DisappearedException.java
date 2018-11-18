package com.example;

public class DisappearedException {
    public void show() throws BaseException {
        Exception exception = null;
        try {
            Integer.parseInt("Hello");
        } catch (NumberFormatException e1) {
            exception = e1;
//            throw new BaseException(e1);
        } finally {
            try {
                int result = 2 / 0;
            } catch (ArithmeticException e2) {
                exception.addSuppressed(e2);
                throw new BaseException(exception);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DisappearedException d = new DisappearedException();
        d.show();
    }

    class BaseException extends Exception {
        public BaseException(Exception ex) {
            super(ex);
        }

        private static final long serialVersionUID = 3987852541476867869L;
    }
}
