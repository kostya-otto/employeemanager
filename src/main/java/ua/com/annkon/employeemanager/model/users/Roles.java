package ua.com.annkon.employeemanager.model.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Roles extends Base{

    @Enumerated(EnumType.STRING)
    Status status;

    String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    List<Users> users;

    public Roles() {
    }

    public Roles(Status status, String name, List<Users> users) {
        this.status = status;
        this.name = name;
        this.users = users;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
