#Random structure

execute as @s if entity @s[scores={cityvalue=11..}] run tag @s add cityblock1
execute as @e[tag=cityblock1] at @s run setblock ~ ~ ~ minecraft:structure_block[mode=load]{mode:"LOAD",name:"common:cityblock1",posX:-2,posY:-1,posZ:-2}
execute as @e[tag=cityblock1] at @s run setblock ~ ~1 ~ redstone_block
execute as @e[tag=cityblock1] at @s run fill ~ ~1 ~ ~ ~ ~ air
tag @e[tag=cityblock1] remove deadroom

execute as @s if entity @s[scores={cityvalue=0..10}] run tag @s add cityblock2
execute as @e[tag=cityblock2] at @s run setblock ~ ~ ~ minecraft:structure_block[mode=load]{mode:"LOAD",name:"common:cityblock2",posX:-2,posY:-1,posZ:-2}
execute as @e[tag=cityblock2] at @s run setblock ~ ~1 ~ redstone_block
execute as @e[tag=cityblock2] at @s run fill ~ ~1 ~ ~ ~ ~ air
tag @e[tag=cityblock2] remove deadroom
