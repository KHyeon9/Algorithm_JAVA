import java.io.*;
import java.util.*;

public class BOJ7798 {
    static class HotelInfo {
        int bedSize, capacity, rooms, price;
        String name;

        public HotelInfo(int bedSize, int capacity, int rooms, int price, String name) {
            this.bedSize = bedSize;
            this.capacity = capacity;
            this.rooms = rooms;
            this.price = price;
            this.name = name;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hotelCnt = Integer.parseInt(st.nextToken());
            int teamCnt = Integer.parseInt(st.nextToken());
            // 호텔 입력 저장
            HotelInfo[] hotels = new HotelInfo[hotelCnt];
            for (int i = 0; i < hotelCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int bedSize = Integer.parseInt(st.nextToken());
                int capacity = Integer.parseInt(st.nextToken());
                int rooms = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                
                hotels[i] = new HotelInfo(bedSize, capacity, rooms, price, name);
            }
            System.out.println("Case #" + test + ":");
            // 참가자 확인
            for (int i = 0; i < teamCnt; i++) {
                st = new StringTokenizer(br.readLine());
                char wantBedSize = st.nextToken().charAt(0);
                int joinTeamCnt = Integer.parseInt(st.nextToken());
                int maxCapacity = Integer.parseInt(st.nextToken());

                HotelInfo answerHotel = null;
                int minPrice = Integer.MAX_VALUE;
                for (int j = 0; j < hotelCnt; j++) {
                    int price = isOk(wantBedSize, joinTeamCnt, maxCapacity, hotels[j]);
                    if (price != -1) {
                        if (price < minPrice) {
                            minPrice = price;
                            answerHotel = hotels[j];
                        } else if (minPrice == price) {
                            answerHotel = hotels[j].bedSize > answerHotel.bedSize ? hotels[j] : answerHotel;
                        }

                    }
                }
                if (answerHotel == null) {
                    System.out.println("no-hotel");
                } else {
                    System.out.println(minPrice + " " + answerHotel.name);
                }
            }
        }
    }

    private static int isOk(char bedSize, int teamCnt, int maxCapacity, HotelInfo hotel) {
        // 사이즈 체크
        if (!sizeCheck(bedSize, hotel.bedSize)) return -1;
        // 방 갯수 체크 (최소 가용 인원을 기준으로 계산)
        int minCapacity = Math.min(hotel.capacity, maxCapacity);
        int needRoomCnt = (teamCnt + minCapacity - 1) / minCapacity;
        if (needRoomCnt > hotel.rooms) return -1;
        // 총 금액 반환
        return needRoomCnt * hotel.price;
    }
    // 사이즈 체크
    private static boolean sizeCheck(char needBedSize, int bedSize) {
        switch (needBedSize) {
            case 'A': return 20 <= bedSize && bedSize <= 35;
            case 'B': return 36 <= bedSize && bedSize <= 48;
            case 'C': return 49 <= bedSize && bedSize <= 62;
        }
        return false;
    }
}
