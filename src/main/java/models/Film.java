package models;

import lombok.Data;

@Data
public class Film {

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private String[] characters;
    private String[] planets;
    private String[] starships;
    private String[] vehicles;
    private String[] species;
    private String created;
    private String edited;
    private String url;
}
