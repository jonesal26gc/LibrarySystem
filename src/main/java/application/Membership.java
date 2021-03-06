package application;

import java.util.HashMap;

public class Membership {
    private HashMap<Integer, Member> members = new HashMap<Integer, Member>();

    public int getNumberOfMembers() {
        return members.size();
    }

    public Member addMember(Member member) {
        member.setNumber(findNextMemberNumber());
        members.put(member.getNumber(), member);
        return member;
    }

    public int findNextMemberNumber() {
        for (int number = 1; true; number++) {
            if (!members.containsKey(number)) {
                return number;
            }
        }
    }

    public void listMembers() {
        for (Member member : members.values()) {
            System.out.println(member.toString());
        }
    }
}