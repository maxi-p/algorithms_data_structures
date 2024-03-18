#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct monster{
    int id;
    char * name;
    char * element;
    int population;
}monster;

typedef struct region{
    char* name;
    int nmonsters;
    int total_population;
    monster** monsters;
}region;

typedef struct itinerary{
    int nregions;
    region** regions;
    int captures;
}itinerary;

typedef struct trainer{
    char* name;
    itinerary* visits;
}trainer;



monster* getMonsters(int n){
    monster* monsters = (monster*)malloc((n+1)*sizeof(monster));
    for(int i=0;i<n;i++){
        (monsters+i)->id = i;
        char name[30] = "exampleName";
        char object[30] = "exampleElement";
        int population = 42;
        int len = strlen(name);
        (monsters+i)->name = (char*)malloc(len*sizeof(char));
        strcpy((monsters+i)->name,name);
        len = strlen(object);
        (monsters+i)->element = (char*)malloc(len*sizeof(char));
        strcpy((monsters+i)->element,object);
        (monsters+i)->population = population;
    }

    // out-of-bound value for purpose of couting the size of the array in the future
    (monsters+n)->id = n;
    char name[30] = "last";
    char object[30] = "last";
    int population = 42;
    int len = strlen(name);
    (monsters+n)->name = (char*)malloc(len*sizeof(char));
    strcpy((monsters+n)->name,name);
    len = strlen(object);
    (monsters+n)->element = (char*)malloc(len*sizeof(char));
    strcpy((monsters+n)->element,object);
    (monsters+n)->population = population;
    return monsters;
}

void printMonsters(monster* monsters){
    int len = 0;
    // apparently this doesnt work with pointers...
    // len = sizeof(monsters)/sizeof(monster);
    while(strcmp("last",(monsters+len)->name) !=0){
        len++;
    }
    printf("\n");
    for(int i=0;i<len;i++){
        printf("Id: %d\nName: %s\nElement: %s\nPopulation: %d\n\n", (monsters+i)->id, (monsters+i)->name,(monsters+i)->element, (monsters+i)->population);
    }
}

void freeMonsters(monster* monsters){
    free(monsters);
}

int main(void){
    // printf("hello monsters\n");
    monster* monsters;
    monsters = getMonsters(8);
    printMonsters(monsters);
    freeMonsters(monsters);
    return 0;
}