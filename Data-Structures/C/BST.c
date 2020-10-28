#include<stdio.h>
#include <stdlib.h>

typedef struct node{
    struct node *left;
    struct node *right;
    int data;
}node;

struct node* new_node(int data){
    node *n = (node*)malloc(sizeof(node));
    n->data=data;
    n->left = NULL;
    n->right = NULL;
    return n;
}

struct node* insert_node(node *root, int num){
    if(root==NULL){
        return new_node(num);
    }
    else if(num<root->data){
        root->left = insert_node(root->left, num);
    }else{
        root->right = insert_node(root->right, num);
    }
    return root;
}

void inorder(node *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%d \n", root->data);
        inorder(root->right);
    }
}

int main(){
    node *root = new_node(1);
    insert_node(root, 2);
    insert_node(root, 5);
    insert_node(root, 10);
    insert_node(root, 9);
    insert_node(root, 13);
    insert_node(root, 18);

    inorder(root);
  
    return 0;
}