package cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test207 {
    //207. 课程表

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
     * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；
     * 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     * 提示：
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */

    public static void main(String[] args) {
        Test207 test207 = new Test207();
        //int[][] prerequisites = {{1, 0}, {0, 1}};
//        for(int[] prerequisite : prerequisites){
//            System.out.println(prerequisite[0]);
//            System.out.println(prerequisite[1]);
//        }
        System.out.println(test207.new Solution().canFinish(2, new int[][]{{1, 0}}));

    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 入度数组，用于记录每门课程的入度
            int[] inDegree = new int[numCourses];
            // 邻接表，存储每门课程的后续课程
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            // 计算每门课程的入度，并构建邻接表
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                inDegree[course]++;
                //存储每门课程的后续课程
                adjList.get(preCourse).add(course);
            }

            // 存储入度为 0 的课程的队列
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 记录已完成课程的数量
            int count = 0;
            while (!queue.isEmpty()) {
                int selectedCourse = queue.poll();
                count++;
                // 获取当前课程的后续课程列表
                List<Integer> nextCourses = adjList.get(selectedCourse);
                for (int nextCourse : nextCourses) {
                    // 后续课程的入度减 1
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

            // 如果已完成课程的数量等于总课程数，则可以完成所有课程
            return count == numCourses;
        }
    }

    class Solution2 {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                //info[1]: 课程info[0]的前置课程
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v : edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }

    class Solution3 {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }

}

