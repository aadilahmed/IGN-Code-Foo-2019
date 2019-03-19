#!/usr/bin/env python
# coding: utf-8

# In[7]:


from itertools import product

def anycomb(item1, item2, item3, item4, item5):
    result = []
    for armor_set in product(item1, item2, item3, item4, item5):
        if armor_set[4] not in [armor_set[0], armor_set[1], armor_set[2], armor_set[3]]:
            result.append(armor_set)
    return result

def totalvalue(armor_set):
    totcost = totval = 0
    for item, cost, val in armor_set:
        totcost  += cost
        totval += val
    return (totval, -totcost) if totcost <= 300 else (0, 0)

def sort_inventory(armor_set):
    helmets = []
    leggings = []
    chest = []
    boots = []
    for armor in armor_set:
        for armor_type, item, cost, val in armor:
            if armor_type is "helmet":
                helmets.append(armor)
            elif armor_type is "leggings":
                leggings.append(armor)
            elif armor_type is "chest":
                chest.append(armor)
            else:
                boots.append(armor)
                
    return helmets, leggings, chest, boots

helmets = (
    ("Serpentine Cruz Headpiece", 90, 23), ("Keeton Mask", 77, 24), ("Feline Visor", 68, 16), 
    ("Ornate Helment of Cagampan", 60, 16), ("Offner Protector", 54, 15), ("Leather Helmet", 49, 13), 
     ("Sligar's Noggin Protector", 46, 12), ("Glass Bowl", 44, 12))
leggings = (
    ("Famed Pon Leggings", 87, 22), ("Ursine Trousers", 78, 18), ("Wolven Shinguards", 75, 15),
    ("Hansen's Breeches", 69, 17), ("Griffin Pants", 62, 11), ("Tanned Leg Protection", 59, 15), 
    ("Manticore Braces", 56, 12), ("Mail Emares Leggings", 53, 14), ("Woven Leggings", 47, 11), 
    ("Silken Pants", 45, 10), ("Tattered Shorts", 42, 13))
chest = (
    ("Armor de Jandro", 67, 22), ("Chestpiece of Vachon", 64, 23), ("Kaer Morhen Armor", 62, 21), 
    ("Cured Leather Chestpiece", 59, 20), ("Smith's Plated Chest Guard", 58, 10),
    ("Dented Plate Armor", 57, 19), ("Jeweled Drake Tunic", 55, 19), ("Ginger's Gilded Armor", 54, 18),
    ("Garcia Guard", 50, 17))
boots = (
    ("Diamond Boots", 64, 18), ("Steel Boots", 52, 14), ("Tate's Spiked Cleats", 52, 20), 
    ("Leather Lunde Shoes", 35, 7), ("Cloth Shoes", 4, 50))

combined_list = helmets + leggings + chest + boots

best_set = max(anycomb(helmets, leggings, chest, boots, combined_list), key=totalvalue) # max val or min wt if values equal

print("Armor set with the highest value is:\n  " +
     '\n  '.join(sorted(item for item,_,_ in best_set)))
val, wt = totalvalue(best_set)
print("for a total value of %i and a total cost of %i crowns" % (val, -wt))

