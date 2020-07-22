package com.br.aloi.planner.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.Customer;
import com.br.aloi.planner.repository.CustomerRepository;
import com.google.maps.errors.ApiException;

@Service
public class CSVService {

	@Autowired
	private CustomerRepository repository;

	public void CSVReadAutoGetHeaders(InputStream in) throws ApiException, InterruptedException {
		Reader reader = new InputStreamReader(in);
		try {
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			Customer customer = new Customer();
			for (CSVRecord csvRecord : csvParser) {
				customer.setCustomerId(Integer.parseInt(csvRecord.get("customerId").replaceAll("[^0-9]", "")));
//				customer.setSectorId(csvRecord.get("sectorId"));
				customer.setPlaceId(csvRecord.get("placeId"));
//				customer.setCompanyName(csvRecord.get("companyName"));
//				customer.setTradeName(csvRecord.get("tradeName"));
				customer.setPlace(csvRecord.get("place"));
//				customer.setNeighborhood(csvRecord.get("neighborhood"));
//				customer.setVisitDay(csvRecord.get("visitDay"));
//				customer.setCity(csvRecord.get("city"));
//				customer.setRegion(csvRecord.get("region"));
				customer.setLatitude(
						MapsApiService.getLat(customer.getPlace().concat(" ").concat(customer.getPlaceId())));
				customer.setLongitude(
						MapsApiService.getLng(customer.getPlace().concat(" ").concat(customer.getPlaceId())));
				repository.save(customer);
				customer = new Customer();
			}
			csvParser.close();
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CSVWriter(String file, ResultSet rs) {
		BufferedWriter writer;
		try {
			writer = Files.newBufferedWriter(Paths.get(file));
			/*
			 * TODO: CRIAR OS CABECALHOS DO CSV COM BASE NUM RESULTSET (RETORNO DE DADO DO
			 * DB) TODO: CRIAR A ITERACAO QUE IRA ADICIONAR OS DADOS DO DB EM UM NOVO CSV.
			 */
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(rs));
			csvPrinter.printRecord();
			csvPrinter.flush();
			csvPrinter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}