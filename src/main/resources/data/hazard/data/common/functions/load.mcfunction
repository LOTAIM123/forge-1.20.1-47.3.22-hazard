#function common:removegeneration

#scoreboard stuff
scoreboard objectives add cityvalue dummy
scoreboard objectives add cityvalue2 dummy
stopsound @a
scoreboard players set #-1 cityvalue -1
scoreboard players set #0 cityvalue 0
scoreboard players set #1 cityvalue 1
scoreboard players set #2 cityvalue 2
scoreboard players set #3 cityvalue 3
scoreboard players set #4 cityvalue 4
scoreboard players set #5 cityvalue 5
scoreboard players set #6 cityvalue 6
scoreboard players set #10 cityvalue 10
scoreboard players set #100 cityvalue 100
scoreboard players set rnumber cityvalue 0


#tellraw
scoreboard players add tellrawenable cityvalue 1
execute if score tellrawenable cityvalue = #1 cityvalue run scoreboard players set tellraw cityvalue 1

scoreboard players add tellrawenable1 cityvalue 1
execute if score tellrawenable1 cityvalue = #1 cityvalue run scoreboard players set tellraw1 cityvalue 1
execute if score tellraw1 cityvalue = #1 cityvalue run scoreboard players set currentbiome cityvalue 1

tellraw @a ""

tellraw @a {"text":"Structure gen original creator is MrCube6","color":"red"}
tellraw @a {"text":"www.linktr.ee/MrCube6","color":"blue"}

tellraw @a ""

tellraw @a {"text":"Generate","color":"gold","clickEvent":{"action":"run_command","value":"/function common:startgeneration"},"hoverEvent":{"action":"show_text","contents":[{"text":"Click to generate","color":"green"}]}}
tellraw @a {"text":"Stop Generation","color":"red","clickEvent":{"action":"run_command","value":"/function common:removegeneration"},"hoverEvent":{"action":"show_text","contents":[{"text":"Click to stop","color":"red"}]}}