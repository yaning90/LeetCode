public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return 0;
        }
        HashSet<String> hs = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
        hs.add(beginWord);
        queue.add(beginWord);
        
        int length = 1;
        
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String word = queue.remove();
                ArrayList<String> nextWords = getNextWords(word, wordDict);
                for(int i = 0; i < nextWords.size(); i++){
                    String nextWord = nextWords.get(i);
                    if(hs.contains(nextWord)){
                        continue;
                    }
                    if(nextWord.equals(endWord)){ // 判断字符串是否相等不能用 ＝＝s1.equals(s2)
                        return length;
                    }
                    hs.add(nextWord);
                    queue.add(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    public ArrayList<String> getNextWords(String word, Set<String> wordDict){
        ArrayList<String> nextWords = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++){
            for(int i = 0; i < word.length(); i++){
                if(c == word.charAt(i)){
                    continue;
                }
                String nextWord = replace(word, c, i);
                if(wordDict.contains(nextWord)){
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    public String replace(String word, char c, int i){
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}
