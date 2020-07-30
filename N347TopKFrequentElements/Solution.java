package N347TopKFrequentElements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 先把所有的数字都存到一个 map 里，用来统计每个数字出现的次数（频率）
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

//        for (int key : map.keySet()) {
//            System.out.println(key + ": " + map.get(key));
//        }
//        System.out.println();

        // 为了找到前 k 个出现最多的数字，可以使用一个最小堆实现
        // 遍历 map 中的所有 key，建立一个大小为 k 的最小堆
        // 如果堆的大小 < k，那么直接添加
        // 如果堆已经有 k 个元素了，那么如果新的 key 的频率大于堆中元素的最小的频率
        // 那就用这个新的 key 替换最小频率的元素
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>() {
            // 这里直接传入一个匿名类给优先队列的构造函数，定义如何比较大小（优先级）
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int key : map.keySet()) {
//            System.out.println("Checking key: " + key);
            if (queue.size() < k) {
//                System.out.println("queue.size() = " + queue.size() + " < k");
//                System.out.println("Adding " + key + " to queue");
                queue.add(key);
            } else {
                if (map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }
        }

//        System.out.println("\nHere is the queue: ");
//        while (!queue.isEmpty()) {
//            System.out.println(queue.remove());
//        }
//        System.out.println(queue.size());
//        int[] res = new int[queue.size()];
//        for (int i = 0; i < queue.size(); i++) {
//            System.out.println(i + "time!");
//            int num = queue.remove();
//            res[i] = num;
////            System.out.println(res[i]);
//        }

        // 注意，如果这里的 for 循环像上面注释掉的那样写的话
        // 由于在循环中会进行 queue.remove()，会导致 queue.size() 改变
        // 这就会导致在循环过程中判断 i < queue.size() 这个条件改变
        // 就会导致实际添加到数组中的元素个数少于本来想要的个数
        int size = queue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = queue.remove();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 2, 2, 3};
        int[] res = (new Solution()).topKFrequent(test, 2);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
