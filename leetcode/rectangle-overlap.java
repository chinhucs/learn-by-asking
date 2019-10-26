/**
 * 题目链接：https://leetcode.com/problems/rectangle-overlap/
 *
 * Rectangle Overlap 矩形覆盖
 * 判断两个矩形是否重叠，矩形的表示方法是用两个点，左下和右上点来定位的。
 * 在看 2D 之前，可以先看 1D 的情况，也就是对于两条线段，它们什么情况下相交
 * 
 *              x3              x4
 *              |---------------|
 *   |------------------|
 *   x1                 x2
 *
 * 相交的情况比较多，包括相交和包含。所以可以先来看一下不相交的情况，不相交只有两种情况。
 *
 *                    x3             x4            x3              x4
 *                    |--------------|             |---------------|
 *  |--------------|                        或者                         |---------------|
 *  x1             x2                                                    x1             x2
 *
 * 如果只有顶点相交时不算相交的话，可以得到：x2 <= x3 || x4 <= x1
 * 那么接下来考虑相交的情况，也就是不相交的补集，也就是 x3 < x2 && x1 < x4
 * 
 * 两条线段交换一下位置也能得出上述结论。
 *
 * 再来看 2D 的重叠，也就是两个方向上同时满足 1D 的重叠条件。
 * 两个矩形重叠总共有 4 中情况，先来看两个矩形在矩形 1 的右上角重叠
 *
 *                       
 *                --------------------- x4,y4
 *                |                   |
 *                |                   |
 *    ------------|----- x2,y2        |
 *    |           -----|---------------
 *    |        x3,y3   |
 *    |                |
 *    ------------------
 *   x1,y1
 *
 * 满足的条件为：x1 < x4 && x3 < x2 && y1 < y4 && y3 < y2
 *
 * 实际应用：在项目开发中，遇到过需要判断两个时间区间是否重合的场景，可以将两个时间段分别看成一个线段
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] <rec2[2] && rec2[0] < rec1[2]) &&
            (rec1[1] <rec2[3] && rec2[1] < rec1[3]);
    }
}