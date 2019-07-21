package com.tu.lunchy.util;

public class StoredProcedureResult {
	private static final String ERROR_MESSAGE_PREFIX = "ERROR:";
	
	private String resultMessage;
	private int resultCode;
	
	public StoredProcedureResult() {
	}

	public StoredProcedureResult(int resultCode, String resultMessage) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString() {
		return "StoredProcedureResult [resultCode=" + resultCode + ", resultMessage=" + resultMessage + "]";
	}

	public boolean isSuccessful() {
		if (this.resultCode > 0 && this.resultMessage != null) {
			if (!resultMessage.startsWith(ERROR_MESSAGE_PREFIX)) {
				return true;
			}
		}
		return false;
	}

}
