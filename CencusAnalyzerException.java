package Cencus.India_Cencus_Problem;

public class CencusAnalyzerException  extends Exception{

	enum ExceptionType {
		CENSUS_FILE_EXCEPTION,
	}

	ExceptionType type;

	public CencusAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CencusAnalyzerException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
	
}
