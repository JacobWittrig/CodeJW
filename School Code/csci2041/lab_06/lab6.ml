(*
CSci 2041 Lab Assignment 6
James Moen
14 Oct 24
It's worth 35 points.
*)
(* MUTY QUEUE. A mutable queue of BASEs, as a circular doubly linked list. The
type doesn't say that the list is circular or doubly linked. That's done by
the functions that manipulate MUTY QUEUEs. *)
type 'base mutyQueue =
    MutyQueueNode of
      'base *
      'base mutyQueue ref *
      'base mutyQueue ref ;;
(*
Put your code for MUTY QUEUE MAKE, MUTY QUEUE EMPTY, MUTY QUEUE ENQUEUE and
MUTY QUEUE DEQUEUE here.
*)
let mutyQueueMake s=
  let rec h = MutyQueueNode (s, ref h, ref h) 
  in h;;

let mutyQueueEmpty q=
  match q with
    MutyQueueNode (_, left, right) -> ((q == (! left)) && (q == (! right))) |
    _ -> false;;


let mutyQueueEnqueue q e=
  match q with
    MutyQueueNode (_, left, _) ->
      match ! left with
        MutyQueueNode (_, _, right) ->
          let n = MutyQueueNode(e,ref ! left, ref ! right)
          in left := n;
          right :=n;; 


let mutyQueueDequeue q=
  match q with
  | MutyQueueNode (_, _, right) ->
      match ! right with
        MutyQueueNode (element, _, right' ) ->
          match ! right' with
            MutyQueueNode (_, left, _ ) ->
              left:= q;
              right := ! right';
              element;;
(* Make a QUEUE whose sentinel is the empty string "" and test it. The comments
say what each test should return, and how many points you get (if any) for
successful tests. *)
let queue = mutyQueueMake "" ;;
(* 2 pt. MutyQueueNode ("", {contents = <cycle>}, {contents = <cycle>}) *)

mutyQueueEmpty queue ;; (* 2 pt. true *)
                        
mutyQueueDequeue queue ;; (* 2 pt. "" *)
mutyQueueEnqueue queue "A" ;; (* 1 pt. () *)
mutyQueueEmpty queue ;; (* 2 pt. false *)
mutyQueueEnqueue queue "B" ;; (* 1 pt. () *)
mutyQueueEnqueue queue "C" ;; (* 1 pt. () *) 
mutyQueueDequeue queue ;; (* 5 pt. "A" *)
mutyQueueDequeue queue ;; (* 5 pt. "B" *)
mutyQueueDequeue queue ;; (* 5 pt. "C" *)
mutyQueueEmpty queue ;; (* 2 pt. true *)
mutyQueueDequeue queue ;; (* 5 pt. "" *)
mutyQueueDequeue queue ;; (* 2 pt. "" *)
