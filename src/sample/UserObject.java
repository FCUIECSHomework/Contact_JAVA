package sample;

import java.util.ArrayList;

import org.json.simple.JSONObject;

class UserObject {
    private String name;
    private String line;
    private String Email;
    private String uuid;
    private ArrayList<String> telephone;

    UserObject(JSONObject jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.line = (String) jsonObject.get("line");
        this.Email = (String) jsonObject.get("Email");
        this.uuid = (String) jsonObject.get("uuid");
        this.telephone = (ArrayList<String>) jsonObject.get("telephone");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void addTelephone(String telephone) {
        this.telephone.add(telephone);
    }

    public String getName() {
        return this.name;
    }

    public String getLine() {
        return this.line;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getUuid() {
        return this.uuid;
    }

    public ArrayList<String> getTelephone() {
        return this.telephone;
    }


    public String PrintTelephone() {
        for (String each : this.getTelephone()) {
            System.out.println(each);
        }
        return null;
    }

    public void PrintUserObject() {
        System.out.println(this.getUuid() + ":");
        System.out.println("Name:	" + this.getName());
        System.out.println("Email:	" + this.getEmail());
        System.out.println("Line:	" + this.getLine());
        System.out.println("Telephone:");
        for (String each : this.getTelephone()) {
            System.out.println("	" + each);
        }
    }

    public String toString() {
        return this.name;
    }
}
