public class BinaryTree {
    private Node root;

    private class Node {
        String data;
        Node left, right;

        public Node(String data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Metode untuk menyisipkan data ke dalam pohon biner
    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Metode untuk melakukan pencarian dalam pohon biner
   public boolean search(String target) {
    return search(root, target);
}

private boolean search(Node node, String target) {
    if (node == null) {
        return false;
    }

    int compareResult = target.compareTo(node.data);

    if (compareResult < 0) {
        return search(node.left, target);
    } else if (compareResult > 0) {
        return search(node.right, target);
    } else {
        return true; // Data ditemukan
    }
}

    // Metode untuk menghapus data dari pohon biner
    public void delete(String data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, String data) {
        if (root == null) {
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node dengan satu anak atau tanpa anak
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node dengan dua anak, dapatkan node pengganti
            root.data = minValue(root.right);

            // Hapus node pengganti
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private String minValue(Node root) {
        String minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}