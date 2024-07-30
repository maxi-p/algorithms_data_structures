#include <stdlib.h>
#include <stdio.h>

typedef struct treeNode
{
  int val;
  struct treeNode *left;
  struct treeNode *right;
} treeNode;

void preorderUtil(treeNode* root);
void inorderUtil(treeNode* root);
void postorderUtil(treeNode* root);

treeNode *createTreeNode(int value)
{
  treeNode *newNode;
  newNode = (treeNode *)malloc(sizeof(treeNode));

  newNode->val = value;
  newNode->left = NULL;
  newNode->right = NULL;

  return newNode;
}

treeNode *insertValue(treeNode *root, int value)
{
  if (root == NULL)
    return createTreeNode(value);

  if (root->val >= value)
    root->left = insertValue(root->left, value);
  else
    root->right = insertValue(root->right, value);

  return root;
}

void freeTree(treeNode *root)
{
  if (root == NULL)
    return;

  freeTree(root->left);
  freeTree(root->right);
  free(root);
}

void traversePreorder(treeNode* root)
{
  preorderUtil(root);
  printf("\n");
}

void traverseInorder(treeNode* root)
{
  inorderUtil(root);
  printf("\n");
}

void traversePostorder(treeNode* root)
{
  postorderUtil(root);
  printf("\n");
}

void preorderUtil(treeNode* root)
{
  if (root == NULL)
    return;
  
  printf("%d ", root->val);
  preorderUtil(root->left);
  preorderUtil(root->right);
}

void inorderUtil(treeNode* root)
{
  if (root == NULL)
    return;
  
  inorderUtil(root->left);
  printf("%d ", root->val);
  inorderUtil(root->right);
}

void postorderUtil(treeNode* root)
{
  if (root == NULL)
    return;
  
  postorderUtil(root->left);
  postorderUtil(root->right);
  printf("%d ", root->val);
}
