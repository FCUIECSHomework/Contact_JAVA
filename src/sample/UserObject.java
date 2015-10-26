package sample;

import java.util.ArrayList;
import org.json.simple.JSONObject;

class UserObject {
	private String name;
	private String line;
	private String Email;
	private String uuid;
	private ArrayList<String> telephone;
	
	UserObject(JSONObject jsonObject){
		this.name = (String) jsonObject.get("name");
		this.line = (String) jsonObject.get("line");
		this.Email = (String) jsonObject.get("Email");
		this.uuid = (String) jsonObject.get("uuid");
		this.telephone = (ArrayList<String>) jsonObject.get("telephone");
	}
	
	public void SetName(String name){this.name = name;}
	public void SetLine(String line){this.line = line;}
	public void SetEmail(String Email){this.Email = Email;}
	public void AddTelephone(String telephone){this.telephone.add(telephone);}
	public String GetName(){return this.name;}
	public String GetLine(){return this.line;}
	public String GetEmail(){return this.Email;}
	public String GetUuid(){return this.uuid;}
	public ArrayList<String> GetTelephone(){return this.telephone;}
	
	
	public String PrintTelephone(){
		for(String each : this.GetTelephone()){
			System.out.println(each);
		}
		return null;
	}
	
	public void PrintUserObject(){
		System.out.println(this.GetUuid() + ":");
		System.out.println("Name:	" + this.GetName());
		System.out.println("Email:	" + this.GetEmail());
		System.out.println("Line:	" + this.GetLine());
		System.out.println("Telephone:");
		for(String each : this.GetTelephone()){
			System.out.println("	" + each);
		}
	}
}
