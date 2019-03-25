This solution is written in Python 3, and it is a variation of the knapsack problem. 
The "get_armor_combinations" function takes in five lists of items, which in this case 
are helmets, leggings, chest, boots, and a combined list of all types of armor. It then 
loops through each combination of armor pieces, one from each set, using the 
itertools.product() function. The function checks to make sure that the the armor piece
from the combined list is not already in the current set of armor, to prevent duplicate 
armor pieces in a set. Each possible set of armors that can be purchased is appended to 
the result list that is returned after theloop is complete. 

The "totalvalue" function takes in this list of armor sets as an argument. It sums up
the total cost and total value of an armor set and checks to make sure that the cost is
less than or equal to 300 crowns, the current max amount of money we can spend right
now. It then returns the total cost and total value of the armor set. 

Below that function is the list of armors separated by armor type. Each armor piece
in the lists have a name, cost, and value listed in that order in a tuple. 

To calculate the best set, we use the "get_armor_combinations" function to return
the list of armor sets, and the "max" function to return the set with the highest 
total value. Then we print out the set of armor with the highest value that cost less
than or equal to 300 crowns and contains one piece of armor from each type, and an 
extra piece, which is the solution. For this particular inventory list, the solution
is: 

  Armor de Jandro
  Chestpiece of Vachon
  Cloth Shoes
  Famed Pon Leggings
  Keeton Mask

With a total armor value of 141 and a total cost of 299 crowns.

This algorithm works for any inventory set listed in the same way, with the types of 
armor sorted into different lists and the amount of crowns on hand equal to 300.