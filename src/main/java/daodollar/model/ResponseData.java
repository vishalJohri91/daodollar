package daodollar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {

    @JsonProperty
    private List<ParentChildRelation> data;

    public List<ParentChildRelation> getData() {
        return data;
    }

    public void setData(List<ParentChildRelation> data) {
        this.data = data;
    }

    public void addData(ParentChildRelation parentChildRelation) {

        if(data == null)
            data = new ArrayList<>();

        data.add(parentChildRelation);
    }
}


