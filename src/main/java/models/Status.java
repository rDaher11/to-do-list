package models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    TODO,
    IN_PROGRESS,
    DONE;
    @JsonCreator
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
             if (status.name().equalsIgnoreCase(value)) {
                 return status;
             }
        }
        return TODO ;
    }
    @JsonValue
    public String toJson() {
        return name();
    }
}
