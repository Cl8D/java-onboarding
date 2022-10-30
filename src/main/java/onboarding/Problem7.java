package onboarding;

import java.util.*;

public class Problem7 {

    // 전체 사용자의 친구 관계를 정의할 Map을 선언한다.
    // key 값으로 사용자의 아이디, value 값으로 리스트로 해당 사용자의 친구 리스트가 들어간다.
    static Map<String, List<String>> friendMap;

    // 점수 정보를 관리할 Map을 선언한다.
    // key 값으로 사용자의 아이디, value 값으로 점수가 들어간다.
    static Map<String, Integer> scoreMap;

    // 사용자의 친구 목록 리스트를 관리한다.
    static List<String> userFriendList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        friendMap = new HashMap<>();
        scoreMap = new HashMap<>();

        // 전체 사용자에 대한 친구 관계를 정의한다.
        for(List<String> relationship : friends) {
            defineFriendship(relationship);
        }

        // 사용자의 친구 목록을 조회한다.
        userFriendList = friendMap.get(user);

        // 친구 관계 Map에서 사용자의 정보를 제거한다. (기준이 사용자이기 때문)
        friendMap.remove(user);

        // 다른 사용자의 친구 리스트를 조회하여 사용자의 친구 리스트와 비교한다.
        for(String diffUser : friendMap.keySet()) {
            getFriendsOfDiffUserAndCompare(diffUser);
        }

        return answer;
    }

    /**
     * 다른 사용자의 친구 리스트를 조회하여 사용자의 친구 리스트와 비교한다.
     *
     * @param diffUser 다른 사용자의 아이디
     */
    private static void getFriendsOfDiffUserAndCompare(String diffUser) {
        List<String> diffFriendList = friendMap.get(diffUser);
        for(String friendOfDiffUser : diffFriendList) {

        }
    }

    /**
     * 전체 사용자의 친구 목록을 친구 관계 Map에 저장한다.
     *
     * @param relationship 친구 관계 정보
     */
    private static void defineFriendship(List<String> relationship) {
        String userA = relationship.get(0);
        String userB = relationship.get(1);

        // 만약 처음 삽입된다면 초기화 작업을 진행해준다.
        List<String> friendListOfUserA = friendMap.getOrDefault(userA, new ArrayList<>());
        // 친구 정보를 추가한다.
        friendListOfUserA.add(userB);

        List<String> friendListOfUserB = friendMap.getOrDefault(userB, new ArrayList<>());
        friendListOfUserB.add(userA);

        // 친구 관계 Map에 추가한다.
        friendMap.put(userA, friendListOfUserA);
        friendMap.put(userB, friendListOfUserB);
    }
}
