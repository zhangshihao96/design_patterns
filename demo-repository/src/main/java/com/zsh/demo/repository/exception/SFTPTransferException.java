package com.zsh.demo.repository.exception;

import java.io.IOException;

public class SFTPTransferException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SFTPTransferException(String message) {
        super(message);
    }
}
