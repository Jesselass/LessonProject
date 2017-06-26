package trelloApi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 19.06.2017.
 */
public class Board {

    public String id;
    public String name;
    public String desc;

    public String [] labels ;

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", labels=" + labels +
                '}';
    }
}
