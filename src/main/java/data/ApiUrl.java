package data;

public enum ApiUrl {

    FILMS("/films"),
    CONCRETE_FILM("/films/{id}"),
    CONCRETE_PEOPLE("/people/{id}");

    private String url;

    ApiUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
