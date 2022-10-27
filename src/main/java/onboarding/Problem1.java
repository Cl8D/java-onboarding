package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 입력 페이지 검증 후 예외 사항일 경우 -1을 리턴한다.
        if (isNotPageValid(pobi) || isNotPageValid(crong)) {
            return -1;
        }

        // 포비의 왼쪽, 오른쪽 페이지 번호를 구한다.
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        // 크롱의 왼쪽, 오른쪽 페이지 번호를 구한다.
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);


        return answer;
    }

    /**
     * 입력 페이지에 대한 검증을 진행한다.
     *
     * @param pageNums 사용자의 페이지 번호 리스트
     * @return 올바르지 않은 페이지 리스트라면 true, 아니라면 false
     */
    private static boolean isNotPageValid(List<Integer> pageNums) {
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        /* 입력 페이지에 대해서 검증을 진행한다. 다음은 예외 사항으로 간주한다.
            1. 페이지의 범위가 1~400 사이가 아닌 경우
            2. 페이지가 시작이나 마지막 면인 경우
            3. 왼쪽 페이지가 홀수가 아니고, 오른쪽 페이지가 짝수가 아닌 경우
            4. 왼쪽, 오른쪽 페이지의 차가 1이 아닌 경우 (연속된 페이지가 아님)
         */
        if (isNotPageRange(leftPage, rightPage) || isPageFirstOrLast(leftPage) ||
                isNotPageOddAndEven(leftPage, rightPage) || isNotPageContinuous(leftPage, rightPage)) {
            return true;
        }

        return false;
    }

    /**
     * 입력 페이지의 범위가 1~400 사이가 아닌지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 1~400 사이가 아니라면 true, 맞다면 false
     */
    private static boolean isNotPageRange(int leftPage, int rightPage) {
        return leftPage < 1 || leftPage >= 400 || rightPage < 2 || rightPage > 400;
    }

    /**
     * 왼쪽 페이지 번호가 시작 면이거나 마지막 면인지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @return 왼쪽 페이지의 값이 1이거나 399라면 true, 아니라면 false
     */
    private static boolean isPageFirstOrLast(int leftPage) {
        return leftPage == 1 || leftPage == 399;
    }

    /**
     * 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 왼쪽 페이지가 홀수가 아니고 오른쪽 페이지가 짝수가 아니면 true, 아니라면 false
     */
    private static boolean isNotPageOddAndEven(int leftPage, int rightPage) {
        return leftPage % 2 != 1 && rightPage % 2 != 0;
    }

    /**
     * 왼쪽, 오른쪽 페이지가 연속적이지 않은지 확인한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 오른쪽, 왼쪽 페이지의 차가 1이 아니라면 true, 아니라면 false
     */
    private static boolean isNotPageContinuous(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }
    
    /**
     * 입력 받은 페이지의 각 자릿수를 담은 배열을 구한다.
     *
     * @param page 페이지 번호
     * @return 각 자릿수가 담긴 배열
     */
    private static int[] getPageValueArray(int page) {
        String[] digitStrArr = String.valueOf(page).split("");

        return Stream.of(digitStrArr).mapToInt(Integer::parseInt).toArray();
    }

}