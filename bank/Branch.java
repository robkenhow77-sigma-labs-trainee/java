import java.util.HashMap;

public class Branch {
    String location;
    HashMap<String, Member> members = new HashMap<String, Member>();

    public Branch(String branchLocation){
        this.location = branchLocation;
    }
}