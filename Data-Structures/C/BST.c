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

struct node* find_minimum(node *root){
    if(root == NULL)
        return NULL;
    else if(root->left != NULL) 
        return find_minimum(root->left); 
    return root;
}

struct node* delete_node(node *root, int num){
    if(root==NULL){
        return new_node(num);
    }
    if(num<root->data){
        root->left = delete_node(root->left, num);
    }else if(num>root->data){
        root->right = delete_node(root->right, num);
    }else{
        if(root->left == NULL && root->right == NULL){
            free(root);
            return NULL;
        }
        else if(root->left==NULL || root->left==NULL){
            node *temp_node;
            if(root->left==NULL)
                temp_node = root->right;
            else
                temp_node = root->left;
            free(root);
            return temp_node;
        }else{
            struct node *temp_node = find_minimum(root->right);
            root->data = temp_node->data;
            root->right = delete_node(root->right, temp_node->data);
        }
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

    root = delete_node(root, 5);
    printf("\n");
    inorder(root);
  
    return 0;
}