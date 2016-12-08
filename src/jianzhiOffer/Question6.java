package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/8.
 */
public class Question6 {


    public static void main(String[] args) {

        BinaryTreeNode _1 = new BinaryTreeNode(1);
        BinaryTreeNode _2 = new BinaryTreeNode(2);
        BinaryTreeNode _3 = new BinaryTreeNode(3);
        BinaryTreeNode _4 = new BinaryTreeNode(4);
        BinaryTreeNode _5 = new BinaryTreeNode(5);
        BinaryTreeNode _6 = new BinaryTreeNode(6);
        BinaryTreeNode _7 = new BinaryTreeNode(7);
        BinaryTreeNode _8 = new BinaryTreeNode(8);

        BinaryTreeNode[] preorderNodeArr ={_1,_2,_4,_7,_3,_5,_6,_8};
        BinaryTreeNode[] inorderNodeArr ={_4,_7,_2,_1,_5,_3,_8,_6};
        BinaryTreeNode root = construct(preorderNodeArr,inorderNodeArr,preorderNodeArr.length);
        //System.out.println(root.leftTree.leftTree.leftTree);
        //System.out.println(root.leftTree.leftTree.leftTree);
        printNodeInPreorder(root);

    }

    static  void printNodeInPreorder(BinaryTreeNode rootNode){
        System.out.print(rootNode.value+'\t');
        if(rootNode.leftTree != null) printNodeInPreorder(rootNode.leftTree);
        if(rootNode.rightTree != null) printNodeInPreorder(rootNode.rightTree);
    }




    public static  BinaryTreeNode construct(BinaryTreeNode[] preorderNodeArr,BinaryTreeNode[] inorderNodeArr,int binaryTreeLength){
       if (preorderNodeArr == null || inorderNodeArr == null || binaryTreeLength != preorderNodeArr.length || binaryTreeLength != inorderNodeArr.length)
           return null;

      return constructCore(0,binaryTreeLength-1,0,binaryTreeLength-1,preorderNodeArr,inorderNodeArr);
    }


    static BinaryTreeNode constructCore(int startPreorderIndex,int endPreorderIndex,
                              int startInorderIndex,int endInorderIndex,
                              BinaryTreeNode[] preorderTreeNodeArr,BinaryTreeNode[] inorderTreeNodeArr){

        if (startPreorderIndex ==  endPreorderIndex){
            if(startInorderIndex == endInorderIndex && inorderTreeNodeArr[startInorderIndex].value == inorderTreeNodeArr[endInorderIndex].value){
                return  preorderTreeNodeArr[startPreorderIndex];
            }
            else
            throw new RuntimeException("Error input");
        }


        BinaryTreeNode rootNode = new BinaryTreeNode();
        rootNode.value = preorderTreeNodeArr[startPreorderIndex].value;
        rootNode.leftTree = null;
        rootNode.rightTree = null;

        int inorderRootIndex = startInorderIndex;
        for(;inorderRootIndex < endInorderIndex;inorderRootIndex++){
            if (inorderTreeNodeArr[inorderRootIndex].value == rootNode.value ){
                break;
            }
        }

        int leftLength = inorderRootIndex-startInorderIndex;
        int leftPreorderEndIndex = startPreorderIndex+leftLength;

        if ( inorderRootIndex > 0)
        rootNode.leftTree = constructCore(startPreorderIndex+1,leftPreorderEndIndex,
                startInorderIndex,inorderRootIndex-1,preorderTreeNodeArr,inorderTreeNodeArr);

        if (leftLength < endInorderIndex-startInorderIndex){
            rootNode.rightTree = constructCore(leftPreorderEndIndex+1,endPreorderIndex,
                    inorderRootIndex+1,endInorderIndex,preorderTreeNodeArr,inorderTreeNodeArr);
        }
        return  rootNode;
    }




    static class   BinaryTreeNode{
        int value;
        BinaryTreeNode leftTree;
        BinaryTreeNode rightTree;
        public BinaryTreeNode(int value){
            this.value = value;
        }

        public BinaryTreeNode(){}

        @Override
        public String toString() {
            return "[value:"+value+",leftNodeValue:"+leftTree.value+",rightNodeValue:"+rightTree.value;
        }
    }


}
