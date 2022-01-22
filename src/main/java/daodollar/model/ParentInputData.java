package daodollar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentInputData {

    @JsonProperty
    private Parent[] data;

    public Parent[] getData() {
        return data;
    }

    public void setData(Parent[] data) {
        this.data = data;
    }
}
