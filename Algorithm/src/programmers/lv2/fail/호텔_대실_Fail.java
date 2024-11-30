package programmers.lv2.fail;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔_대실_Fail {

    static class Room {
        private final int startTime;
        private final int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

    }

    public int solution(String[][] book_time) {
        PriorityQueue<Room> rooms = new PriorityQueue<>(Comparator.comparingInt(Room::getStartTime));
        for (String[] time : book_time) {
            String[] firstStartTimeSplit = time[0].split(":");
            int startTime = (Integer.parseInt(firstStartTimeSplit[0]) * 60) + Integer.parseInt(firstStartTimeSplit[1]);

            String[] secondEndTimeSplit = time[1].split(":");
            int endTime = (Integer.parseInt(secondEndTimeSplit[0]) * 60) + Integer.parseInt(secondEndTimeSplit[1]);

            int cleanTime = 10;
            rooms.offer(new Room(startTime, endTime + cleanTime));
        }

        PriorityQueue<Room> occupiedRooms = new PriorityQueue<>(Comparator.comparingInt(Room::getEndTime)); // 퇴실시간에
        // 따른 오름차순 정렬
        int maxRooms = 0;
        while (!rooms.isEmpty()) {
            Room currentRoom = rooms.poll();

            while (!occupiedRooms.isEmpty() && occupiedRooms.peek().getEndTime() <= currentRoom.getStartTime()) {
                occupiedRooms.poll();
            }

            occupiedRooms.add(currentRoom);
            maxRooms = Math.max(maxRooms, occupiedRooms.size());
        }

        return maxRooms;
    }
}
