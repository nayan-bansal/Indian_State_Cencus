package Cencus.India_Cencus_Problem;

import java.io.*;
import java.nio.file.*;
import java.util.Iterator;
import java.util.logging.Logger;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCencusAnalyzer {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(StateCencusAnalyzer.class.getName());
		log.info("Welcome to the Indian States Census Analyser Problem.");
	}
	
	public int readCensusData(String csvFilePath) throws CencusAnalyzerException{

		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			int numOfEnteries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEnteries++;
				censusCSVIterator.next();
			}
			return numOfEnteries;
		} catch(Exception e) {
			throw new CencusAnalyzerException(e.getMessage(), CencusAnalyzerException.ExceptionType.CENSUS_FILE_EXCEPTION);
		}
		
	}
	
}
