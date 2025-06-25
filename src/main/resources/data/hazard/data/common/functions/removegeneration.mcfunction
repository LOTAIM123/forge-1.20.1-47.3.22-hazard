execute at @e[type=armor_stand] run fill ~2 ~-1 ~2 ~-2 ~3 ~-2 air
execute at @e[type=armor_stand] run fill ~2 ~-1 ~2 ~-2 ~-1 ~-2 red_wool
kill @e[type=armor_stand]

tag @a remove player
scoreboard players set currentbiome cityvalue 1
stopsound @a