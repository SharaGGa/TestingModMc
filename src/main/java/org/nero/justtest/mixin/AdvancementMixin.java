package org.nero.justtest.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.client.gui.components.toasts.AdvancementToast;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.nero.justtest.Sound;

@Mixin(AdvancementToast.class)
public abstract class AdvancementMixin {
    @Final
    @Shadow
    private Advancement advancement;
    @Shadow
    private boolean playedSound;

    @Inject(method = "render", at = @At(value = "HEAD"))
    protected void advtoast(PoseStack p_94800_, ToastComponent p_94801_, long p_94802_, CallbackInfoReturnable<Toast.Visibility> cir)
    {
        DisplayInfo dspnfo = this.advancement.getDisplay();
        if (!this.playedSound) {
            assert dspnfo != null;
            if(dspnfo.getFrame() == FrameType.CHALLENGE)
                p_94801_.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F));
            else if(dspnfo.getFrame() == FrameType.GOAL)
                p_94801_.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(Sound.GOAL_NOTIFY.get(), 1.0F, 1.0F));
            else
                p_94801_.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(Sound.ADV_NOTIFY.get() , 1.0F, 1.0F));
            this.playedSound = true;

        }
    }
}
