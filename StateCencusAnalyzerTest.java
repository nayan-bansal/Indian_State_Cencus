package Cencus.India_Cencus_Problem;

package Cencus.India_Cencus_Problem;

import org.junit.Test;

import junit.framework.Assert;

public class CencusAnalyzerTest {

private static String INDIA_CENSUS_CSV_FILE_PATH = "D:\\Capgemini Training\\CG Projects\\IndianStatesCensus\\StateCensus.csv";
	
	@Test
    public void numberOfRecordsTest() {
        try {
            StateCencusAnalyzer censusAnalyser = new StateCencusAnalyzer();
            int numOfRecords = censusAnalyser.readCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CencusAnalyzerException e) { }
    }
	
}
