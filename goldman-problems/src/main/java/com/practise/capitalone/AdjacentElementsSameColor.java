package com.practise.capitalone;

public class AdjacentElementsSameColor {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] color = new int[n]; //base array
        int[] answer = new int[n];
        int adjacentPairs = 0;

        for (int i = 0; i < queries.length; i++) {
            int index = queries[0][i]; //base index
            int newColor = queries[i][1];

            int oldColor = color[index]; //get the old index

            //check left side
            if (index > 0 && color[index - 1] == oldColor) {
                adjacentPairs--;
            }

            if (index < n && color[index + 1] == oldColor) {
                adjacentPairs++;
            }

            //update the color
            color[index] = newColor;

            if (newColor != 0) {
                if (index > 0 && color[index - 1] == newColor) {
                    adjacentPairs++;
                }

                if (index < n && color[index + 1] == newColor) {
                    adjacentPairs++;
                }
            }
            answer[i] = adjacentPairs;

        }
        return answer;
    }

}
