class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l= beginWord.length();
        Map<String,List<String>> map = new HashMap<>();

        // for(int i=0;i<wordList.size()*l;i++){
        //     list.add(new ArrayList<String>());
        // }

        for(int i=0;i<wordList.size();i++){
            for(int j=0;j<l;j++){
                String newWord = wordList.get(i).substring(0,j)
                +"*"+ wordList.get(i).substring(j+1);
                map.computeIfAbsent(newWord,value-> new ArrayList()).add(wordList.get(i));
            }
        }
    Queue<Pair<String, Integer>> queue = new LinkedList<>();
    Set visited = new HashSet<>();
     queue.add(new Pair(beginWord,1));
     visited.add(beginWord);
     while(queue.size()>0){
        Pair<String,Integer> p = queue.poll();
        for(int j=0;j<l;j++){
            String s = p.getKey();
            int value = p.getValue();
            String newWord = s.substring(0,j)+"*"+ s.substring(j+1);
            //List<String> adjacent = map.get(newWord);
            if(!map.containsKey(newWord)){
                continue;
            }
            for(String adj:map.get(newWord)){
                if(visited.contains(adj)) continue;
                if(!visited.contains(adj))
                if(adj.equals(endWord)){ return value+1;}
                 queue.add(new Pair(adj,value+1));
                 visited.add(adj);
            }
        }
     }


        // int L = beginWord.length();
        // Map<String, List<String>> allComboDict = new HashMap<>();

        // wordList.forEach(word-> {
        //     for(int i = 0; i < L; i++) {
        //         String newWord = word.substring(0, i) + '*' + word.substring(i+1);
        //         allComboDict.computeIfAbsent(newWord, value-> new ArrayList<>()).add(word);
        //     }
        // });
        // System.out.println(allComboDict);

        // Queue<Pair<String, Integer>> q = new LinkedList<>();
        // q.add(new Pair(beginWord, 1));
        // Set<String> visited = new HashSet<>();
        // visited.add(beginWord);

        // while(!q.isEmpty()) {
        //     Pair<String, Integer> node = q.poll();
        //     String word = node.getKey();
        //     int level = node.getValue();
        //     for(int i = 0; i < L; i++) {
        //         String newWord = word.substring(0, i) + '*' + word.substring(i+1);
        //         if(!allComboDict.containsKey(newWord)) continue;
        //         for(String adjWord: allComboDict.get(newWord)) {
        //             if(visited.contains(adjWord)) continue;
        //             if(adjWord.equals(endWord)) return level + 1;
        //             q.add(new Pair(adjWord, level + 1));
        //             visited.add(adjWord);
        //         }
        //     }
        // }

        return 0;
    }
}