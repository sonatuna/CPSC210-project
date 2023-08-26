package persistence;

import org.json.JSONObject;

// this class contains code based on the JsonWriterTest class in the JsonSerializationProject
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/
// main/persistence/Writable.java
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}

