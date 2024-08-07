package io.github.liledg.neetcode.medium;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith
 * day.
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on
 * a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i]
 * to 0 instead.
 * <p>
 * Example 1:
 * Input: temperatures = [30,38,30,36,35,40,28]
 * Output: [1,4,1,2,1,0,0]
 */
public class DailyTemperatures {

  public static int[] dailyTemperaturesStack(int[] temperatures) {
    final Stack<AbstractMap.SimpleEntry<Integer, Integer>> monotonicDecreasingStack = new Stack<>();
    final List<AbstractMap.SimpleEntry<Integer, Integer>> valueToIndexEntryList = new ArrayList<>();
    final List<Integer> output = new ArrayList<>(temperatures.length);

    for (int i = 0; i < temperatures.length; i++) {
      output.add(0);
    }

    IntStream
        .range(0, temperatures.length)
        .forEach(i -> valueToIndexEntryList.add(i, new AbstractMap.SimpleEntry<>(temperatures[i], i)));

    valueToIndexEntryList.forEach(entry -> {
      if (monotonicDecreasingStack.isEmpty() || monotonicDecreasingStack.peek().getKey() >= entry.getKey()) {
        monotonicDecreasingStack.push(entry);
      } else {
        while (!monotonicDecreasingStack.isEmpty() && monotonicDecreasingStack.peek().getKey() < entry.getKey()) {
          AbstractMap.SimpleEntry<Integer, Integer> poppedEntry = monotonicDecreasingStack.pop();
          output.set(poppedEntry.getValue(), entry.getValue() - poppedEntry.getValue());
        }
        monotonicDecreasingStack.push(entry);
      }
    });

    return output.stream().mapToInt(i -> i).toArray();
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    final List<Integer> output = new ArrayList<>();

    for (int i = 0; i < temperatures.length; i++) {
      for (int j = i; j <= temperatures.length; j++) {
        if (j == temperatures.length) {
          output.add(0);
          break;
        }
        if (temperatures[j] > temperatures[i]) {
          output.add(j - i);
          break;
        }
      }
    }

    return output.stream().mapToInt(c -> c).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(dailyTemperaturesStack(new int[] {30, 40, 50, 60})));
  }

}
