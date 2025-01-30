package guilherme.zorato.libraryappbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_publisher")
    private String publisher;
    @Column(name = "book_publication_year")
    private int publication_year;
    @Column(name = "book_genre")
    private String genre;
    @Column(name = "book_quantity")
    private int quantity;
    @Column(name = "book_available")
    private int available;
    @Column(name = "book_rental_price")
    private float price;
    @Column(name = "book_image_url")
    private String image_url;

    public Book() {
        this(0L,"","","",0,"",0,0,0,"");
    }

    public Book(Long id, String title, String author, String publisher, int publication_year, String genre, int quantity, int available, float price, String image_url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.genre = genre;
        this.quantity = quantity;
        this.available = available;
        this.price = price;
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
