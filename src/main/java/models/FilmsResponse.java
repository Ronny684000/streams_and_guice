package models;

import lombok.Data;

@Data
public class FilmsResponse {

    private int count;
    private Object next;
    private Object previous;
    private Film[] results;
}
