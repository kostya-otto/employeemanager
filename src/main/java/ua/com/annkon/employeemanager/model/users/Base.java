package ua.com.annkon.employeemanager.model.users;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    Long id;

    @CreatedDate
    Date created;

    @LastModifiedDate
    Date updates;

    @Enumerated(EnumType.STRING)
    Status status;

    public Base() {
    }

    public Base(Long id, Date created, Date updates, Status status) {
        this.id = id;
        this.created = created;
        this.updates = updates;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdates() {
        return updates;
    }

    public void setUpdates(Date updates) {
        this.updates = updates;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
