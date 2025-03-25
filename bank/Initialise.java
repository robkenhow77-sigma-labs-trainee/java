public class Initialise {
    public static Bank initializeBank() {
        Bank UBS = new Bank();

        // Create branches
        Branch londonBranch = new Branch("London");
        Branch edinburghBranch = new Branch("Edingurgh");

        // Create members
        Member rob = new Member("Robert Howarth", (int) (Math.random()* 5000));
        Member tom = new Member("Thomas Kolberg",  (int) (Math.random()* 5000));

        // Add members to branches
        londonBranch.members.put("rob", rob);
        edinburghBranch.members.put("tom", tom);

        // Add branches to bank
        UBS.branches.put("London", londonBranch);
        UBS.branches.put("Edinburgh", edinburghBranch);

        return UBS;
    }
}
