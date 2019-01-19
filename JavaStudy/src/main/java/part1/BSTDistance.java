package part1;

public class BSTDistance {

    //真的太感谢楼主了。。我跟你的题目也是一模一样的，我第二题的case pass了11个，给后人的建议是，第一个判断invalid的node1 and node2, 第二个判断一下node1或者node2是不是等于root，尝试一下testcase{1}，1，1，1这样。。
    //我刚开始没有考虑到node1或者node2可能是root，所以只pass了8 out 11，后来加了这个就过了。。。
    public class BTreeNode {
        public int val;
        public BTreeNode left;
        public BTreeNode right;

        public BTreeNode(int val) {
            this.val = val;
        }
    }

    private BTreeNode root;

    public void createBST(int[] values, int n) {
        for (int i = 0; i < n; i++) {
            addNode(values[i]);
        }
    }

    public void addNode(int item) {
        if (root == null) {
            root = new BTreeNode(item);
        } else {
            addNode(root, item);
        }
    }

    public void addNode(BTreeNode root, int item) {
        if (item < root.val) {
            if (root.left == null) {
                root.left = new BTreeNode(item);
            } else {
                addNode(root.left, item);
            }
        } else if (item > root.val) {
            if (root.right == null) {
                root.right = new BTreeNode(item);
            } else {
                addNode(root.right, item);

            }
        }
    }


    public int bstDistance(int node1, int node2) {
        BTreeNode lcaRoot = findLCA(root, node1, node2);
        int l1 = lcaRootToNodeLength(lcaRoot, node1);
        int l2 = lcaRootToNodeLength(lcaRoot, node2);
        return l1 + l2;

    }

    public int lcaRootToNodeLength(BTreeNode root, int node) {
        int res = 0;
        BTreeNode pointer = root;
        while (pointer.val != node) {
            if (pointer.val > node) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
            res++;
        }
        return res;
    }

    public BTreeNode findLCA(BTreeNode root, int node1, int node2) {
        if (root == null) return null;

        BTreeNode left = findLCA(root.left, node1, node2);
        BTreeNode right = findLCA(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        if (root.val == node1 || root.val == node2) return root;
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        BSTDistance test = new BSTDistance();
        int values[] = {5, 6, 3, 1, 2, 4};
        test.createBST(values, 6);
        System.out.println(test.root.val);
        int res = test.bstDistance(2, 4);
        System.out.println(res);
    }
}
