let rat n d = (n,d);;

(* Return the rational number whose numerator is the integer n and whose denominator is the integer d. The type of rat is int -> int -> int ∗ int. You may assume that n ≥ 0 and d > 0. Hints: use gcd. Do not compute the gcd of n and d more than once.

ratAdd a b

Return the rational number that is the sum of the rational numbers a and b. The type of ratAdd is int ∗ int -> int ∗ int -> int ∗ int. Hint: use rat.

ratMul a b

Return the rational number that is the product of rational numbers a and b. The type of ratMul is int ∗ int -> int ∗ int -> int ∗ int. Hint: use rat.

ratDiv a b

Return the rational number that is the quotient of the rational numbers a and b. The type of ratDiv is int ∗ int -> int ∗ int -> int ∗ int. You may assume that b ≠ 0. Hint: use rat.

ratGt a b

If the rational number a is greater than the rational number b, then return true, otherwise return false. The type of ratGt is int ∗ int -> int ∗ int -> bool. Hint: do not use an if–then–else.

euler ()

Let ε be the rational number 1 / 100000. Compute e and return it as the rational number 109601 / 40320, which is approximately 2.71828. This function must use rat, ratAdd, ratMul, ratDiv, and ratGt to perform all arithmetic. The type of euler is unit -> int ∗ int. *)
