(*
CSci 2041 Lab Assignment 9 Tests
James Moen
01 Nov 24
Tests are worth 34 points.
*)
(* THING. The type of a Pure Lisp object, from the lectures. *)
type thing =
    Closure of thing * thing * environment |
    Cons of thing * thing |
    Nil |
    Number of int |
    Primitive of (thing -> environment -> thing) |
    Symbol of string
and
  environment = (string * thing) list ;;
(*
YOUR CODE GOES HERE !!!
*)

open Printf;;

let printThing thing=
  
  let printingThing thing =
    match thing with
      Nil -> printf "nil" |
      Number n -> printf "%i" n |
      Closure (p, b, e) -> printf "[Closure]" |
      Symbol s -> printf "%s" s |
      Primitive h -> printf "[Primitive]" |
      _ -> printf "Unknown"
      
  in let rec printingThings things =
       match things with
         Cons (first, others) ->
           (match first with 
              Cons (_,_) -> Printf.printf "("; printingThings first; Printf.printf ")" |
              _ -> printingThing first);
           (match others with 
              Nil -> () |
              Cons (_,_) -> Printf.printf " "; printingThings others; |
              _ -> printingThing others)
       | _ -> ()

         (*Cons (first, Nil) -> 
          match first with 
            Cons (_,_) -> 
              printf "("; printingThings first; printf ")" |
            _ -> printingThing first |
Cons (first, others) ->
printingThing first;
match others with 
  Cons (_,_) -> 
printf "("; printingThings others; printf ")"|
                                   _ -> printingThing others;
printf "\n" *)
                                
       
  in (match thing with
        Cons (_,_) -> 
          printf "("; printingThings thing; printf ")"|
        _ -> printingThing thing;
          printf "\n");;

(*
  let printThing obj = 
let rec printThinging obj =
  match obj with
    Nil -> printf "nil" |
Number n -> printf "%i" n |
Closure (p, b, e) -> printf "[Closure]" |
Symbol s -> printf "%s" s |
Primitive h -> printf "[Primitive]" |
Cons (first, Nil) -> printThinging first; printf ")" |
                                          Cons (first, others) -> printThinging first; printThinging others
in match obj with
  Cons(_,_) -> printf "(";
    printThinging obj;
    printf "\n";;
*)




(* Tests begin here, simple ones first. The comments say what must
be printed
to get the points. Note that case matters, all the blanks must
     be in their
  right places, there must be no extra blanks, and everything
    printed must
end with a newline. We don't care what PRINT THING returns,
         only what it
           prints. *)
printThing Nil ;; (*
2 pts. nil *)
printThing (Number 7734) ;; (* 2
pts. 7734 *)
printThing (Symbol "lobyms") ;; (* 2
pts. lobyms *)
printThing (Closure (Nil, Nil, [])) ;; (* 2 pts.
[Closure] *)
printThing (Primitive (fun _ _ -> Nil)) ;; (* 2 pts.
[Primitive] *)
(* More complex tests involving lists. *)
printThing (*
2 pts. (a) *)
  (Cons (Symbol "a", Nil)) ;;
printThing (* 2
pts. (a b) *)
  (Cons (Symbol "a", Cons (Symbol "b", Nil))) ;;
printThing (* 2
pts. (a b c) *)
  (Cons (Symbol "a",
         Cons (Symbol "b",
               Cons (Symbol "c", Nil)))) ;;
printThing (* 2 pts.
((a) b c) *)
  (Cons (
      Cons (Symbol "a", Nil),
      Cons (Symbol "b",
            Cons (Symbol "c", Nil)))) ;;
printThing (* 2 pts.
((a b) c) *)
  (Cons (
      Cons (Symbol "a",
            Cons (Symbol "b", Nil)),
      Cons (Symbol "c", Nil))) ;;
printThing (* 2 pts.
(a (b c)) *)
  (Cons (Symbol "a",
         Cons (
           Cons(Symbol "b", Cons (Symbol "c", Nil)),
           Nil))) ;;
printThing (* 2 pts.
((a b c)) *)
  (Cons (
      Cons (Symbol "a",
            Cons (Symbol "b",
                  Cons (Symbol "c", Nil))),
      Nil)) ;;
(* The big finish. All that horror below is the internal OCaml
form of Pure
Lisp code that defines the factorial function. It looks like
this when it's
properly indented.
(define !
(lambda (n)
   (if
     (= n 0)
       1
       ( n (! (- n 1))))))
*)
printThing
  (Cons (Symbol "define",
         Cons (Symbol "!",
               Cons
                 (Cons (Symbol "lambda",
                        Cons (Cons (Symbol "n", Nil),
                              Cons
                                (Cons (Symbol "if",
                                       Cons (Cons (Symbol "=", Cons (Symbol "n", Cons (Number
                                                                                         0, Nil))),
                                             Cons (Number 1,
                                                   Cons
                                                     (Cons (Symbol "*",
                                                            Cons (Symbol "n",
                                                                  Cons
                                                                    (Cons (Symbol "!",
                                                                           Cons
                                                                             (Cons (Symbol "-",
                                                                                    Cons (Symbol "n", Cons (Number 1, Nil))),
                                                                              Nil)),
                                                                     Nil))),
                                                      Nil)))),
                                 Nil))),
                  Nil)))) ;;
(* Soon we will write a function that reads Lisp expressions, so
we don't have
to look at things like this any more. *)




