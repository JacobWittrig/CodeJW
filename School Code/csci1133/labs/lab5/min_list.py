def minimum_index(in_list,index_start):
    copy_list=in_list[index_start:]
    index=0
    minimum=100
    for i in range(len(copy_list)):
        if copy_list[i]<minimum:
            minimum=copy_list[i]
            index=i
    return index+index_start
            
