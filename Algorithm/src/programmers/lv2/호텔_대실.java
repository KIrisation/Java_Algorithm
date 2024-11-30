package programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 호텔_대실 {

    static class Room implements Comparable<Room> {

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

        @Override
        public int compareTo(Room o) {
            return this.startTime - o.startTime;
        }
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        for (String[] time : book_time) {
            String[] firstStartTimeSplit = time[0].split(":");
            int startTime = (Integer.parseInt(firstStartTimeSplit[0]) * 60) + Integer.parseInt(firstStartTimeSplit[1]);

            String[] secondEndTimeSplit = time[1].split(":");
            int endTime = (Integer.parseInt(secondEndTimeSplit[1]) * 60) + Integer.parseInt(secondEndTimeSplit[1]);

            int cleanTime = 10;
            rooms.offer(new Room(startTime, endTime + cleanTime));
        }

        PriorityQueue<Room> fullReservationRooms = new PriorityQueue<>(Comparator.comparingInt(Room::getEndTime));
        int roomCnt = 0;
        while (!rooms.isEmpty()) {
            Room currentRoom = rooms.poll();

            while (!fullReservationRooms.isEmpty() && fullReservationRooms.peek().getEndTime() <= currentRoom.getStartTime()) {
                fullReservationRooms.poll();
            }

            fullReservationRooms.offer(currentRoom);
            roomCnt = Math.max(roomCnt, fullReservationRooms.size());
        }

        return roomCnt;
    }

}
