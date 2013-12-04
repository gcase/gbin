package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Paste extends Model {

    @Id
    public String id;

    public String guid;

    @Column(length = 2000)
    public String content;

    public Paste() {
        this.guid = UUID.randomUUID().toString();
    }

}
