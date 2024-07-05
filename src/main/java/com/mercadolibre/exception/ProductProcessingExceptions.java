package com.mercadolibre.exceptions;

import lombok.extern.slf4j.Slf4j;

public class ProductProcessingExceptions {

    public static class ValidateProdutoException extends Exception {
        public ValidateProdutoException() {
            super();
        }

        public ValidateProdutoException(String message) {
            super(message);
        }

        public ValidateProdutoException(String message, Throwable cause) {
            super(message, cause);
        }

        public ValidateProdutoException(Throwable cause) {
            super(cause);
        }
    }

    public static class SaveProductException extends Exception {
        public SaveProductException() {
            super();
        }

        public SaveProductException(String message) {
            super(message);
        }

        public SaveProductException(String message, Throwable cause) {
            super(message, cause);
        }

        public SaveProductException(Throwable cause) {
            super(cause);
        }
    }

    public static class ValidateProductException extends Exception {
        public ValidateProductException() {
            super();
        }

        public ValidateProductException(String message) {
            super(message);
        }

        public ValidateProductException(String message, Throwable cause) {
            super(message, cause);
        }

        public ValidateProductException(Throwable cause) {
            super(cause);
        }
    }
}
