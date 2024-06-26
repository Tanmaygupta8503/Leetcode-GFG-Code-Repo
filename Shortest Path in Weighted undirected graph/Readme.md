<H1>
  Shortest Path in Weighted undirected graph
</H1>
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given a weighted undirected graph having <strong>n</strong> vertices numbered from 1 to n and <strong>m</strong> edges describing there are edges between a to b with some weight, find the shortest path between the vertex&nbsp;1&nbsp;and the vertex&nbsp;n and if path does not exist then return a list consisting of only -1.</span></p>
<p><span style="font-size: 18px;">Note -&nbsp;<br>1. If there exists a path, then return a list whose first element is the weight of the path.<br>2. If no path exists then return a list containing a single element -1.</span></p>
<pre><span style="font-size: 18px;"><strong>Example:</strong>
<strong>Input:</strong>

n = 5, m= 6
edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
<strong>Output:</strong>
5 1 4 3 5
<strong>Explaination:</strong>
Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. </span>

</pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>shortestPath()</strong>&nbsp;which takes n vertex and m edges and vector of edges having weight<strong>&nbsp;</strong>as inputs and returns the shortest path between vertex 1 to n.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(m* log(n))<br><strong>Expected Space Complexity:</strong> O(n)</span></p>
<p><span style="font-size: 18px;">Constraint:<br>2 &lt;= n&nbsp;&lt;= 10<sup>5</sup><br>0 &lt;= m &lt;= 10<sup>5</sup><br>0&lt;= a, b &lt;= n<br>1 &lt;= w &lt;= 10<sup>5</sup></span></p></div>
<img src="https://static.takeuforward.org/wp/uploads/2022/12/Screenshot-2022-12-19-005006.png" alt="" class="wp-image-7064">
