package softeer.lv2;

import java.io.*;
import java.util.*;

public class 회의실_예약 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Room> rooms = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String roomName = reader.readLine();
            rooms.put(roomName, new Room(roomName));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            String roomName = st.nextToken();
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            Room room = rooms.get(roomName);
            room.reserve(startTime, endTime);
        }

        List<String> roomNames = new ArrayList<>(rooms.keySet());
        Collections.sort(roomNames);

        for (String roomName : roomNames) {
            Room room = rooms.get(roomName);
            writer.write(room.toString());
            if (!roomName.equals(roomNames.get(roomNames.size() - 1))) {
                writer.write("-----\n");
            }
        }

        writer.flush();
    }
}
class Room {
    private final String name;
    private boolean[] reservations = new boolean[24]; // Indexes 9 to 18 are relevant
    private List<String> availableSlots = new ArrayList<>();

    public Room(String name) {
        this.name = name;
        for (int i = 9; i < 18; i++) {
            reservations[i] = false;
        }
    }

    public void reserve(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            reservations[i] = true;
        }
    }

    public void findAvailableSlots() {
        availableSlots.clear();
        int i = 9;
        while (i < 18) {
            if (!reservations[i]) {
                int start = i;
                while (i < 18 && !reservations[i]) {
                    i++;
                }
                int end = i;
                availableSlots.add(String.format("%02d-%02d", start, end));
            } else {
                i++;
            }
        }
    }

    @Override
    public String toString() {
        findAvailableSlots();
        StringBuilder sb = new StringBuilder();
        sb.append("Room ").append(name).append(":\n");
        if (availableSlots.isEmpty()) {
            sb.append("Not available\n");
        } else {
            sb.append(availableSlots.size()).append(" available:\n");
            for (String slot : availableSlots) {
                sb.append(slot).append("\n");
            }
        }
        return sb.toString();
    }
}