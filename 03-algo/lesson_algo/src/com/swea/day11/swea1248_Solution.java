package com.swea.day11;
import java.awt.image.DataBuffer;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
 
class Node {
    int parent = -1;
    int lchild = -1;
    int rchild = -1;
     
    void setChild(int num) {
        if(this.lchild == -1) {
            this.lchild = num;
        } else if(this.rchild == -1) {
            this.rchild = num;
        } else {
            System.out.println("setChild Error num:" + num);
        }
    }
     
    void setParent(int num) {
        this.parent = num;
    }
     
    int getParent() {
        return this.parent;
    }
}
 
public class swea1248_Solution {
    static int result;
     
    static void check(Node node[], int n) {
        result++;
         
        if(node[n].lchild != -1) {
            check(node, node[n].lchild);
        }
         
        if(node[n].rchild != -1) {
            check(node, node[n].rchild);
        }
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            //FileInputStream is = new FileInputStream("input1248.txt");
            //DataInputStream dis = new DataInputStream(is);
        	System.setIn(new FileInputStream("swea/input1248.txt"));
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader dis = new BufferedReader(is);
             
            String s = dis.readLine();
            int T = Integer.parseInt(s);
             
            for(int testCase = 1 ; testCase <= T ; testCase ++) {
                s = dis.readLine();
                String tmpArr[] = s.split(" ");
                 
                int V = Integer.parseInt(tmpArr[0]); // 정점의 총수
                int E = Integer.parseInt(tmpArr[1]); // 간선의 총수
                int A = Integer.parseInt(tmpArr[2]); // 공통 조상을 찾는 정점1
                int B = Integer.parseInt(tmpArr[3]); // 공통 조상을 찾는 정점2
                 
                s = dis.readLine();
                tmpArr = s.split(" ");
                 
                Node node[] = new Node[V+1];  
                 
                for(int i = 0 ; i < E ; i++) {
                    int p = Integer.parseInt(tmpArr[2*i]);
                    int c = Integer.parseInt(tmpArr[2*i+1]);
                     
                    if(node[p] == null)
                        node[p] = new Node();
                    node[p].setChild(c);
                     
                    if(node[c] == null)
                        node[c] = new Node();
                    node[c].setParent(p);
                }
                
                // 여기까지 노드끼리의 관계 저장
                
                
                boolean bArr[] = new boolean[V+1];
                 
                int index = node[A].getParent();
                bArr[index] = true;
                while(true) {
                    if(node[index].getParent() == -1) {
                        bArr[index] = true;
                        break;
                    }
                    bArr[index] = true;
                    index = node[index].getParent();
                }
                 
                 
                index = node[B].getParent();
                 
                int resultIndex = -1;
                while(true) {
                    if(bArr[index] == true) {
                        resultIndex = index;
                        break;
                    }
                    if(node[index].getParent() == -1) {
                        break;
                    }
                    index = node[index].getParent();
                }
                                 
                // result = 공통조상의 정점
                result = 0;
                if(resultIndex != -1)
                    check(node, resultIndex);
                 
                System.out.println("#" + testCase + " " + resultIndex + " " + result);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
 
}