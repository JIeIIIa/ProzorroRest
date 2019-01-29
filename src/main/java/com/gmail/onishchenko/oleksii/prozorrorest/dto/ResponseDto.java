package com.gmail.onishchenko.oleksii.prozorrorest.dto;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.DataItem;

import java.util.List;
import java.util.Objects;

public class ResponseDto {
    private List<DataItem> data;

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto that = (ResponseDto) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
