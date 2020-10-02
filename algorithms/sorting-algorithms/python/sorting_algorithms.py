#Sorting Algorithms

def swap(array,i,j):
    array[j], array[i] = array[i], array[j]

def bubble_sort(array):
    for i in range(len(array)):
        for j in range(0, len(array)-i-1):
            if array[j] > array[j+1]:
                swap(array, j, j+1)
    return array

def insertion_sort(array):
    for i in range(1, len(array)):
        key = array[i]
        j = i-1
        while j >= 0 and array[j] > key:
            array[j+1] = array[j]
            j -= 1
        array[j+1] = key
    return array


def merge_sort(array):
    if len(array) > 1:
        m = len(array)//2

        left_array = array[:m]
        right_array = array[m:]
        left_array = merge_sort(left_array)
        right_array = merge_sort(right_array)

        sorted_array = []

        while (len(left_array) > 0) and (len(right_array) > 0):
            if left_array[0] < right_array[0]:
                sorted_array.append(left_array[0])
                left_array.pop(0)
            else:
                sorted_array.append(right_array[0])
                right_array.pop(0)
        
        for i in left_array:
            sorted_array.append(i)
        for i in right_array:
            sorted_array.append(i)
    return array

def partition(array, low, high):
    i = low-1
    
    

def main():
    array = [4, 7, 1, 3, 10, 50, 23, 11, 24]
    print("array: {0}".format(array))
    print("Bubble sorted array: {0}".format(bubble_sort(array)))
    print("Insertion sorted array: {0}".format(insertion_sort(array)))
    print("Merge sorted array: {0}".format(merge_sort(array)))

if __name__ == "__main__":
    main()