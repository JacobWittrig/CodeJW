let rec howMany item list =
  if list=[] then 0 else
  if (List.hd list=item) then 1 + howMany item (List.tl list)
  else 0 + howMany item (List.tl list);;

  let rec delete item list =
    let rec deleteing item list newlist = 
      if list = [] then List.rev newlist
      else 
      if (List.hd list) = item then deleteing item (List.tl list) newlist
      else deleteing item (List.tl list) ((List.hd list)::newlist)
    in deleteing item list [];;

    let rec mean list =
      let rec meaning list sum count = 
        if list = [] then (sum/.count)
        else meaning (List.tl list) (sum+.(List.hd list)) (count+.1.0)
      in meaning list 0.0 0.;; 
        
