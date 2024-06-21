import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Room {
    int level;
    int num;
    Member[] members;
    String state;

    public Room(int level, int m) {
        this.level = level;
        this.num = 0;
        this.members = new Member[m];
        this.state = "Waiting!";
    }

    public boolean canJoin(int playerLevel) {
        return this.state.equals("Waiting!") && playerLevel >= this.level - 10 && playerLevel <= this.level + 10;
    }

    public void addMember(Member member) {
        if (num < members.length) {
            members[num++] = member;
            if (num == members.length) {
                state = "Started!";
            }
        }
    }
}

class Member implements Comparable<Member> {
    int level;
    String nickname;

    public Member(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Member other) {
        return this.nickname.compareTo(other.nickname);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int playerLevel = Integer.parseInt(st.nextToken());
            String playerNickname = st.nextToken();
            Member newMember = new Member(playerLevel, playerNickname);

            boolean isFind = false;
            for (Room room : rooms) {
                if (room.canJoin(playerLevel)) {
                    room.addMember(newMember);
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                Room newRoom = new Room(playerLevel, m);
                newRoom.addMember(newMember);
                rooms.add(newRoom);
            }
        }

        for (Room room : rooms) {
            System.out.println(room.state);
            Arrays.sort(room.members, 0, room.num);  // room.num 위치까지만 정렬
            for (Member member : room.members) {
                if (member != null) {
                    System.out.println(member.level + " " + member.nickname);
                }
            }
        }
    }
}
