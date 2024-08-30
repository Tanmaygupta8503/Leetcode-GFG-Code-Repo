<ninjas-problems-ui-problem-details-tab-description _ngcontent-serverapp-c224="" _nghost-serverapp-c223=""><div _ngcontent-serverapp-c223="" class="problem-description-container pt-16 pb-56"><div _ngcontent-serverapp-c223="" class="problem-statement-title-container"><h2 _ngcontent-serverapp-c223="" class="problem-statement-title zen-typo-subtitle-small"> Problem statement </h2><ninjas-problems-ui-send-feedback-button _ngcontent-serverapp-c223="" _nghost-serverapp-c222=""><div _ngcontent-serverapp-c222=""><button _ngcontent-serverapp-c222="" zen-gray-underlined-text-cta="" size="small" class="zen-base-cta zen-gray-underlined-text-cta zen-cta-base zen-cta-small"><span class="zen-cta-wrapper"><span _ngcontent-serverapp-c222=""> Send feedback </span></span></button></div></ninjas-problems-ui-send-feedback-button></div><div _ngcontent-serverapp-c223="" class="problem-main-statement ng-star-inserted" style=""><div _ngcontent-serverapp-c223="" imageoverlay="" class="description pt-8 problem-statement ng-star-inserted"><p id="you-are-given-a-matrix-having-n-rows-and-m-columns-each-cell-of-the-matrix-can-only-contain-three-values-as-given-below">You are given a matrix having ‘N’ rows and ‘M’ columns. Each cell of the matrix can only contain three values as given below:</p>

<pre><code>-1 -&gt; It denotes a wall or an obstacle

0  -&gt; It denotes a gate

2^31 - 1 =  2147483647 ( INF ) -&gt; An infinitely large value  denotes the empty room.

For each empty room (denoted by INF), you have to refill it with the distance to its nearest gate. If none of the gates is reachable from an empty room then the value ‘INF’ will remain as it is.
</code></pre>

<b id="example">Example</b>

<pre><code>For the matrix [[0,-1],[0,2147483647]] the updated matrix will be [[0,-1],[0,1]].
</code></pre>

<b id="note">Note</b>

<pre><code>The distance between two cells having their coordinates (x1,y1) and (x2,y2) are abs(x2-x1) + abs(y2-y1).
</code></pre>

</div><!----></div><div _ngcontent-serverapp-c223="" class="problem-other-details-container py-8 mt-16 closed ng-star-inserted" style=""><div _ngcontent-serverapp-c223="" class="problem-other-details-heading-section"><div _ngcontent-serverapp-c223="" class="problem-other-details-heading-left-section"><span _ngcontent-serverapp-c223="" class="problem-other-details-text zen-typo-subtitle-small"> Detailed explanation </span><span _ngcontent-serverapp-c223="" class="problem-other-details-subtext zen-typo-caption-medium"> ( Input/output format, Notes, Images ) </span></div><div _ngcontent-serverapp-c223="" class="problem-other-details-heading-right-section"><mat-icon _ngcontent-serverapp-c223="" role="img" fontset="zen-icon" fonticon="icon-chevron-down" class="mat-icon notranslate icon-chevron-down zen-icon mat-icon-no-color" aria-hidden="true" data-mat-icon-type="font" data-mat-icon-name="icon-chevron-down" data-mat-icon-namespace="zen-icon"></mat-icon></div></div><div _ngcontent-serverapp-c223="" disableselect="" imageoverlay="" class="problem-other-details prevent-select" style="display: none;"><b id="input-format">Input Format:</b>

<pre><code>The first line of the input contains an integer ‘T’ denoting the number of test cases.

The next 2*T lines describe the ‘T’ test cases.

The first line of each test case contains two space-separated positive integers ‘N’ and ‘M’ denoting the number of the rows and columns in a matrix respectively. 

The next ‘N’ lines of each test case contain ‘M’ space-separated integers among -1, 0, and 2^31 - 1.
</code></pre>

<b id="output-format">Output Format:</b>

<pre><code>The output of each test case should contain a matrix of size N x M where each empty cell will contain the distance to its nearest gate.
</code></pre>

<b id="note">Note:</b>

<pre><code>You do not need to print anything, it has already been taken care of. Just implement the given function.
</code></pre></div></div><!----><div _ngcontent-serverapp-c223="" imageoverlay="" class="description pt-8 ng-star-inserted" style=""><b id="constraints">Constraints:</b>

<pre><code>1 &lt;= T &lt;= 50
1 &lt;= N &lt;= 10^4  
1 &lt;= M &lt;= 10^4
1 &lt;= N*M &lt;= 10^4 

Time Limit: 1 sec
</code></pre></div><!----><div _ngcontent-serverapp-c223="" imageoverlay="" class="description mt-16 sample-cases border-radius-8 ng-star-inserted" style=""><b>Sample Input 1:</b>

<pre><code>2
2 2
2147483647 -1
-1 0
4 4
2147483647 -1 0 2147483647
2147483647 2147483647 2147483647 -1
2147483647 -1 2147483647 -1
0 -1 2147483647 2147483647
</code></pre>

<b>Sample Output 1:</b>

<pre><code>2147483647 -1
-1 0
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4
</code></pre>

<b>Explanation For Sample Input 1:</b>

<pre><code>Test case 1:

There is no path from the empty cell at [0.0] to the only gate at [1,1] .

Test case 2:
</code></pre>

<p><img src="https://files.codingninjas.in/screenshot-from-2021-01-14-22-57-07-7324.png" alt="alt text" style="cursor: zoom-in;"></p>

<b>Sample Input 2:</b>

<pre><code>2
2 3
-1 0 2147483647
-1 0 2147483647
3 3
0 -1 2147483647
0 -1 2147483647
0 -1 2147483647
</code></pre>

<b>Sample Output 2:</b>

<pre><code>-1 0 1
-1 0 1
0 -1 2147483647
0 -1 2147483647
0 -1 2147483647
</code></pre>
</div><!----><!----><!----><!----><!----></div></ninjas-problems-ui-problem-details-tab-description>
