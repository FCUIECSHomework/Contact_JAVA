package sample;//import org.json.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
class JsonContact{
	private JSONObject jsonObject = new JSONObject();
	String fileName = "test.json";
	
	JsonContact(){
		this.loadJsonFile();
		/*
		JSONObject user = new JSONObject();
		user.put("name", "Sam");
		JSONArray list = new JSONArray();
		list.add("0913-530192");
		list.add("0800-089457");
		user.put("telephone", list);
		
		user.put("line", "murkblood");
		user.put("Email", "s951010sam@gmil.com");
		String s = UUID.randomUUID().toString();
		user.put("uuid", s);
		jsonObject.put(s, user);


		JSONObject test = new JSONObject();
		test.put("name", "Andy");
		JSONArray list1 = new JSONArray();
		list1.add("0888-123456");
		
		test.put("telephone", list1);
		
		test.put("line", "215631");
		test.put("Email", "123@yahoo.com.tw");
		s = UUID.randomUUID().toString();
		test.put("uuid", s);
		jsonObject.put(s, test);
		*/
	}

	public ArrayList<String> getAllKey(){
		Set<String> keySet = jsonObject.keySet();
		ArrayList<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);
		return keyList;
	}
	
	public void removeContact(String uuid){
		this.loadJsonFile();
		jsonObject.remove(uuid);
		this.writeJsonFile();
	}
	
	public UserObject[] getAllContact(){
		this.loadJsonFile();
		ArrayList<String> keyArray = new ArrayList<String>();
		keyArray = this.getAllKey();
		UserObject[] userObjectArray = new UserObject[keyArray.size()];
		int i = 0;
		for(String key : keyArray){
			//System.out.println(key);
			userObjectArray[i++] = new UserObject((JSONObject)jsonObject.get(key));
		}
		this.writeJsonFile();
		return userObjectArray;
	}
	
	
	public void registerContact(String name, String line, String Email, String[] telephone){
		this.loadJsonFile();
		JSONObject data = new JSONObject();
		data.put("name", name);
		data.put("line", line);
		data.put("Email", Email);
		JSONArray telephoneArray = new JSONArray();
		for(String each : telephone){
			telephoneArray.add(each);
		}
		data.put("telephone", telephoneArray);

		String uuid = UUID.randomUUID().toString();
		data.put("uuid", uuid);
		jsonObject.put(uuid, data);
		this.writeJsonFile();
	}
	
	public void editContact(String uuid, String name, String line, String Email, String[] telephone){
		this.loadJsonFile();
		JSONObject temp = new JSONObject();
		temp.put("name", name);
		temp.put("line", line);
		temp.put("Email", Email);
		JSONArray telephoneArray = new JSONArray();
		for(String each : telephone){
			System.out.println(each);
			telephoneArray.add(each);
		}
		temp.put("telephone", telephoneArray);
		temp.put("uuid", uuid);
		jsonObject.remove(uuid);
		jsonObject.put(uuid, temp);
		this.writeJsonFile();
	}
	
	public void writeJsonFile(){
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			fileWriter.write(jsonObject.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(jsonObject);
	}
	
	public void loadJsonFile(){
		JSONParser parser = new JSONParser();
			try {
				FileReader fileReader = new FileReader(fileName);
				jsonObject = (JSONObject) parser.parse(fileReader);
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}