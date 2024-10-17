type 'base sequence = 
    Empty | 
    Node of 'base * 'base sequence ;;
(*The given sequence defintion*)

let basehead seq=
  match seq with Empty->Empty |
    Node(first,_) ->
      Node(first,Empty);;
(*Gives head of sequence*)

let basetail seq=
  match seq with Empty->Empty |
    Node(_,rest) ->
      rest;;
(*Gives tail of sequence*)

let baseaddfront seq base=
  match base with
    Empty ->seq |
    Node(first,Empty)->
      Node(first,seq);;
(*Adds base to the front of sequence*)

let rec baseaddback seq base=
  match (seq,base) with
    (Empty,_)->base|
    (_,Empty)->seq|
    (Node(first,Empty),base)->
      Node(first,base)|
    (Node(first,rest),base)->
      baseaddfront (baseaddback rest base) (Node(first,Empty));;
(*Adds base to the end of sequence. Needs recursion to copy over
Nodes until we get to the last Node where we can add base*)

let rec baserevappend seq1 seq2=
  match (seq1,seq2) with
    (Empty,_)-> seq2 (*the final return (line 29)*)|
    (Node(first,rest),_) -> baserevappend rest (baseaddfront seq2 (Node(first, Empty)));;
(*Reverses seq1 and adds seq2 to the back, needed because of the way I sorted
things backwards*)

let rec combinesort l r s = 
  match (l,r) with
    (Empty,_) -> baserevappend s r (*the final return (line 29) is here*)|
    (_,Empty) -> baserevappend s l (*or here*)|
    (Node(first,rest),(Node(first',rest')))-> (*The loop that combines l and r into s*)
      if(compare first first' < 0) 
      then combinesort rest r (baseaddfront s (Node(first,Empty)))
      else combinesort l rest' (baseaddfront s (Node(first',Empty)));;
(*Combines the left and right into sequence using recursion*)

let rec sort u =
  let rec split u l r=
    (*The loop that splits u into l and r  (lines 05–17)*)
    match u with
      Empty -> (sort l, sort r) (*the recursive calls that sort l and r (lines 18–19)*)|
      Node(_,Empty) -> split (basetail u) (baseaddfront l (basehead u)) r |
      _ -> split (basetail (basetail u)) (baseaddfront l (basehead u)) (baseaddfront r (basehead (basetail u)))
  in match u with
    Empty ->u|
    Node(_,Empty)->u|
    (*The base case (lines 02–03)*)
    _ ->combinesort (fst (split u Empty Empty)) (snd (split u Empty Empty)) Empty;;
(*'split' is the Call to the loop that splits u into l and r  (lines 05–17),
Combinesort will combine the lists 'The loop that combines l and r into s', 
eventually leading to the final return (line 29)*)
(*Sorts the sequence. The 'main' driver code, contains an internal
helper Split which splits the sequence into tiny parts.*)

(*TEST CASES, if you would like*)
basehead (Node(1,Node(2,(Node(3,Node(4,Node(5,(Node(6,Empty)))))))));;
(*int sequence = Node (1, Empty)*)
basetail (Node(1,Node(2,(Node(3,Node(4,Node(5,(Node(6,Empty)))))))));;
(*int sequence = Node (2, Node (3, Node (4, Node (5, Node (6, Empty)))))*)
baseaddfront (Node(1,Node(2,(Node(3,Empty))))) (Node(0,Empty));;
(*int sequence = Node (0, Node (1, Node (2, Node (3, Empty))))*)
baseaddback (Node(1,Node(2,(Node(3,Empty))))) (Node(4,Empty));;
(*int sequence = Node (1, Node (2, Node (3, Node (4, Empty))))*)
baserevappend (Node(1,Node(2,(Node(3,Empty))))) (Node(4,Node(5,(Node(6,Empty)))));;
(*Node (3, Node (2, Node (1, Node (4, Node (5, Node (6, Empty))))))*)
combinesort (Node(1,Node(2,(Node(3,Empty))))) (Node(4,Node(5,(Node(6,Empty)))));;
(*No output, as it is as it uses continuation passing style to call baserevappend*)
sort (Node(3,Node(1,(Node(4,Node(1,Node(5,(Node(9,Empty)))))))));;
(*Node (1, Node (1, Node (3, Node (4, Node (5, Node (9, Empty))))))*)
sort (Node("AAAA",Node("BBDD",(Node("ZZZZ",Node("EEFF",Node("DDDD",(Node("IIII",Empty)))))))));;
(*Node ("AAAA",Node ("BBDD",Node ("DDDD", Node ("EEFF", Node ("IIII", Node ("ZZZZ", Empty))))))*)
   
(*Thanks for looking at my code, have a good one*)
(*wittr049*)
(*Jacob Wittrig*)

