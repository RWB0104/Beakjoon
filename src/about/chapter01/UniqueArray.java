package about.chapter01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 누구나 자료 구조와 알고리즘 집합 배열 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/07/10/about-algorithm-chapter01">자료구조가 중요한 까닭</a>
 * @since 2021.07.10 Sat 01:30:56
 */
public class UniqueArray
{
	// 배열
	private static final int[] ARRAY = { 6, 43, 14, 9, 94 };
	
	/**
	 * 메인 함수
	 *
	 * @param args: [String[]] 매개변수
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 삽입할 인덱스
		int index = 2;
		
		// 삽입할 요소
		int item = 55;
		
		boolean result = hasInserted(index, item);
		
		StringBuilder builder = new StringBuilder();
		builder.append(index);
		builder.append("번 째 인덱스에 ");
		builder.append(item);
		builder.append(" 삽입 결과: ");
		builder.append(result);
		
		writer.write(builder.toString());
		writer.newLine();
		writer.flush();
		writer.close();
	}
	
	/**
	 * 집합 배열 삽입 결과 반환 함수
	 *
	 * @param index: [int] 삽입 위치
	 * @param item: [int] 삽입할 요소
	 *
	 * @return [boolean] 삽입 결과
	 */
	private static boolean hasInserted(int index, int item)
	{
		int result = find(item);
		
		// 중복되지 않을 경우
		if (result == -1)
		{
			insert(index, item);
			
			return true;
		}
		
		// 중복될 경우
		else
		{
			return false;
		}
	}
	
	/**
	 * 요소 검색 및 인덱스 반환 함수
	 *
	 * @param target: [int] 목표 숫자
	 *
	 * @return [int] 인덱스
	 */
	private static int find(int target)
	{
		// 인덱스
		int result = -1;
		
		for (int i = 0; i < ARRAY.length; i++)
		{
			// 목표 숫자와 배열의 값이 일치할 경우
			if (target == ARRAY[i])
			{
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 배열 삽입 함수
	 *
	 * @param index: [int] 삽입 위치
	 * @param item: [int] 삽입할 요소
	 */
	@SuppressWarnings("ManualArrayCopy")
	private static void insert(int index, int item)
	{
		// 배열의 값이 -1(빈 요소)가 아닐 경우
		if (ARRAY[index] != -1)
		{
			for (int i = ARRAY.length - 1; i > index; i--)
			{
				ARRAY[i] = ARRAY[i - 1];
			}
		}
		
		ARRAY[index] = item;
	}
}