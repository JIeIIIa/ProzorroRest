package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "endpoint_data")
@Table(name = "endpoint_data")
public class EndpointData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String endpoint;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "endpoint_data_id")
    private List<DataItem> data = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data.clear();
        if (Objects.nonNull(data)) {
            this.data.addAll(data);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndpointData that = (EndpointData) o;
        return endpoint.equals(that.endpoint) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoint, data);
    }

    @Override
    public String toString() {
        return "EndpointData{" +
                "id=" + id +
                ", endpoint='" + endpoint + '\'' +
                ", data=" + data +
                '}';
    }
}
