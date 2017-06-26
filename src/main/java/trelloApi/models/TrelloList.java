package trelloApi.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Dell-SSD on 19.06.2017.
 */
public class TrelloList {

        @SerializedName("id")

        public String id;
        @SerializedName("name")

        public String name;
        @SerializedName("closed")

        public Boolean closed;
        @SerializedName("idBoard")

        public String idBoard;
        @SerializedName("pos")

        public Double pos;
        @SerializedName("subscribed")

        public Boolean subscribed;

    @Override
    public String toString() {
        return "TrelloList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", idBoard='" + idBoard + '\'' +
                ", pos=" + pos +
                ", subscribed=" + subscribed +
                '}';
    }
}

