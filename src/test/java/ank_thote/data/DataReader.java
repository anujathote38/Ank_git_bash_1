package ank_thote.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	private static final String StandardCharSets = null;

	public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException {
		//Convert Json to String
		String JsonContent= FileUtils.readFileToString(new File(FilePath),StandardCharSets);
		//Convert string JsonContent to hashMap
		ObjectMapper mapper=new ObjectMapper();
	    List<HashMap<String,String>> data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	   //{map,map1}
	    return data;
	}
	
}
