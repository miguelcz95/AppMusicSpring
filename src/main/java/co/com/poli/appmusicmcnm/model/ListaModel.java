package co.com.poli.appmusicmcnm.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "lista")
public class ListaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private ArrayList<SongModel> songs;

    public ListaModel() {
    }

    public ListaModel(Long id, String name, String description, ArrayList<SongModel> songs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.songs = songs;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ArrayList<SongModel> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongModel> songs) {
        this.songs = songs;
    }
}