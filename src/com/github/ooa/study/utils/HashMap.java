package com.github.ooa.chudq.utils;

public class HashMap {
	
	public Object[] table;

	private int hashcode;
	
	public HashMap() {
		init();
	}
	
	public void init(){
		table = new Object[10];
	}
	
	public void put(Object key, Object value){
		Entry entry = new Entry();
		entry.key = key;
		entry.value = value;
		Integer hashCode = key.hashCode();
		int index = hashCode%hashCode;
		this.hashcode = index;
		if(table[index]==null){
			table[index] = new Node(hashcode, entry, null);
		}else{
			table[index] = new Node(hashcode, entry, (Node)table[index]);
		}
	}
	
	public Object get(Object key){
		Integer hashCode = key.hashCode();
		int index = hashCode%hashCode;
		if(((Node)table[index]).entry.key.equals(key)){
			return ((Node)table[index]).entry.value; 
		}else{
			Node nextNode = ((Node)table[index]).next; 
			while(nextNode != null){
				if(nextNode.entry.key.equals(key)){
					return nextNode.entry.value;
				}else{
					nextNode = nextNode.next;
				}
			}
		}
		return null;
	}
	
	class Node {
		int hashcode;
		Entry entry;
		Node next;
		
		public Node(int hashcode, Entry entry, Node next){
			this.hashcode = hashcode;
			this.entry = entry;
			this.next = next;
		}
	}
	
	class Entry{
		Object key;
		Object value;
	}
}
