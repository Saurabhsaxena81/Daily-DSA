class DSU {

    int[] parent;

    DSU(int[] parent) {
        this.parent = parent.clone();
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void join(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
    }
}

public class Solution {

    private static final int MAX_STABILITY = 200000;

    public int maxStability(int n, int[][] edges, int k) {
        int ans = -1;
        if (edges.length < n - 1) {
            return -1;
        }
        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge);
            } else {
                optionalEdges.add(edge);
            }
        }

        if (mustEdges.size() > n - 1) {
            return -1;
        }

        optionalEdges.sort((a, b) -> b[2] - a[2]);
        int selectedInit = 0;
        int mustMinStability = MAX_STABILITY;

        int[] initParent = new int[n];
        for (int i = 0; i < n; i++) {
            initParent[i] = i;
        }
        DSU dsuInit = new DSU(initParent);

        for (int[] e : mustEdges) {
            int u = e[0];
            int v = e[1];
            int s = e[2];
            if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
                return -1;
            }
            dsuInit.join(u, v);
            selectedInit++;
            mustMinStability = Math.min(mustMinStability, s);
        }

        int l = 0;
        int r = mustMinStability;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            DSU dsu = new DSU(dsuInit.parent);
            int selected = selectedInit;
            int doubledCount = 0;

            for (int[] e : optionalEdges) {
                int u = e[0];
                int v = e[1];
                int s = e[2];
                if (dsu.find(u) == dsu.find(v)) {
                    continue;
                }
                if (s >= mid) {
                    dsu.join(u, v);
                    selected++;
                } else if (doubledCount < k && s * 2 >= mid) {
                    doubledCount++;
                    dsu.join(u, v);
                    selected++;
                } else {
                    break;
                }
                if (selected == n - 1) {
                    break;
                }
            }

            if (selected != n - 1) {
                r = mid - 1;
            } else {
                ans = l = mid;
            }
        }

        return ans;
    }
}


/*
Complexity Analysis
Let m be the length of edges, and v be the upper bound of the binary search.

Time complexity: O(mlogm+(n+m⋅α(n))⋅logv).

The find operation in the Union-Find structure takes O(α(n)) time, where α(⋅) is the inverse Ackermann function. Sorting the edges during preprocessing takes O(mlogm) time. Preprocessing the edges with must=1 requires O(m⋅α(n)) time.

The binary search runs for O(logv) iterations. In each iteration, cloning the initial Union-Find state takes O(n) time, and maintaining the Union-Find structure requires O(m⋅α(n)). Since α(n) grows extremely slowly and is effectively constant in practice, the overall time complexity is O(mlogm+(n+m⋅α(n))⋅logv).

Space complexity: O(n+m).

The Union-Find structure requires O(n) space, and storing the separated edge lists requires O(m) space.

*/