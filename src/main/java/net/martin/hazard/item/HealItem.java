package net.martin.hazard.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class HealItem extends Item {

    private boolean hasPlayedSound = false;

    public HealItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    /*@Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!world.isClientSide && !hasPlayedSound) {
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 1.0F, 1.0F);
            hasPlayedSound = true;
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        // Call the superclass to handle food effects and stack reduction
        ItemStack result = super.finishUsingItem(stack, world, entity);

        if (!world.isClientSide && entity instanceof Player player) {
            // Add custom effects or logic here if needed
        }

        return result; // Return the result from the superclass
    }*/
}