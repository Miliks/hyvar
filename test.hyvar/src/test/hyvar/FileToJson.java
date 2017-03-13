package test.hyvar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  JSONObject jo = new JSONObject();
		  jo.put("name", "ECU_C.sct");
		  String content = null;
		   try {
			content = new Scanner(new File("resources/ECU_C.sct")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  jo.put("content", content);
		  
		  JSONArray ja = new JSONArray();
		  ja.add(jo);
		  
		  JSONObject mainObj = new JSONObject();
		  mainObj.put("msg_type", "codegen_statecharts");
		  mainObj.put("statechartVariants", ja);
	
		  System.out.println(mainObj);
	}

}
