package com.fish.lab.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BTree {
    class BNode {
        int val;
        BNode left;
        BNode right;
    }
    private StringBuilder res = new StringBuilder();

    public String BTree2String(BNode head) {
        if ((head == null)) {
            return null;
        }
        dfs(head, res);
        return res.deleteCharAt(res.lastIndexOf(",")).toString();
    }
    private void dfs(BNode head, StringBuilder str) {
        if (head == null) {
            str.append("NONE");
            return;
        }
        str.append(head.val + ",");
        dfs(head.left, str);
        dfs(head.right, str);
    }



    //序列化
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    //反序列化
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



}
