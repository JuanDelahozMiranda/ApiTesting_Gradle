package co.com.perficient.Enums;

public enum serviceUrl {
    BASE_URL("https://"),
    URL("petstore.swagger.io/v2/store/order");

    private String uri;

    serviceUrl(String uri){ this.uri = uri; }

    public String toString(){ return uri;}
}
