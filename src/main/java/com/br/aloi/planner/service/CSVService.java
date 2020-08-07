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

import com.br.aloi.planner.model.CustomerModel;
import com.br.aloi.planner.model.NeighborhoodModel;
import com.google.maps.errors.ApiException;

@Service
public class CSVService {

  @Autowired
  private CustomerService repository;
  @Autowired
  private NeighborhoodService neighborhoodService;

  public void CSVReadAutoGetHeaders(InputStream in) throws ApiException,
		InterruptedException {
	 Reader reader = new InputStreamReader(in);
	 try {
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
			 .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
			 .withAllowMissingColumnNames());
		CustomerModel customer = new CustomerModel();
		String queryCoord;
		for (CSVRecord csvRecord : csvParser) {
		  customer.setCustomerId(Integer.parseInt(csvRecord.get("customerId").replaceAll(
				"[^0-9]", "")));
		  customer.setSectorId(csvRecord.get("sectorId"));
//				customer.setPlaceId(csvRecord.get("placeId"));
		  customer.setCompanyName(csvRecord.get("companyName"));
		  customer.setTradeName(csvRecord.get("tradeName"));
		  customer.setPlace(csvRecord.get("place"));
		  customer.setNeighborhood(csvRecord.get("neighborhood"));
		  neighborhoodService.save(new NeighborhoodModel(csvRecord.get("neighborhood")
				.toUpperCase(), "false", csvRecord.get("city"), 0));
//				customer.setVisitDay(csvRecord.get("visitDay"));
		  customer.setCity(csvRecord.get("city"));
		  customer.setRegion(csvRecord.get("region"));
		  customer.setPostalCode(csvRecord.get("postalCode"));
		  queryCoord = (customer.getRegion() + "+" + customer.getCity() + "+" + customer
				.getNeighborhood() + "+" + customer.getPlace() + "+" + customer
					 .getPostalCode()).replace(" ", "+");
		  System.out.println(queryCoord);
		  customer.setLatitude(MapsApiService.getLat(queryCoord).toString());
		  customer.setLongitude(MapsApiService.getLng(queryCoord).toString());
		  repository.save(customer);
		  customer = new CustomerModel();
		}
		csvParser.close();
		neighborhoodService.findAll().stream().forEach(s -> {
		  s.setNeighborhoodSize(repository.neighborhoodsSize(s.getNeighborhood()));
		  neighborhoodService.save(s);
		});

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