package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/30.
 */
public class Question58 {



    static BinaryTreeNode nextNode(BinaryTreeNode node){
        if (node == null)return null;
        BinaryTreeNode next = null;

        if (node.right != null){
            BinaryTreeNode pRight = node.right;
            while (pRight.left != null){
                pRight = pRight.left;
            }
            next = pRight;
        }else if(node.parent != null){

            BinaryTreeNode pCur = node;
            BinaryTreeNode pPar = node.parent;
            while ( pPar!=null && pPar.right == pCur){
                pCur = pPar;
                pPar = pPar.parent;
            }
           next = pPar;
        }
       return  next;
    }
}
