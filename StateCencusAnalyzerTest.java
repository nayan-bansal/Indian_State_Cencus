package Cencus.India_Cencus_Problem;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class CencusAnalyzerTest {

private static String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\AAYUSH\\eclipse-workspace\\India_Cencus_Problem\\StateCensus.csv";
private static String WRONG_CSV_FILE_PATH = "C:\\Users\\AAYUSH\\eclipse-workspace\\StateCensus.csv";
private static String WRONG_CSV_FILE_TYPE = "C:\\Users\\AAYUSH\\eclipse-workspace\\India_Cencus_Problem\\StateCensus.java";	



	@Test
    public void numberOfRecordsTest() {
        try {
            StateCencusAnalyzer censusAnalyser = new StateCencusAnalyzer();
            int numOfRecords = censusAnalyser.readCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CencusAnalyzerException e) { }
    }
	
	@Test
	public void incorrectFileTest() {
		try {
			StateCencusAnalyzer censusAnalyser = new StateCencusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CencusAnalyzerException.class);
			censusAnalyser.readCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		} catch (CencusAnalyzerException e) {
			Assert.assertEquals(CencusAnalyzerException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
	
	@Test
	public void incorrectFileTypeTest() {
		try {
			StateCencusAnalyzer censusAnalyser = new StateCencusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CencusAnalyzerException.class);
			censusAnalyser.readCensusData(WRONG_CSV_FILE_TYPE);
		} catch (CencusAnalyzerException e) {
			Assert.assertEquals(CencusAnalyzerException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
}