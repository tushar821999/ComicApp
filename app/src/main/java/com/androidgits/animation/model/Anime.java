package com.androidgits.animation.model;

/**
 * Created by Lenovo on 5/9/2018.
 */

public class Anime {
    private String name;
    private String description;
    private String rating;
    private int np_episode;
    private String image_url;
    private String categorie;
    private String studio;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int np_episode, String image_url, String categorie, String studio) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.np_episode = np_episode;
        this.image_url = image_url;
        this.categorie = categorie;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNp_episode() {
        return np_episode;
    }

    public void setNp_episode(int np_episode) {
        this.np_episode = np_episode;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
