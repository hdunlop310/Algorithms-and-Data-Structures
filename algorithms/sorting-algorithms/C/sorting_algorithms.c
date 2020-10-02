#include <stdio.h>
#include <stdlib.h> 

void insertion_sort(int array[10], int array_size);
void bubble_sort(int array[10], int array_size);
void print_array(int array[10]);
void swap(int *a, int *b);

void insertion_sort(int array[10], int array_size){
    int i, j, key;
    for(i = 0; i < array_size; ++i){
        key = array[i];
        j = i - 1;
        while(j >= 0 && array[j] > key){
            array[j+1] = array[j];
            j -= 1;
        }
        array[j+1] = key;
    }
    printf("insertion sorted array: ");
    print_array(array);
}

void bubble_sort(int array[10], int array_size){
    int i, j, temp;
    for(i = 0; i < array_size; ++i){
        for(j = 0; j < array_size-i-1; ++j){
            if(array[j] > array[j+1]){
                temp = array[j]; 
                array[j] = array[j+1]; 
                array[j+1] = temp; 
                swap(&array[j], &array[j+1]);
            }
        }
    }
    printf("bubble sorted array: ");
    print_array(array);
}


void print_array(int array[10]){
    int k;
    for(k = 0; k < 10; ++k){
        printf("%d ", array[k]);
    }
}

void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

int main(){
    int array[10] = {4, 5, 6, 8, 3, 6, 2, 9, 1, 7};
    int arr_size = sizeof(array) / sizeof(array[0]);
    printf("unsorted array: ");
    print_array(array);
    printf("\n");
    insertion_sort(array, arr_size);
    printf("\n");
    bubble_sort(array, arr_size);
    printf("\narray size: %d\n", arr_size);
    return 0;
}