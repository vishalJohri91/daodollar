package daodollar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildInputData {

    @JsonProperty
    private Child[] data;

    public Child[] getData() {
        return data;
    }

    public void setData(Child[] data) {
        this.data = data;
    }
}
