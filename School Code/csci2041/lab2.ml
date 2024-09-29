let num = fst ;; 
let den = snd ;;

let rec gcd i j = 
  if i <> 0 
  then if j > i 
       then gcd i (j - i) 
       else gcd (i - j) j 
  else j ;;

let rat n d = ((n/gcd n d),(d/gcd n d));;

 
let ratAdd a b = rat (num a * den b + num b * den a)  (den a * den b);;


let ratMul a b = rat(num a * num b) (den a * den b);;

let ratDiv a b = rat(num a * den b) (den a * num b);;

let ratGt a b = (float_of_int(num a) /. float_of_int(den a)) > (float_of_int(num b) /. float_of_int( den b));;

(* let factorial num=
    let rec factorialing factors product =
      if factors<=1 then product
      else factorialing (factors-1) (product * (product -1))
      in factorialing num 1;;

let euler = 
  let rec eulering sum iterator epsilon= 
  eulering (ratAdd(sum (ratDiv (1,1) ((factorial iterator),1)))) (iterator + 1) (epsilon)
  in eulering (0,1) 0 (1,100000);;
     *)

let rec euler ()=
  let rec eulering c s t =
    if ratGt (1,100000) t then s
    else let s' = ratAdd s t
  in let t' = ratDiv t c
in let c' = ratAdd c (1,1)
in eulering c' s' t'
in eulering (1,1) (0,1) (1,1);;


(*

euler ()

Let ε be the rational number 1 / 100000. Compute e and return it as the rational number 109601 / 40320, which is approximately 2.71828. This function must use rat, ratAdd, ratMul, ratDiv, and ratGt to perform all arithmetic. The type of euler is unit -> int ∗ int. *)
