package about.chapter02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 누구나 자료 구조와 알고리즘 검색 퍼포먼스 비교 클래스
 *
 * @author RWB
 * @see <a href="https://rwb0104.github.io/posts/2021/07/09/about-algorithm-chapter02/">알고리즘이 중요한 까닭</a>
 * @since 2021.07.10 Sat 04:21:37
 */
public class SearchCompare
{
	// 배열 최대 크기
	private static final int MAX = 100000000;
	
	// 배열
	private static final int[] ARRAY = initArray(MAX);
	
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
		
		// 검색 대상
		int target = 86421478;
		
		long tic = System.nanoTime();
		
		int linearResult = find(target);
		
		long toc1 = System.nanoTime() - tic;
		
		tic = System.nanoTime();
		
		int binaryResult = binarySearch(target);
		
		long toc2 = System.nanoTime() - tic;
		
		StringBuilder builder = new StringBuilder();
		builder.append(target);
		builder.append("을 탐색하는데 소요된 선형 검색 프로세스: ");
		builder.append(linearResult);
		builder.append("(").append(toc1).append("ns)\n");
		builder.append(target);
		builder.append("을 탐색하는데 소요된 이진 검색 프로세스: ");
		builder.append(binaryResult);
		builder.append("(").append(toc2).append("ns)\n\n");
		builder.append("이진 검색이 약 ").append(toc1 / toc2).append("배 더 빠릅니다.");
		
		writer.write(builder.toString());
		writer.newLine();
		writer.flush();
		writer.close();
	}
	
	/**
	 * 배열 초기화 함수
	 *
	 * @param max: [int] 배열 최대 크기
	 *
	 * @return [int[]] 1 ~ max가 할당된 정수 배열
	 */
	private static int[] initArray(int max)
	{
		int[] temp = new int[max];
		
		for (int i = 0; i < max; i++)
		{
			temp[i] = i + 1;
		}
		
		return temp;
	}
	
	/**
	 * 이진 검색 및 프로세스 소요량 반환 함수
	 *
	 * @param target: [int] 검색 대상
	 *
	 * @return [int] 프로세스 소요량
	 */
	private static int binarySearch(int target)
	{
		// 프로세스 소요량
		int count = 0;
		
		// 중간값
		int mid = -1;
		
		// 구간 시작값
		int start = 1;
		
		// 구간 끝값
		int end = ARRAY.length;
		
		while (target != mid)
		{
			count++;
			
			// 목표가 시간 구간 혹은 끝 구간과 일치할 경우
			if (target == start || target == end)
			{
				break;
			}
			
			mid = (end + start) / 2;
			
			// 목표가 중간값보다 클 경우
			if (target > mid)
			{
				start = mid + 1;
			}
			
			// 목표가 중간값보다 작거나 같을 경우
			else
			{
				end = mid - 1;
			}
		}
		
		return count;
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
}