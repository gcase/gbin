package models;

import org.joda.time.DateTime;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Paste extends Model {

    @Id
    public Long id;

    public String guid;

    @Column(columnDefinition = "TEXT")
    public String content;

    public DateTime dateCreated;

    public Paste() {
        this.guid = UUID.randomUUID().toString();
        this.dateCreated = DateTime.now();
    }

}
