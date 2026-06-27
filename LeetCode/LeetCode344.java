public class LeetCode344 {
    public void reverseString(char[] s) {
        // 왼쪽 오른쪽 위치를 저장해 스왑
        int left = 0, right = s.length - 1;
        // 역순으로 위치 변환
        while(left < right) {
            // 임시 저장 temp 생성
            char temp = s[left];
            // 스왑
            s[left] = s[right];
            s[right] = temp;
            // 2개의 포인터 값 변경
            left++;
            right--;
        }
    }
}
