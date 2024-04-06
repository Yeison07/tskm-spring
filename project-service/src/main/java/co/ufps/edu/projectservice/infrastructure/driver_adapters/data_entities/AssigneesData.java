package co.ufps.edu.projectservice.infrastructure.driver_adapters.data_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignees")
public class AssigneesData {

    @Id
    private String email;

    public AssigneesData() {
    }

    public AssigneesData(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
