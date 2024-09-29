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
        
(* # #use "main.ml";;  
val howMany : 'a -> 'a list -> int = <fun>
val delete : 'a -> 'a list -> 'a list = <fun>
val mean : float list -> float = <fun>
# #use "tests1.ml";;
val printThings : ('a -> 'b, out_channel, unit) format -> 'a list -> unit =
  <fun>
0
- : unit = ()
1
- : unit = ()
1
- : unit = ()
0
- : unit = ()
2
- : unit = ()
0
- : unit = ()
[]
- : unit = ()
[]
- : unit = ()
[2 ; 3]
- : unit = ()
[1 ; 2 ; 3]
- : unit = ()
[2 ; 3 ; 4]
- : unit = ()
[x ; y]
- : unit = ()
1.000000
- : unit = ()
1.500000
- : unit = ()
0.250000
- : unit = () *)