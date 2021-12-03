package pl.camp.it.rant.a.game.model;

public class Game {

    private String title;
    private String publisher;
    private double rentalPrice;
    private String golLink;
    private String poster;

    public Game(String title, String publisher, double rentalPrice, String golLink, String poster){
        this.title = title;
        this.publisher = publisher;
        this.rentalPrice = rentalPrice;
        this.golLink = golLink;
        this.poster = poster;

    }
    public Game(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getGolLink() {
        return golLink;
    }

    public void setGolLink(String golLink) {
        this.golLink = golLink;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
