import com.google.gson.annotations.SerializedName;

public class CatFacts {

    @SerializedName("fact")
    public String fact;

    @SerializedName("length")
    public int length;

    @Override
    public String toString() {
        return "CatFacts{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}

