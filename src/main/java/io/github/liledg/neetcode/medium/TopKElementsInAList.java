package io.github.liledg.neetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKElementsInAList {

  //O(NlogN)
  public static int[] topKFrequent(int[] nums, int k) {
    final Map<Integer, Long> frequencyMap = Arrays
        .stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return Arrays
        .stream(nums)
        .boxed()
        .distinct()
        .sorted(Comparator.comparing(frequencyMap::get).reversed())
        .limit(k)
        .mapToInt(i -> i)
        .toArray();
  }

  //O(N + K)
  public static int[] topKFrequent2(int[] nums, int k) {
    final Map<Integer, Long> frequencyMap = Arrays
        .stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final List<List<Integer>> frequencyToListOfElementList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      frequencyToListOfElementList.add(new ArrayList<>());
    }

    frequencyMap.forEach((key, value) -> frequencyToListOfElementList.get(value.intValue() - 1).add(key));

    final List<Integer> result = new ArrayList<>();
    for (int i = frequencyToListOfElementList.size() - 1; i >= 0; i--) {
      if (k == 0) {
        break;
      }
      if (!frequencyToListOfElementList.get(i).isEmpty()) {
        for (int j = 0; j < frequencyToListOfElementList.get(i).size(); j++) {
          if (k != 0) {
            result.add(frequencyToListOfElementList.get(i).get(j));
            k--;
          } else {
            break;
          }
        }
      }
    }

    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent2(new int[] {1, 2, 2, 2, 3, 4, 4, 6, 6, 6, 7, 8, 8, 8, 8}, 3)));
    System.out.println(Arrays.toString(topKFrequent2(new int[] {1, 2, 2, 2, 3, 4, 4, 6, 6, 6, 7, 8, 8, 8, 8}, 3)));
  }
}
