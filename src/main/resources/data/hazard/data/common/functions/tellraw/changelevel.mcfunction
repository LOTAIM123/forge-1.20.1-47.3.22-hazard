scoreboard players add changelevel backroomsvalue 1

execute if score changelevel backroomsvalue = #1 backroomsvalue run scoreboard players set currentbiome backroomsvalue 2
execute if score changelevel backroomsvalue = #1 backroomsvalue run scoreboard players set tellraw1 backroomsvalue 2

execute if score changelevel backroomsvalue = #2 backroomsvalue run scoreboard players set currentbiome backroomsvalue 3
execute if score changelevel backroomsvalue = #2 backroomsvalue run scoreboard players set tellraw1 backroomsvalue 3

execute if score changelevel backroomsvalue = #3 backroomsvalue run scoreboard players set currentbiome backroomsvalue 1
execute if score changelevel backroomsvalue = #3 backroomsvalue run scoreboard players set tellraw1 backroomsvalue 1
execute if score changelevel backroomsvalue = #3 backroomsvalue run scoreboard players set changelevel backroomsvalue 0

function #load