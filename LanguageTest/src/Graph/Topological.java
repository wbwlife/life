package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological {

    /**
     * 顶点数组
     */
    private List<VertexNode> vexList;

    /**
     * 创建图（邻接表）
     */
    public void createGraph(){
        //v0
        VertexNode v0 = new VertexNode(0, 0, null);

        EdgeNode v0e0 = new EdgeNode(11, 0, null);
        EdgeNode v0e1 = new EdgeNode(5, 0, null);
        EdgeNode v0e2 = new EdgeNode(4, 0, null);

        v0.setFirstEdge(v0e0);
        v0e0.setNext(v0e1);
        v0e1.setNext(v0e2);

        //v1
        VertexNode v1 = new VertexNode(0, 1, null);

        EdgeNode v1e0 = new EdgeNode(8, 0, null);
        EdgeNode v1e1 = new EdgeNode(4, 0, null);
        EdgeNode v1e2 = new EdgeNode(2, 0, null);

        v1.setFirstEdge(v1e0);
        v1e0.setNext(v1e1);
        v1e1.setNext(v1e2);

        //v2
        VertexNode v2 = new VertexNode(2, 2, null);

        EdgeNode v2e0 = new EdgeNode(9, 0, null);
        EdgeNode v2e1 = new EdgeNode(6, 0, null);
        EdgeNode v2e2 = new EdgeNode(5, 0, null);

        v2.setFirstEdge(v2e0);
        v2e0.setNext(v2e1);
        v2e1.setNext(v2e2);

        //v3
        VertexNode v3 = new VertexNode(0, 3, null);

        EdgeNode v3e0 = new EdgeNode(13, 0, null);
        EdgeNode v3e1 = new EdgeNode(2, 0, null);

        v3.setFirstEdge(v3e0);
        v3e0.setNext(v3e1);

        //v4
        VertexNode v4 = new VertexNode(2, 4, null);

        EdgeNode v4e0 = new EdgeNode(7, 0, null);

        v4.setFirstEdge(v4e0);

        //v5
        VertexNode v5 = new VertexNode(3, 5, null);

        EdgeNode v5e0 = new EdgeNode(12, 0, null);
        EdgeNode v5e1 = new EdgeNode(8, 0, null);

        v5.setFirstEdge(v5e0);
        v5e0.setNext(v5e1);

        //v6
        VertexNode v6 = new VertexNode(1, 6, null);

        EdgeNode v6e0 = new EdgeNode(5, 0, null);

        v6.setFirstEdge(v6e0);

        //v7
        VertexNode v7 = new VertexNode(2, 7, null);

        //v8
        VertexNode v8 = new VertexNode(2, 8, null);

        EdgeNode v8e0 = new EdgeNode(7, 0, null);

        v8.setFirstEdge(v8e0);

        //v9 入度应为2，不是图片中的1（图片中已经改过来了）
        VertexNode v9 = new VertexNode(2, 9, null);

        EdgeNode v9e0 = new EdgeNode(11, 0, null);
        EdgeNode v9e1 = new EdgeNode(10, 0, null);

        v9.setFirstEdge(v9e0);
        v9e0.setNext(v9e1);

        //v10
        VertexNode v10 = new VertexNode(1, 10, null);

        EdgeNode v10e0 = new EdgeNode(13, 0, null);

        v10.setFirstEdge(v10e0);

        //v11
        VertexNode v11 = new VertexNode(2, 11, null);

        //v12
        VertexNode v12 = new VertexNode(1, 12, null);

        EdgeNode v12e0 = new EdgeNode(9, 0, null);

        v12.setFirstEdge(v12e0);

        //v13
        VertexNode v13 = new VertexNode(2, 13, null);

        vexList = new ArrayList<>();
        vexList.add(v0);
        vexList.add(v1);
        vexList.add(v2);
        vexList.add(v3);
        vexList.add(v4);
        vexList.add(v5);
        vexList.add(v6);
        vexList.add(v7);
        vexList.add(v8);
        vexList.add(v9);
        vexList.add(v10);
        vexList.add(v11);
        vexList.add(v12);
        vexList.add(v13);


    }

    public boolean topologicalSort() {
        //统计输出顶点数
        int count = 0;

        //建栈存储入度为0的顶点
        Stack<Integer> stack = new Stack<>();

        //统计入度数（录入也可以，但是示例图的v9的度应为2，示例图中误写为1，导致查了半天bug，自动统计入度数看来也是有必要的）
        for (int i = 0;i < vexList.size(); i++) {
            vexList.get(i).setIn(0);
        }
        for (int i = 0;i < vexList.size(); i++) {

            EdgeNode edge = vexList.get(i).getFirstEdge();
            while (edge != null) {
                VertexNode vex = vexList.get(edge.getAdjvex());
                vex.setIn(vex.getIn() + 1);

                edge = edge.getNext();
            }
        }

        //将入度为0 的顶点入栈
        for (int i = 0;i < vexList.size(); i++) {
            if (vexList.get(i).getIn() == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            //栈顶 顶点出栈
            int vexIndex = stack.pop();
            System.out.print(vexIndex + "  ");

            count++;

            //从顶点表结点中取出第一个边表结点
            EdgeNode edge = vexList.get(vexIndex).getFirstEdge();

            while (edge != null) {
                int adjvex = edge.getAdjvex();

                VertexNode vex = vexList.get(adjvex);

                //将此 顶点的入度减一
                vex.setIn(vex.getIn() - 1);
                //此顶点的入度为零则入栈，以便于下次循环输出
                if (vex.getIn() == 0) {
                    stack.push(adjvex);
                }

                edge = edge.getNext();

            }
        }

        if (count != vexList.size())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Topological topological = new Topological();
        topological.createGraph();
        boolean success = topological.topologicalSort();

        if (success) {
            System.out.println("成功");
        }else {
            System.out.println("失败，有回路");
        }
    }

}

/**
 * 边表结点
 *
 */
class EdgeNode {
    /**
     * 邻接点域，存储该顶点对应的下标
     */
    private int adjvex;

    /**
     * 用于存储权值，对于非网图可以不需要
     */
    private int weight;

    /**
     * 链域，指向下一个邻接点
     */
    private EdgeNode next;



    public EdgeNode(int adjvex, int weight, EdgeNode next) {
        super();
        this.adjvex = adjvex;
        this.weight = weight;
        this.next = next;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }


}

/**
 * 顶点表结点
 *
 */
class VertexNode {
    /**
     * 顶点入度
     */
    private int in;

    /**
     * 顶点域，存储顶点信息（下标）
     */
    private int data;

    /**
     * 边表头指针
     */
    private EdgeNode firstEdge;



    public VertexNode(int in, int data, EdgeNode firstEdge) {
        super();
        this.in = in;
        this.data = data;
        this.firstEdge = firstEdge;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }


}