package com.kshare.tree;

import java.util.Stack;

public class BTFromStringWithBracket {
	Stack<String> stack = new Stack<>();
	
	public static void main(String[] args) {
		BTFromStringWithBracket buildbT = new BTFromStringWithBracket();
		String content = "4(2(3)(1))(6(5))";
		Node node = buildbT.buildBT(content);
		buildbT.inOrderTraversal(node);
	}
	public Node buildBT(String content){
		System.out.println(" main content : "+content);
		String nodeValue = "";
		if(content.indexOf('(') != -1){
			 nodeValue = content.substring(0, content.indexOf('('));
		}else if(content.length() > 0){
			nodeValue = content;
			return new Node(Integer.parseInt(nodeValue));
		}
		System.out.println(" Node value : "+nodeValue);
		if(nodeValue == null | nodeValue.length() == 0){
			return null;
		}
		 Node node = new Node(Integer.parseInt(nodeValue));
		 String leftContent = getLeftContent(content.substring(content.indexOf('(')));
		 System.out.println(" Left content : "+leftContent);
		 String rightContent = "";
		 if(leftContent.length()+ 3 < content.length()){
			  rightContent = getRightContent(content.substring(leftContent.length()+3));
		 }
			System.out.println(" right content : "+rightContent);

		 if(leftContent != null | leftContent.length() != 0){
			 node.left = buildBT(leftContent);
		 }		
		 if(rightContent != null | rightContent.length() != 0){
			 node.right = buildBT(rightContent);
		 }
		return node; 
	}
	private String getRightContent(String content) {
		if(content == null)
			return null;
		return getContentFromBracket(content);
	}
	private String getLeftContent(String content) {
		if(content == null)
			return null;
		return getContentFromBracket(content);
	
	}
	private String getContentFromBracket(String content){

		int count = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0 ; i < content.length() ; i++){
			if(content.charAt(i)== '('){
				count++;
				if(count == 1){
					startIndex = i++;
				}
			}
			else if(content.charAt(i)== ')'){
				count--;
				if(count == 0){
					 endIndex = i;
					 break;
				}
			}
		}
		System.out.println(" content : "+content);
		System.out.println(" startIndex : "+startIndex);
		System.out.println(" endIndex : "+endIndex);
		
		return content.substring(startIndex+1, endIndex);
	
	}
	public void inOrderTraversal(Node current){
		if(current.left != null){
			inOrderTraversal(current.left);
		}
		System.out.println(" "+current.data);
		
		if(current.right != null){
			inOrderTraversal(current.right);
		}
	}
}
