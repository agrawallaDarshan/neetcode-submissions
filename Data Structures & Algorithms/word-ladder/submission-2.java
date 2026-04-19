class Solution {
    public boolean isWordDifferByOne(String word1, String word2) {
        int countDiffs = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                countDiffs++;
        }
        return countDiffs == 1;
    }

    public int[] getWordCount(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++)
            count[word.charAt(i) - 'a']++;
        return count;
    }

    public int solution(String beginWord, String endWord, List<String> wordList, boolean[] visited) {
        if (beginWord.equals(endWord))
            return 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && isWordDifferByOne(beginWord, wordList.get(i))) {
                visited[i] = true;
                int wordCounts = solution(wordList.get(i), endWord, wordList, visited);
                if (wordCounts != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + wordCounts);
                visited[i] = false;
            }
        }
        return ans;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        boolean[] visited = new boolean[wordList.size()];
        int res = solution(beginWord, endWord, wordList, visited);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}