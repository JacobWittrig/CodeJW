#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "dictionary.h"

// This function creates a dictionary struct and returns a pointer to it
dictionary_t *create_dictionary() {
    dictionary_t *dict = malloc(sizeof(dictionary_t));
    if (dict == NULL) {
        return NULL;
    }
    dict->root = NULL;
    dict->size = 0;
    return dict;
}

// Helper to prepare a new node. Notice the
// lack of a malloc() call in this function.
// Usage:
//   node_t *n = malloc(sizeof(node));
//   new_node(n, word);
// You don't need to use this function, but it is a nice helper.
// This code is correct and should not be modified.
void new_node(node_t* node, const char *key) {
    strcpy(node->word, key);
    node->left = NULL;
    node->right = NULL;
    node->height = 1;
}

// Helper: Larger of two numbers
int max(int a, int b) {
    return (a > b) ? a : b;
}
// Helper to perform the "right" rotation.
// This code is correct and you should not modify it.
node_t *rotate_right(node_t *y)
{
    node_t *x = y->left;
    node_t *t = x->right;
    x->right = y;
    y->left = t;
    y->height = max((y->left != NULL) ? y->left->height : 0, 
                    (y->right != NULL) ? y->right->height : 0) + 1;
    x->height = max((x->left != NULL) ? x->left->height : 0, 
                    (x->right != NULL) ? x->right->height : 0) + 1;
    return x;
}

// Helper to perform the "left" rotation.
// This code is correct and you should not modify it.
node_t *rotate_left(node_t *x)
{
    node_t *y = x->right;
    node_t *t = y->left;
    y->left = x;
    x->right = t;
    x->height = max((x->left != NULL) ? x->left->height : 0, 
                    (x->right != NULL) ? x->right->height : 0) + 1;
    y->height = max((y->left != NULL) ? y->left->height : 0, 
                    (y->right != NULL) ? y->right->height : 0) + 1;
    return y;
}

// You may find writing your own helper functions
// to be useful.
int power(int base, int raise){
    if(raise<=1){
        return 1;
    }
    int total=base;
    while(raise>0){
        total*=base;
        raise--;
    }
    return total;
}
//need a power helper function in order to do powers with rotations

int dict_insert(dictionary_t *dict, const char *word) {
    node_t *nodenew = malloc(sizeof(node_t));
    new_node(nodenew,word);
    nodenew->height=1;
    if(dict->size==0){
        dict->root=nodenew;
        dict->size++;
        return 1;
    }//if dict empty then easy to add new node as root
    else  {
        node_t *start= dict->root;
        while(1){//assume that logic will not fail and always will add the word
            nodenew->height++;
            if(strcmp(start->word,word)>0){
                //left child
                if(start->left==NULL){//add if needed
                    start->left=nodenew;
                    dict->size++;

                    //test to see if rotation is needed
                    if(power(2,nodenew->height-2)>dict->size){
                        //left subtree
                        if(strcmp(word,dict->root->word)<0){
                            dict->root=rotate_right(dict->root);//calls rotate function in order to balance AVL
                        }
                        
                        //right subtree
                        else{
                            dict->root=rotate_left(dict->root);//calls rotate function in order to balance AVL
                        }
                    }
                    return 1;
                }
                else {
                    start=start->left;
                }
                
            }
            else{
                //right child
                if(start->right==NULL){//add if needed
                    start->right=nodenew;
                    dict->size++;
                    if(power(2,nodenew->height-2)>dict->size){
                        //left subtree
                        if(strcmp(word,dict->root->word)<0){
                            dict->root=rotate_right(dict->root);//calls rotate function in order to balance AVL
                        }
                        
                        //right subtree
                        else{
                            dict->root=rotate_left(dict->root);//calls rotate function in order to balance AVL
                        }
                    }
                    return 1;
                }
                else {
                    start=start->right;
                }
            }
            
        }
        

    }
    return 0;//redundant code to return 0 if some kind of failure
}

int dict_find(const dictionary_t *dict, const char *query) {
    if(dict==NULL || dict->size==0){
        return 0;//cannot find word if dict empty
    }
    node_t *start= dict->root;//node will move down tree to find the word
    
    while(start!=NULL){//if start is NULL then we did not find the word
        int comp=strcmp(query,start->word);
        if(comp==0){//find the word
            return 1;
        }
        else if(comp<0){
            if(start->left==0){//checks to see if left side empty
                return 0;
            }
            else{
                start=start->left;
            }
        }
        else {
            if(start->right==0){//same as above, but for right side
                return 0;
            }
            else{
                start=start->right;
            }
        }       
    }
    
    return 0;
}
void node_print(const node_t *node){//recursive function to first print left nodes, then itself, then right nodes
    if(node->left!=NULL){
        node_print(node->left);
    }
    printf("%s\n",node->word);
    if(node->right!=NULL){
        node_print(node->right);
    }
}

void dict_print(const dictionary_t *dict) {
    // calls a recursive function to print
    if(dict->size==0){
        return;
    }
    node_print(dict->root);
    return;
}

void node_free(node_t *node){//recursive function which works the same as the recursive print to free nodes
    if(node->left!=NULL){
        node_free(node->left);
    }
    if(node->right!=NULL){
        node_free(node->right);
    }
    free(node);
    return;
}

void dict_free(dictionary_t *dict) {
    // works the same as the dict print, except with freeing
    if(dict->size==0){
        free(dict);
        return;
    }
    node_free(dict->root);
    free(dict);
    return;

}

dictionary_t *read_dict_from_text_file(const char *file_name) {
    
    FILE *file;
    file = fopen(file_name, "r");
    if(file==NULL){
        printf("Failed to read dictionary from text file\n");
        return NULL;
    }//open file
    dictionary_t *dict = create_dictionary();
    char newword [MAX_WORD_LEN];
    while(fgets(newword,MAX_WORD_LEN,file)){
        newword[strcspn(newword, "\n")] = 0;
        //thank you to the kind people at 
        //https://stackoverflow.com/questions/2693776/removing-trailing-newline-character-from-fgets-input
        //for helping me to figure out how to remove enline from my strings
        dict_insert(dict,newword);
        dict->size++;
    }
    if(fclose(file)==EOF){
        printf("Error closing file\n");
    }//close file, handle errors
    return dict;
}

void file_node_print(const node_t *node, FILE *file){//recursive function to print nodes to file
    if(node->left!=NULL){
        file_node_print(node->left,file);
    }
    fprintf(file, "%s\n",node->word);
    //prints word to file with endline
    fflush(file);//makes sure printing goes through
    if(node->right!=NULL){
        file_node_print(node->right,file);
    }
}

void file_dict_print(const dictionary_t *dict, FILE *file) {
    // function which calls recursive functionabove the print nodes to files
    
    if(dict->size==0){
        return;
    }
    file_node_print(dict->root, file);
    return;
}

int write_dict_to_text_file(const dictionary_t *dict, const char *file_name) {
    FILE *file = fopen(file_name,"w");
    if(file==NULL){
        perror("Failed to write dictionary to text file");
        return 0;
    }//opens, checks for errors
    
    file_dict_print(dict,file);//calls helper function to make sure that file is printed into
    if(fclose(file)==EOF){
        printf("Error closing file\n");
    }
    //closes file, checks for errors
    return 1;
}
