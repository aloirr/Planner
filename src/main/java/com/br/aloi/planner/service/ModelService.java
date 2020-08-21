package com.br.aloi.planner.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.GenericModel;
import com.br.aloi.planner.model.ModelAttribute;
import com.br.aloi.planner.repository.ModelRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.errors.ApiException;

@Service
public class ModelService {

  @Autowired
  private ModelRepository modelRepository;

  public void deleteAll() {
	 if (modelRepository.findAll().iterator().hasNext()) {
		modelRepository.deleteAll();
	 }
  }

  public void readCSVfile(InputStream in) throws ApiException, InterruptedException {
	 Reader reader = new InputStreamReader(in);
	 try {
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
			 .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
			 .withAllowMissingColumnNames());
		GenericModel csvModel = new GenericModel();
		Long count = 0L;
		for (CSVRecord csvRecord : csvParser) {
		  List<ModelAttribute> attributesList = new ArrayList<>();
		  for (String header : csvRecord.getParser().getHeaderNames()) {
			 attributesList.add(new ModelAttribute(count, header, csvRecord.get(header)));
		  }

		  String query = "";
		  for (ModelAttribute modelAttr : attributesList) {
			 query += "+" + modelAttr.getValue().replaceAll(" ", "+") + "+";
		  }
		  attributesList.add(new ModelAttribute(count, "latitude", MapsApiService.getLat(
				query).toString()));
		  attributesList.add(new ModelAttribute(count, "longitude", MapsApiService.getLng(
				query).toString()));
		  Type baseType = new TypeToken<List<ModelAttribute>>() {
		  }.getType();
		  Gson gson = new Gson();
		  String modelAttributesJson = gson.toJson(attributesList, baseType);
		  csvModel.setAttributes(modelAttributesJson);
		  csvModel.setId(count.longValue());
		  modelRepository.save(csvModel);
		  csvModel = new GenericModel();
		  count++;
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
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(rs));
		csvPrinter.printRecord();
		csvPrinter.flush();
		csvPrinter.close();
	 } catch (IOException e) {
		e.printStackTrace();
	 } catch (SQLException e) {
		e.printStackTrace();
	 }
  }

  public void save(GenericModel csvModel) {
	 modelRepository.save(csvModel);
  }

  public List<GenericModel> findAll() {
	 List<GenericModel> listModels = new ArrayList<>();
	 Iterator<GenericModel> it = modelRepository.findAll().iterator();
	 while (it.hasNext()) {
		listModels.add(it.next());
	 }
	 return listModels;
  }

  public void delete(GenericModel csvModel) {
	 modelRepository.delete(csvModel);
  }

  public List<GenericModel> findByAttribute(String key, Object value) {

	 return null;
  }

  public List<GenericModel> sortBy(List<GenericModel> csvModels, String key) {

	 return csvModels;
  }

  public Optional<GenericModel> findById(Long id) {
	 return modelRepository.findById(id);
  }
}