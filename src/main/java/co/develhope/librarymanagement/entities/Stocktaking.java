package co.develhope.librarymanagement.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Stocktaking è un entità che tiene traccia di quante copie di un preciso libro abbiamo presso un magazzino ben
 * preciso.
 */

@Entity
@Table(name = "stocktaking")
public class Stocktaking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private int numberOfCopies;

    /*
    Libro a cui fa riferimento l'inventario.
    Per ogni libro posso avere tanti inventari (uno per ogni magazzino).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    /*
    Magazzino a cui fa riferimento l'inventario.
    In ogni magazzino abbiamo un solo inventario per ogni libro, e l'inventario fa riferimento ad un solo magazzino.
     */
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public Stocktaking(){}

    public Stocktaking(int id, int numberOfCopies, Book book, Warehouse warehouse) {
        this.id = id;
        this.numberOfCopies = numberOfCopies;
        this.book = book;
        this.warehouse = warehouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
