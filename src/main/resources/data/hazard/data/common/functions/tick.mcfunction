#debug
#effect give @e[type=armor_stand] glowing infinite 0 true

#generating 4 temporary rooms
execute at @e[tag=baseroom] if entity @p[tag=player,distance=..192] run tag @e[tag=baseroom] add current
execute at @e[tag=current] if entity @p[tag=player,distance=..192] positioned ~ ~ ~-64 unless block ~ ~-1 ~ stone unless block ~ ~-1 ~ stone_bricks unless block ~ ~-1 ~ andesite unless block ~ ~-1 ~ polished_andesite run summon armor_stand ~ ~ ~ {Tags:["temproom"],NoGravity:1b}
execute at @e[tag=current] if entity @p[tag=player,distance=..192] positioned ~ ~ ~64 unless block ~ ~-1 ~ stone unless block ~ ~-1 ~ stone_bricks unless block ~ ~-1 ~ andesite unless block ~ ~-1 ~ polished_andesite run summon armor_stand ~ ~ ~ {Tags:["temproom"],NoGravity:1b}
execute at @e[tag=current] if entity @p[tag=player,distance=..192] positioned ~64 ~ ~ unless block ~ ~-1 ~ stone unless block ~ ~-1 ~ stone_bricks unless block ~ ~-1 ~ andesite unless block ~ ~-1 ~ polished_andesite run summon armor_stand ~ ~ ~ {Tags:["temproom"],NoGravity:1b}
execute at @e[tag=current] if entity @p[tag=player,distance=..192] positioned ~-64 ~ ~ unless block ~ ~-1 ~ stone unless block ~ ~-1 ~ stone_bricks unless block ~ ~-1 ~ andesite unless block ~ ~-1 ~ polished_andesite run summon armor_stand ~ ~ ~ {Tags:["temproom"],NoGravity:1b}
execute at @e[tag=current] run summon armor_stand ~ ~ ~ {Tags:["deadroom"]}
kill @e[tag=current]

#generating new baserooms
execute as @e[tag=temproom] at @s if entity @p[tag=player,distance=..192] run tag @s add baseroom
execute at @e[tag=baseroom] if entity @p[tag=player,distance=..192] run tag @e[tag=baseroom] remove temproom

#random number to room
execute if entity @e[tag=player] as @e[tag=deadroom] store result score @s cityvalue run loot spawn ~ ~-2 ~ loot common:1r30

#generating structure
tag @e[tag=deadroom] add removeroom
execute if score currentbiome cityvalue = #1 cityvalue as @e[tag=deadroom] run function common:structuregen1

#removing unwanted deadrooms
kill @e[tag=removeroom]

#changing city biome
execute if entity @e[tag=player] store result score randomnumber cityvalue run loot spawn ~ ~-2 ~ loot common:1r1000
execute if score randomnumber cityvalue = #1 cityvalue run execute store result score currentbiome cityvalue run loot spawn ~ ~-2 ~ loot common:1r3

execute if score currentambience cityvalue > #0 cityvalue run scoreboard players set currentambience cityvalue 0
