package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.style1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tag")
@Table(name = "tag")
//@NaturalIdCache
/*@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)*/
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NaturalId // immutable : value can not be changed
    private String name;

    @OneToMany(
            mappedBy = "tag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostTag> posts = new ArrayList<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, List<PostTag> posts) {
        this.name = name;
        this.posts = posts;
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

    public List<PostTag> getPosts() {
        return posts;
    }

    public void setPosts(List<PostTag> posts) {
        this.posts = posts;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Tag that = (Tag) obj;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }*/


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}

