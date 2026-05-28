class Node
{
    Node links[] = new Node[26];
    boolean flag = false;

    public Node()
    {

    }

    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch)
    {
        return links[ch - 'a'];
    }

    void put(char ch, Node node)
    {
        links[ch - 'a'] = node;
    }

    void setEnd()
    {
        flag = true;
    }

    boolean isEnd()
    {
        return flag;
    }
};


class Trie {

    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word)
    {
        Node node = root;
        for(int i = 0; i < word.length(); i += 1)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean search(String word) 
    {
        Node node = root;
        for(int i = 0; i < word.length(); i += 1)
        {
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }

        if(node.isEnd()) return true;

        return false;
    }

    boolean startsWith(String prefix) 
    {
        Node node = root;
        for(int i = 0; i < prefix.length(); i += 1)
        {
            if(!node.containsKey(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }

        return true;
    }
}

public class Solution
{
    public static void main(String []args)
    {
        Trie trie = new Trie();
        Boolean ans;
        trie.insert("apple");

        ans = trie.search("apple");  // return True
        System.out.println(ans);
        ans = trie.search("app");   // return False
        System.out.println(ans);
        ans = trie.startsWith("app"); // return True
        System.out.println(ans);
        trie.insert("app");

        ans = trie.search("app");   // return True
        System.out.println(ans);
    }
}


