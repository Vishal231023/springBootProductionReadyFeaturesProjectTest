package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="departments")
@ToString
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @OneToOne()
    @JoinColumn(name = "department_Manager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workersInDepartment",fetch = FetchType.LAZY)
    Set<EmployeeEntity> workers;
    @ManyToMany(mappedBy = "freelanceDepartments")
    private Set<EmployeeEntity> freelancers;


    public Set<EmployeeEntity> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(Set<EmployeeEntity> freelancers) {
        this.freelancers = freelancers;
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

    public EmployeeEntity getManager() {
        return manager;
    }

    // Explicitly define the setter (optional if Lombok works)
    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }
    public Set<EmployeeEntity> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeEntity> workers) {
        this.workers = workers;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }


}
