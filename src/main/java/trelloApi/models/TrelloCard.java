package trelloApi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell-SSD on 20.06.2017.
 */
public class TrelloCard {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return "TrelloCard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
