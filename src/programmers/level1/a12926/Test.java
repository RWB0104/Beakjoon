package programmers.level1.a12926;

/**
 * 테스트 클래스
 *
 * @author RWB
 * @since 2021.12.13 Mon 16:12:50
 */
public class Test
{
	/**
	 * 메인 메서드
	 *
	 * @param args: [String[]] 파라미터
	 */
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		
		System.out.println(solution.solution("AB", 1));
		System.out.println(solution.solution("z", 1));
		System.out.println(solution.solution("a B z", 4));
	}
}