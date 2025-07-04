package com.puppawshop.ecommerce.exceptions;

public class InsufficientInventoryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InsufficientInventoryException(String message) {
        super(message);
    }
}
