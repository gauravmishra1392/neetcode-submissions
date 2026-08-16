class Trie{
    boolean isLastChar;
    Map<Character,Trie> node;
    Trie(){
        node = new HashMap<>();
        isLastChar = false;
    }
}

class PrefixTree {
    Trie tr;
    public PrefixTree() {
      tr = new Trie();
    }

    public void insert(String word) {
        Trie current = tr;
        for(int i=0;i<word.length();i++){
            if(current.node.get(word.charAt(i)) == null){
                current.node.put(word.charAt(i),new Trie());
            }
            current = current.node.get(word.charAt(i));

        }
         current.isLastChar = true;

    }

    public boolean search(String word) {
         Trie current = tr;
        for(int i=0;i<word.length();i++){
            if(current.node.get(word.charAt(i))!=null){
                current = current.node.get(word.charAt(i));
            }else{
                return false;
            }
        }
        return current.isLastChar; 
    }

    public boolean startsWith(String prefix) {
        int c = 0;
         Trie current = tr;
        for(int i=0;i<prefix.length();i++){
            if(current.node.get(prefix.charAt(i))!=null){
                current = current.node.get(prefix.charAt(i));
                c++;
            }else{
                return false;
            }
        }
        return c == prefix.length(); 
    }
}
