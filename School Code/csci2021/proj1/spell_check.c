#include <ctype.h>
#include <stdio.h>
#include <string.h>

#include "dictionary.h"

#define MAX_CMD_LEN 128

// A helper function to spell check a specific file
// 'file_name': Name of the file to spell check
// 'dict': A dictionary containing correct words
int spell_check_file(const char *file_name, const dictionary_t *dict) {
    FILE *file;
    file = fopen(file_name, "r");
    if(file==NULL){
        return 0;
    }
    //opens file and handles error
    char newline[MAX_WORD_LEN];
    
    int found;
    while(fgets(newline,MAX_WORD_LEN,file)){
        //gets newline, removes endline
        //thank you to the kind people at 
        //https://stackoverflow.com/questions/2693776/removing-trailing-newline-character-from-fgets-input
        //for helping me to figure out how to remove endline from my strings
        newline[strcspn(newline, "\n")] = 0;
        char *newword = strtok(newline, " ");
        //splits newline into different words, which can be iterated through by strtok
        //thank you to
        //https://stackoverflow.com/questions/3889992/how-does-strtok-split-the-string-into-tokens-in-c
        //for explaining strtok
        while(newword!=NULL){
            printf("%s",newword);
            found=dict_find(dict,newword);
        if(!found){
            printf("[X]");
        }
        printf(" ");
        newword = strtok(NULL, " ");
        }
        //prints out the word, then X if not found
        
        
        printf("\n");
    }
    if(fclose(file)==EOF){
        printf("Error closing file\n");
    }
    return 1;
    //close, return
}

/*
 * This is in general *very* similar to the list_main file seen in lab
 */
int main(int argc, char **argv) {
    dictionary_t *dict = NULL;
    dict = create_dictionary();
    char cmd[MAX_CMD_LEN];

    //now to take in command line args
    if(argc==2){
        dict_free(dict);
            dict = read_dict_from_text_file(argv[1]);   // call list function
            if(dict!=NULL){
                printf("Dictionary successfully read from text file\n");
                
            }
            else{
                return 0;//handles failure
            }
    }//read dict if two commands

    else if (argc==3){
        dict_free(dict);
            dict = read_dict_from_text_file(argv[1]);   // call list function
            if(dict!=NULL){
                printf("Dictionary successfully read from text file\n");
            }
            else{
                return 0;//handles failure
            }
            
        int success = spell_check_file(argv[2],dict);
        
        dict_free(dict);
        if(!success){
            printf("Spell check failed\n");
            return 0;}
        return 1;
    }//read and spellcheck file if three commands

    printf("CSCI 2021 Spell Check System\n");
    printf("Commands:\n");
    printf("  add <word>:              adds a new word to dictionary\n");
    printf("  lookup <word>:           searches for a word\n");
    printf("  print:                   shows all words currently in the dictionary\n");
    printf("  load <file_name>:        reads in dictionary from a file\n");
    printf("  save <file_name>:        writes dictionary to a file\n");
    printf("  check <file_name>: spell checks the specified file\n");
    printf("  exit:                    exits the program\n");

    while (1) {
        printf("spell_check> ");
        int success;
        if (scanf("%s", cmd) == EOF) {
            printf("\n");
            break;
        }

        if (strcmp("exit", cmd) == 0) {
            // dict_free(dict);
            break;
        }

        
        else if (strcmp("add", cmd) == 0) { // insertion
            scanf("%s", cmd);          // read string to insert

            success = dict_insert(dict, cmd);   // call insert function
            if (!success) {                      // check for success
                printf("insert failed\n");
            }
        }

        else if (strcmp("print", cmd) == 0) {   // print dictionary
            dict_print(dict);
        }


        else if (strcmp("lookup", cmd) == 0) {
    
            scanf("%s", cmd);
            success = dict_find(dict, cmd);   // call find function
            
            if (success) {                      // check for success
                printf("'%s'", cmd);
                printf(" present in dictionary\n");
            }
            else {
                printf("'%s' not found\n",cmd);
            }
        }

        else if(strcmp("load",cmd)==0){
            dict_free(dict);
            scanf("%s", cmd);
            dict = read_dict_from_text_file(cmd);   // call read from file function
            if(dict!=NULL){
                printf("Dictionary successfully read from text file\n");
            }
            
        }

        else if(strcmp("save",cmd)==0){
            scanf("%s", cmd);
            success = write_dict_to_text_file(dict,cmd);   // call to text file function
            if (success) {                      // check for success
                printf("Dictionary successfully written to text file\n");
            }
            else {
                printf("not found\n");
            }
        }

        else if(strcmp("check",cmd)==0){
            scanf("%s", cmd);
            success = spell_check_file(cmd,dict);   // call spell check function
            if (success) {                      // check for success
                //nothing needed according to specks, here for if coded needed to be modified
            }
            else {
                printf("Spell check failed\n");
            }
        }

        else {                                 // unknown command
            printf("Unknown command %s\n",cmd);
        }

    }

    if(dict!=NULL)
        dict_free(dict);
    return 0;//free dict after quit
}
