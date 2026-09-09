public class LeetCode1603 {
    // Design Parking System
    class ParkingSystem {
        int bigCnt;
        int mediumCnt;
        int smallCnt;

        public ParkingSystem(int big, int medium, int small) {
            this.bigCnt = big;
            this.mediumCnt = medium;
            this.smallCnt = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && bigCnt > 0) {
                bigCnt--;
                return true;
            } else if (carType == 2 && mediumCnt > 0) {
                mediumCnt--;
                return true;
            } else if (carType == 3 && smallCnt > 0) {
                smallCnt--;
                return true;
            }
            return false;
        }
    }
}

