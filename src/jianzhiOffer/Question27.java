package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/17.
 */
public class Question27 {




    static  void  convert(BinaryTreeNode pNode ,BinaryTreeNode pLastNodeInList){

        BinaryTreeNode pCurrent = pNode;

        if (pCurrent.left != null){
           convert(pNode.left,pLastNodeInList);
        }

        pCurrent.left = pLastNodeInList;
        if (pLastNodeInList != null){
            pLastNodeInList.right = pCurrent;
        }
        pLastNodeInList  = pCurrent;

        if (pCurrent.right != null){
            convert(pCurrent.right,pLastNodeInList);
        }

    }



}
