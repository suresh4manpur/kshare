package com.kshare.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrieDS {
	public static void main(String[] args) {
		Trie tr = new Trie();
		tr.insert("go");
		tr.insert("gone");
		tr.insert("goners");
		tr.insert("tea");
		tr.insert("suresh");
		tr.insert("race");
		tr.insert("racer");
		tr.insert("raid");
		tr.insert("range");
		tr.insert("no");
		tr.insert("ra");
		tr.insert("raa");
		System.out.println("Go found => "+tr.search("go"));
		System.out.println("gone found => "+tr.search("gone"));
		System.out.println("no found => "+tr.search("no"));
		System.out.println("tea found => "+tr.search("tea"));
		System.out.println("suresh found => "+tr.search("suresh"));
		List<String> list = tr.searchWithPrefix("ra");
		for(String word : list){
			System.out.println("Words with prefix 'ra' are " +word);
		}
	}
}
class Trie{
	TrieNode root;
	
	public Trie() {
		this.root = new TrieNode(new HashMap<Character,TrieNode>());
	}
	public void insert(String word){
		TrieNode current = root;
		char c = '\u0000';
		TrieNode newNode = null;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);

			if(!current.children.containsKey(c)){
				if(i == (word.length()-1)){  // is End of the word
					newNode = new TrieNode(new HashMap<Character,TrieNode>(), true);
				}else{
					newNode = new TrieNode(new HashMap<Character,TrieNode>());
				}
				current.children.put(c, newNode);
			}
				current = current.children.get(c);
				
		}
		if(!current.isEndOfWord){
			current.isEndOfWord = true;
		}
	}
	public boolean search(String word){
		TrieNode current = root;
		boolean wordFound = true;
		char c ;
		for (int i = 0; i < word.length(); i++) {
			 c = word.charAt(i);
			 if(current.children.containsKey(c)){
				 current = current.children.get(c);
			 }else{
				 wordFound = false;
				 return wordFound;
			 }
		}
		if(current != null && current.isEndOfWord){
			wordFound = true;
		}
		return wordFound;
	}
	public List<String> searchWithPrefix(String prefix){
		List<String> list = new ArrayList<String>();
		
		TrieNode current = root;
		boolean prefixFound = true;
		char c ;
		for (int i = 0; i < prefix.length(); i++) {
			 c = prefix.charAt(i);
			 if(current.children.containsKey(c)){
				 current = current.children.get(c);
			 }else{
				 prefixFound = false;
				 return list;
			 }
		}
		if(current != null && current.isEndOfWord){
			list.add(prefix);
			prefixFound = true;
		}
		if(prefixFound){
			
			 getWords(current, prefix, list);
		}
		
		return list;
	}
	private void getWords(TrieNode node, String word, List<String> list) {
		 
		if(node!= null && node.children.size() == 0){
			return;
		}else{
			Set<Character> keys = node.children.keySet();
			//boolean isFirstAdded = false; 
			for(Character c : keys){
				if(node.children.get(c).isEndOfWord /*&& !isFirstAdded*/){
					list.add(word+c);
					//isFirstAdded = true;
				}
				getWords(node.children.get(c), word+c,list);
			}
		}
	}
	public void remove(String word){
		
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;

	public TrieNode(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public TrieNode(Map<Character, TrieNode> children, boolean isEndOfWord) {
		this.children = children;
		this.isEndOfWord = isEndOfWord;
	}
	
}