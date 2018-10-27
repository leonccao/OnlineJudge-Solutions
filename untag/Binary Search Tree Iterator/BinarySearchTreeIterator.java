import java.io.*;
import java.util.*;
import java.util.Iterator;

class Solution {

  static class Node {
      
    int key;
    Node left;
    Node right;
    Node parent;
    
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }
  
  static class BinarySearchTree  {
    
    Node root;

    // Iterator part

    class BSTIterator implements Iterator<Node> {

        Node last = null;

        BSTIterator(Node root) {
            if (root == null) return;
            last = root;
            while (last.left != null)
                last = last.left;
        }

        public boolean hasNext() {
            return last != null;
        }

        public Node next() {
            Node cur = last;
            last = findSuccessor(last);
            return cur;
        }

        private Node findSuccessor(Node root) {
            if (root == null) return null;
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                return tmp;
            }
            Node father = root.parent;
            Node child = root;
            while (father != null && father.left != child) {
                child = father;
                father = father.parent;
            }
            return father;
        }
    }
    
    Iterator<Node> iterator() {
        BSTIterator iter = new BSTIterator(root);
        return iter;
    }

    //  Given a binary search tree and a number, inserts a new node
    //  with the given number in the correct place in the tree
    void insert(int key) {
      
      // 1. If the tree is empty, create the root
      if(this.root == null) {
        this.root = new Node(key);
        return;
      }

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
      Node currentNode = this.root;
      Node newNode = new Node(key); 

      while(currentNode != null) {
        if(key < currentNode.key) {
          if(currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if(currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
    
    // Return a reference to a node in the BST by its key.
    // Use this method when you need a node to test your 
    // findInOrderSuccessor method on
    Node getNodeByKey(int key) {
      Node currentNode = this.root;
      
      while(currentNode != null) {
        if(key == currentNode.key) {
          return currentNode;
        }
        
        if(key < currentNode.key) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      
      return null; 
    }
  }
  
  /***********************************************
   * Driver program to test findInOrderSuccessor *
   ***********************************************/

  public static void main(String[] args) {
     
    Node test = null, succ = null;
     
    // Create a Binary Search Tree
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(20);
    tree.insert(9);
    tree.insert(25);
    tree.insert(5);
    tree.insert(12);
    tree.insert(11);
    tree.insert(14);

    Iterator<Node> iter = tree.iterator();
    while (iter.hasNext())
        System.out.println(iter.next().key);
    
  }
}