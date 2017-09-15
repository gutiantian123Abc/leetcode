/* Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
//https://leetcode.com/problems/rectangle-area/description/
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int h1 = D - B, w1 = C - A;
        int h2 = H - F, w2 = G - E;
        int A1 = h1 * w1, A2 = h2 * w2;
        int overlapped = 0;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        if(left < right && bottom < top) {
            overlapped = (right - left) * (top - bottom);
        }
        
        return A1 + A2 - overlapped;
    }
}