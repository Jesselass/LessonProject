package hw;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Dell-SSD on 19.06.2017.
 */
public class JsonExample {


        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("closed")
        @Expose
        private Boolean closed;
        @SerializedName("idBoard")
        @Expose
        private String idBoard;
        @SerializedName("pos")
        @Expose
        private Integer pos;
        @SerializedName("subscribed")
        @Expose
        private Boolean subscribed;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getClosed() {
            return closed;
        }

        public void setClosed(Boolean closed) {
            this.closed = closed;
        }

        public String getIdBoard() {
            return idBoard;
        }

        public void setIdBoard(String idBoard) {
            this.idBoard = idBoard;
        }

        public Integer getPos() {
            return pos;
        }

        public void setPos(Integer pos) {
            this.pos = pos;
        }

        public Boolean getSubscribed() {
            return subscribed;
        }

        public void setSubscribed(Boolean subscribed) {
            this.subscribed = subscribed;
        }

    }

