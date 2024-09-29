def list_construct():
    val="value"
    return_list=[]
    while(val!=""):
        val=input("Insert word:")
        if(val!=""):
            first_letter=val[0]
            val=val[1:]
            if(first_letter.lower() in val.lower()):
                return_list.append(first_letter+val)
    return return_list
