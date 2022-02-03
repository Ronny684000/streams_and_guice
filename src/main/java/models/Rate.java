package models;

import lombok.Data;

@Data
public class Rate {

    private int Cur_ID;
    private String Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;
}
