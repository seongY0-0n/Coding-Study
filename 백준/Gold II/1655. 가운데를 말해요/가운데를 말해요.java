import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 정수 갯수 입력
		int N = Integer.parseInt(br.readLine());
		// 최대힙 : 루트에 최댓값이 있는 이진 트리 (내림차순 정렬) // new PriorityQueue<>(Comparator.reverseOrder())
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		// 최소힙 : 루트에 최솟값이 있는 이진 트리 (오름차순 정렬)	 // new PriorityQueue<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
		// 문제 예시 : 1, 5, 2, 10, -99, 7, 5 면
		// 최대힙 : -99, 1, 2, 5가 저장되고
		// 최소힙 : 5, 7, 10이 저장됨
		// => 최대힙의 루트가 중간값이 됨!
		
		for (int i = 0; i < N; i++) {
			// 수빈이가 외친 정수 1개
			int num = Integer.parseInt(br.readLine());
			
			// 짝수번째 숫자면 maxHeap에 저장
			if (i % 2 == 0) maxHeap.add(num);
			// 홀수번째 숫자면 minHaep에 추가
			else minHeap.add(num);
			
			if (!minHeap.isEmpty() && !maxHeap.isEmpty())
				// 최대힙의 루트 > 최소힙의 루트라면 둘을 교환하기
				if (maxHeap.peek() > minHeap.peek()) {
					int temp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(temp);
				}
			// 중간값 저장
			// 수빈이가 외친 수의 개수가 짝수개면 중간에 있는 두 수 중 작은 수를 출력해야함
			// -> maxHeap의 루트만 출력하면 됨
			sb.append(maxHeap.peek()).append('\n');
		}
		
		// 출력하기
		System.out.print(sb);
		
	}
}
