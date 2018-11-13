package com.example.consultants.week4_daily1;

import com.example.consultants.week4_daily1.Person.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RandomParser {

    private static String title;
    private static String first;
    private static String last;
    private static List<JSONObject> jsonObjectList = new ArrayList<>();
    private static List<Person> personList = new ArrayList<>();
    private static String gender;
    private static String nat;


    public static List<Person>  parsePerson(String responseStr) {
        JSONObject response = null;
        try {
            response = new JSONObject(responseStr);
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                jsonObjectList.add(results.getJSONObject(i));
            }
            for (JSONObject user: jsonObjectList) {
                JSONObject name = user.getJSONObject("name");
                title = name.getString("title");
                first = name.getString("first");
                last = name.getString("last");
                gender = user.getString("gender");
                nat = user.getString("nat");
                Person person = new Person(nat, first, last, gender, title);
                personList.add(person);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personList;

    }
}
